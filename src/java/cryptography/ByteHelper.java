/**
 *
 * @author  Atul Acharya, Francisco Franco
 * @version 0.01, August 10, 2005
 */

import java.io.UnsupportedEncodingException;

public class ByteHelper {
	private enum IntegralType {
		
		BYTE(1), SHORT(2), INT(4), LONG(8);
		
		private int width = 0;
		
		IntegralType(int width) {
			this.width = width;
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getBitWidth() {
			return getWidth() * 8;
		}
	}
	
	private ByteHelper() {}
	
	private static long toIntegralType(IntegralType integralType, byte[] byteArray, int index) throws IndexOutOfBoundsException {
		long value = 0;
		
		for (int i = 0; i < integralType.getWidth(); i++) {
			value <<= 8;
			value += byteArray[index + i] & 0x00000000000000ff;
		}
		
		return Long.rotateLeft(Long.reverseBytes(value), integralType.getBitWidth());
	}
	
	/**
	 *  Reads 2 bytes from byteArray, starting at index, 
	 *  and converts those bytes to short.
	 *  Byte order assumed to be 'Little Endian', ie. lower 
	 *  order byte at lower index.
	 *
	 *  @param  byteArray  byte array converted to short
	 *  @param  index  index at which bytes are read
	 *
	 *  @return short value representing 2 bytes read from 
	 *          byteArray
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if index > (byteArray.length - 2)
	 */
	public static short toShort(byte[] byteArray, int index) throws IndexOutOfBoundsException {
		return (short)toIntegralType(IntegralType.SHORT, byteArray, index);
	}
	
	/**
	 *  Reads 4 bytes from byteArray, starting at index, 
	 *  and converts those bytes to int.
	 *  Byte order assumed to be 'Little Endian', ie. lower 
	 *  order byte at lower index.
	 *
	 *  @param  byteArray  byte array converted to int
	 *  @param  index  index at which bytes are read
	 *
	 *  @return int value representing 4 bytes read from 
	 *          byteArray
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if index > (byteArray.length - 4)
	 */
	public static int toInt(byte[] byteArray, int index) throws IndexOutOfBoundsException {
        return (int)toIntegralType(IntegralType.INT, byteArray, index);
	}
	
	/**
	 *  Reads 8 bytes from byteArray, starting at index, 
	 *  and converts those bytes to long.
	 *  Byte order assumed to be 'Little Endian', ie. lower
	 *  order byte at lower index.
	 *
	 *  @param  byteArray  byte array converted to long
	 *  @param  index  index at which bytes are read
	 *
	 *  @return long value representing 2 bytes read from 
	 *          byteArray
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if index > (byteArray.length - 8)
	 */
	public static long toLong(byte[] byteArray, int index) throws IndexOutOfBoundsException {
		return toIntegralType(IntegralType.LONG, byteArray, index);
	}
	
	private static byte[] asciiToByteArray(String asciiString) throws UnsupportedEncodingException {
		return asciiString.getBytes("UTF-8");
	}
	
	/**
	 *  Reads at most stringLength characters from 
	 *  asciiString, and converts those characters to 
	 *  ISO-8859-1 encoding and puts them into byteArray 
	 *  at index.
	 *
	 *  @param  asciiString  string converted to byte array
	 *  @param  stringLength count of bytes to be put in 
	 *                       byteArray
	 *  @param  byteArray  array to receive converted string
	 *  @param  index  index which converted string is 
	 *                 inserted
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if index > (byteArray.length - stringLength)
	 */
	public static void asciiToByteArray(String asciiString, int stringLength, byte[] byteArray, int index) throws IndexOutOfBoundsException {
		String fixedWidthString = getFixedWidthString(asciiString, stringLength);
		byte[] asciiBytes = null;;
		
		try {
			asciiBytes = asciiToByteArray(fixedWidthString);
			System.arraycopy(asciiBytes, 0, byteArray, index, stringLength);
		}
		catch (UnsupportedEncodingException uee) {
			uee.printStackTrace();
		}
		finally {
			asciiBytes = null;
		}
	}
	
