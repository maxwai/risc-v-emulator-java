package memory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BigEndianNumberConversion implements NumberConversion {
	
	public short bytesToInt16(byte[] arr, int start) {
		return ByteBuffer.wrap(arr, start, 2).order(ByteOrder.BIG_ENDIAN).getShort();
	}
	
	public int bytesToInt32(byte[] arr, int start) {
		return ByteBuffer.wrap(arr, start, 4).order(ByteOrder.BIG_ENDIAN).getInt();
	}
	
	public int bytesToUInt16(byte[] arr, int start) {
		return ByteBuffer.wrap(arr, start, 2).order(ByteOrder.BIG_ENDIAN).getShort() & 0xFFFF;
	}
	
	public long bytesToUInt32(byte[] arr, int start) {
		return (((long) ByteBuffer.wrap(arr, start, 4).order(ByteOrder.BIG_ENDIAN).getInt())
				& 0xFFFFFFFFL);
	}
	
	public byte[] int16ToBytes(short value) {
		return ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).putShort(value).array();
	}
	
	public byte[] int32ToBytes(int value) {
		return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(value).array();
	}
	
	public byte[] uint16ToBytes(int value) {
		return ByteBuffer.allocate(2).order(ByteOrder.BIG_ENDIAN).putShort((short) (value & 0xFFFF))
				.array();
	}
	
	public byte[] uint32ToBytes(long value) {
		return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN)
				.putInt((int) (value & 0xFFFFFFFFL)).array();
	}
}
