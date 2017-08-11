package com.sandbox.algorithms;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Francisco Franco
 *
 */

public class ReverseString {
	
	  public final int NO_OF_CHARS = 256;
	  // 256 chars allocated for count array
	  public char count[] = new char[NO_OF_CHARS];
	
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
	
	/* calculate count of characters 
    in the passed string */
	public void getCharCountArray(String str) {
		for (int i = 0; i < str.length();  i++) {
			// DEBUG
			// index "str.charAt(i)" evaluates to an int ASCII table value
			//System.out.println((int)str.charAt(i));
            count[str.charAt(i)]++;
		}
		//DEBUG
		//char theChar = 'g';
		//System.out.printf("%d\n", (int)count[theChar]);
	}
	
	 /* The method returns index of first non-repeating
    character in a string. If all characters are repeating 
    then returns -1 */
	public int firstNonRepeating(String str) {
		getCharCountArray(str);
		int index = -1, i;
		for (i = 0; i < str.length();  i++) {
			//System.out.println(count['g']);
			if (count[str.charAt(i)] == 1) {
				index = i;
				//break;
				return index;
	        }   
	     }  
		return index;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String myStr = "Hello World";
		String myStr = "geekforgeeks";
		ReverseString rs = new ReverseString();
		rs.printString("Original: " , myStr);
		String reversedStr = rs.reverseString(myStr);
		rs.printString("Reversed: ", reversedStr);
		System.out.println("Non-Repeated Value: " + rs.firstNonRepeating(myStr));
	}
}