	private static byte[] toByteArray(IntegralType integralType, long number) {
		byte[] byteArray = new byte[integralType.getWidth()];
		
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] = (byte)(number & 0x00000000000000ff);
			number >>= 8;
		}
		return byteArray;
	}
	
	private static void toByteArray(IntegralType integralType, long number, byte[] byteArray, int index) throws IndexOutOfBoundsException {
		System.arraycopy(toByteArray(integralType, number), 0, byteArray, index, integralType.getWidth());
	}
	
	/**
	 *  converts given number to 2 bytes, and puts those bytes in byteArray at index.
	 *  Byte order assumed to be 'Little Endian', ie. lower order byte at lower index.
	 *
	 *  @param  number  number to be converted to byte array
	 *  @param  byteArray  array to receive converted number
	 *  @param  index  index at which converted number is inserted
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if index > (byteArray.length - 2)
	 */
	public static void shortToByteArray(long number, byte[] byteArray, int index) throws IndexOutOfBoundsException {
		toByteArray(IntegralType.SHORT, number, byteArray, index);
	}
	
	/**
	 *  converts given number to 4 bytes, and puts those bytes in byteArray at index.
	 *  Byte order assumed to be 'Little Endian', ie. lower order byte at lower index.
	 *
	 *  @param  number  number to be converted to byte array
	 *  @param  byteArray  array to receive converted number
	 *  @param  index  index at which converted number is inserted
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if index > (byteArray.length - 4)
	 */
	public static void intToByteArray(long number, byte[] byteArray, int index) throws IndexOutOfBoundsException {
		toByteArray(IntegralType.INT, number, byteArray, index);
	}
	
	/**
	 *  converts given number to 8 bytes, and puts those bytes in byteArray at index.
	 *  Byte order assumed to be 'Little Endian', ie. lower order byte at lower index.
	 *
	 *  @param  number  number to be converted to byte array
	 *  @param  byteArray  array to receive converted number
	 *  @param  index  index at which converted number is inserted
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if index > (byteArray.length - 8)
	 */
	public static void longToByteArray(long number, byte[] byteArray, int index) throws IndexOutOfBoundsException {
		toByteArray(IntegralType.LONG, number, byteArray, index);
	}
	
	/**
	 *  XOR all bytes in the array.
	 *
	 *  @param  byteArray  array from which sub-array is selected for checksum calculation
	 *  @param  startIndex  start index of sub-array
	 *  @param  count  length of sub-array
	 *
	 *  @return checksum byte
	 *
	 *  @exception  IndexOutOfBoundsException
	 *              if startIndex > (byteArray.length - count)
	 */
	public static byte computeChecksum(byte[] byteArray, int startIndex, int count) throws IndexOutOfBoundsException {
		byte checksum = 0;
		
		for (int i = 0; i < count; i++) {
			checksum = (byte)((checksum ^ byteArray[startIndex + i]) & 0x000000ff);
		}
		return checksum;
	}
	
	/**
	 *  Pack byte array as bitmap.
	 *  Non-zero bytes are assumed to be 'true'.
	 *  0th byte of byteMap maps to msb of 0th byte of bitMap.
	 *
	 *  @param  byteMap  byte array to be converted to bitmap
	 *
	 *  @return byte array containing bitmap
	 */
	public static byte[] createBitMap(byte[] byteMap) {
		byte[] bitMap = new byte[byteMap.length / 8 + ((byteMap.length % 8) == 0 ? 0 : 1)];
		int byteIndex = 0;
		
		for (int bitIndex = 0; bitIndex < bitMap.length; bitIndex++) {
			byte aByte = 0;
			for (int i = 0; i < 8 && byteIndex < byteMap.length; i++) {
				aByte <<= 1;
				aByte |= (byteMap[byteIndex++] == 0 ? 0 : 1);
			}
			bitMap[bitIndex] = aByte;
		}
		bitMap[bitMap.length - 1] <<= 8 - ((byteMap.length % 8) == 0 ? 8 : byteMap.length % 8);
		return bitMap;
	}
	
	/**
	 *  Create a String of length 'length'. 'string is truncated or padded with ' ' to
	 *  get the new 'fixedWidth' string.
	 *  @todo move this method to StringHelper
	 */
	private static String getFixedWidthString(String string, int length) {
		StringBuffer fixedWidth = new StringBuffer(string);
		
		for (int i = string.length(); i < length; i++)
			fixedWidth.append(' ');
		fixedWidth.setLength(length);
		return fixedWidth.toString();
	}

	/**
	 * Appends two bytes array into one.
	 *
	 * @param a A byte[].
	 * @param b A byte[].
	 * @return A byte[].
	 */
	public static byte[] append(byte[] a, byte[] b) {
		byte[] z = new byte[a.length + b.length];
		System.arraycopy(a, 0, z, 0, a.length);
		System.arraycopy(b, 0, z, a.length, b.length);
		return z;
	} 
	
	// Print out byte array as hex
	public static void printByteArrayAsHex(byte[] bytes) {
		for (int k=0; k < bytes.length; k++) {
			System.out.printf("\nByte" + k + ":" + " value is: " + bytes[k] + ", hex form is: " + "%1$02x", bytes[k]);
		}
	}	
	
	// Convert bytes to hex
	public static String toHexString(byte bytes[]) {
		StringBuffer retString = new StringBuffer();
		for (int i = 0; i < bytes.length; ++i)
			{
				retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF)).substring(1));
			}
		return retString.toString().toUpperCase();
	}
}
