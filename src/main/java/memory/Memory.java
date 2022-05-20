package memory;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import memory.NumberConversion.NumberFormat;

public class Memory implements Closeable {
	
	private final MemoryList memory;
	private final NumberConversion conversion;
	
	public Memory(NumberFormat format) throws IOException {
		this(true, format);
	}
	
	public Memory(boolean deleteFileOnClose, NumberFormat format) throws IOException {
		memory = new MemoryList((long) Math.pow(2, 32), deleteFileOnClose);
		conversion = switch (format) {
			case LITTLE_ENDIAN -> new LittleEndianNumberConversion();
			case BIG_ENDIAN -> new BigEndianNumberConversion();
		};
	}
	
	public byte getByte(long i) throws IOException {
		return memory.getByte(i);
	}
	
	public void setByte(long i, byte value) throws IOException {
		memory.setByte(i, value);
	}
	
	public int getWord(long i) throws IOException {
		return conversion.bytesToInt32(
				new byte[]{getByte(i), getByte(i + 1), getByte(i + 2), getByte(i + 3)});
	}
	
	public void setWord(long i, int value) throws IOException {
		for (byte currentByte : conversion.int32ToBytes(value)) {
			setByte(i, currentByte);
			i++;
		}
	}
	
	public short getHalfWord(long i) throws IOException {
		return conversion.bytesToInt16(new byte[]{getByte(i), getByte(i + 1)});
	}
	
	public void setHalfWord(long i, short value) throws IOException {
		for (byte currentByte : conversion.int16ToBytes(value)) {
			setByte(i, currentByte);
			i++;
		}
	}
	
	@Override
	public void close() throws IOException {
		memory.close();
	}
	
	private static class MemoryList implements Closeable {
		
		private static final int MAX_CACHE = 256;
		
		private final boolean deleteFileOnClose;
		private final long size;
		private final List<Entry> lastValues = new ArrayList<>(MAX_CACHE);
		private final Path memoryFile;
		private final RandomAccessFile randomAccessFile;
		
		public MemoryList(long size, boolean deleteFileOnClose) throws IOException {
			this.deleteFileOnClose = deleteFileOnClose;
			int index = 0;
			while (Files.exists(Path.of("Memory-file" + index + ".mem"))) {
				index++;
			}
			memoryFile = Files.createFile(Path.of("Memory-file" + index + ".mem"));
			
			randomAccessFile = new RandomAccessFile(memoryFile.toFile(), "rwd");
			// pad the file to final size already
			randomAccessFile.setLength(size);
			this.size = size;
		}
		
		public long size() {
			return size;
		}
		
		private void putNewLastValue(long realIndex, byte value) {
			if (lastValues.size() == MAX_CACHE) {
				lastValues.remove(0);
			}
			lastValues.add(new Entry(realIndex, value));
		}
		
		public byte getByte(long i) throws IOException {
			long realIndex = i % size;
			Optional<Byte> foundValue = lastValues.stream()
					.filter(entry -> entry.address == realIndex)
					.map(Entry::getValue)
					.findAny();
			if (foundValue.isPresent())
				return foundValue.get();
			randomAccessFile.seek(realIndex);
			byte output = randomAccessFile.readByte();
			putNewLastValue(realIndex, output);
			return output;
		}
		
		public void setByte(long i, byte value) throws IOException {
			long realIndex = i % size;
			Optional<Entry> foundValue = lastValues.stream()
					.filter(entry -> entry.address == realIndex)
					.findAny();
			if (foundValue.isPresent()) {
				foundValue.get().value = value;
			} else {
				putNewLastValue(realIndex, value);
			}
			randomAccessFile.seek(realIndex);
			randomAccessFile.writeByte(value);
		}
		
		@Override
		public void close() throws IOException {
			if (deleteFileOnClose)
				Files.deleteIfExists(memoryFile);
		}
		
		private static final class Entry {
			
			private final long address;
			private byte value;
			
			private Entry(long address, byte value) {
				this.address = address;
				this.value = value;
			}
			
			public byte getValue() {
				return value;
			}
		}
	}
}
