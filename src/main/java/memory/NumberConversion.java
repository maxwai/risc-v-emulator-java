package memory;

@SuppressWarnings("unused")
public interface NumberConversion {
	
	enum NumberFormat {
		LITTLE_ENDIAN, BIG_ENDIAN
	}
	
	/**
	 * Returns the short value for the specified bytes array, from index 0 in the array and 2 bytes
	 * length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 *
	 * @return the short value converted
	 */
	default short bytesToInt16(byte[] arr) {
		return bytesToInt16(arr, 0);
	}
	
	/**
	 * Returns the short value for the specified bytes array, from a specified index start in the
	 * array and 2 bytes length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 * @param start start index in the array of the value to convert
	 *
	 * @return the short value converted
	 */
	short bytesToInt16(byte[] arr, int start);
	
	/**
	 * Returns the int value for the specified bytes array, from index 0 in the array and 4 bytes
	 * length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 *
	 * @return the int value contained in the array
	 */
	default int bytesToInt32(byte[] arr) {
		return bytesToInt32(arr, 0);
	}
	
	/**
	 * Returns the int value for the specified bytes array, from a specified index start in the
	 * array and 4 bytes length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 * @param start start index in the array of the value to convert
	 *
	 * @return the int value contained in the array
	 */
	int bytesToInt32(byte[] arr, int start);
	
	/**
	 * Returns the unsigned short value for the specified bytes array, from index 0 in the array
	 * and 2 bytes length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 *
	 * @return the unsigned short value converted
	 */
	default int bytesToUInt16(byte[] arr) {
		return bytesToUInt16(arr, 0);
	}
	
	/**
	 * Returns the unsigned short value for the specified bytes array, from a specified index start
	 * in the array and 2 bytes length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 * @param start start index in the array of the value to convert
	 *
	 * @return the unsigned short value converted
	 */
	int bytesToUInt16(byte[] arr, int start);
	
	/**
	 * Returns the unsigned int value for the specified bytes array, from index 0 in the array
	 * and 4 bytes length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 *
	 * @return the unsigned int value contained in the array
	 */
	default long bytesToUInt32(byte[] arr) {
		return bytesToUInt32(arr, 0);
	}
	
	/**
	 * Returns the unsigned int value for the specified bytes array, from a specified index
	 * start in the array and 4 bytes length.
	 *
	 * @param arr input bytes array that contains the value to convert
	 * @param start start index in the array of the value to convert
	 *
	 * @return the unsigned int value contained in the array
	 */
	long bytesToUInt32(byte[] arr, int start);
	
	/**
	 * Returns the bytes array of the value to convert.
	 *
	 * @param value the short value to convert
	 *
	 * @return the bytes array of the value, the array is 2 bytes length
	 */
	byte[] int16ToBytes(short value);
	
	/**
	 * Returns the bytes array of the value to convert.
	 *
	 * @param value the int value to convert
	 *
	 * @return the bytes array of the value, the array is 4 bytes length
	 */
	byte[] int32ToBytes(int value);
	
	/**
	 * Returns the bytes array of the value to convert.
	 *
	 * @param value the unsigned short value to convert
	 *
	 * @return the bytes array of the value, the array is 2 bytes length
	 */
	byte[] uint16ToBytes(int value);
	
	/**
	 * Returns the bytes array of the value to convert.
	 *
	 * @param value the unsigned int value to convert
	 *
	 * @return the bytes array of the value, the array is 4 bytes length
	 */
	byte[] uint32ToBytes(long value);
}
