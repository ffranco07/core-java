package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 */

public class ReverseString {
	
	/**
	 * @param description
	 * @param myArray
	 */
	private void printString(String description, String value) {
		System.out.print(description);
		System.out.print(value);
		System.out.println("");
	}

	/**
	 * @param source
	 * @return
	 */
	public String reverseString(String source) {
		int i, len = source.length();
		StringBuilder dest = new StringBuilder(len);
		for (i = (len - 1); i >= 0; i--) {
			dest.append(source.charAt(i));
		}
		return dest.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String myStr = "Hello World";
		ReverseString rs = new ReverseString();
		rs.printString("Original: " , myStr);
		String reversedStr = rs.reverseString(myStr);
		rs.printString("Reversed: ", reversedStr);
	}
}
