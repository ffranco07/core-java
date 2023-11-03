//package com.sandbox.algorithms;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Francisco Franco
 *
 */

public class ReverseString {
	
	/**
	 * Print input string parameters to standard console
	 */
	private void printString(String description, String value) {
		System.out.print(description);
		System.out.print(value);
		System.out.println("");
	}

	/**
	 * Reverse input source string
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
	 * Reverse input char array
	 */
	public void reverseString(char[] s) {
		int i = 0;
		for (int j = s.length - 1; j >= s.length / 2; j--) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
		}
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
		char[] s = {'h', 'e', 'l', 'l', 'o'};
		System.out.println(s);
		rs.reverseString(s);
		System.out.println(s);
	}
}
