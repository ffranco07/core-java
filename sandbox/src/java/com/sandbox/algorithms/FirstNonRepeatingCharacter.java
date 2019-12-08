package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 */

public class FirstNonRepeatingCharacter {
	// Standard ASCII characters (0-127) + 
	// Extended ASCII characters (128- 255)
	public static final int NO_OF_CHARS = 256;
	
	// Count array initilaized to 0 by default
	private static int[] count = new int[256];
	
	/* Calculate count of characters 
	 * in the string input parameter
	 */
	public static void setCharCountArray(String str) {
		for (int i = 0; i < str.length();  i++) {
			// Index "str.charAt(i)" evaluates to 
			// an int ASCII table value
			// DEBUG
			//System.out.println("Char:" + str.charAt(i));
			// DEBUG
			//System.out.println("ASCII value:" + (int)str.charAt(i));
			// Use ASCII value as index in count array
			// to increment element value
			// Cast char to int to get ASCII numeric code value
			count[(int)str.charAt(i)]++;
		}
		//DEBUG
		//char theChar = 'g';
		//System.out.printf("%d\n", (int)count[theChar]);
	}
	
	/* The method returns index of first non-repeating
	 * character in a string. If all characters are 
	 * repeating then returns -1 
	 */
	public static int firstNonRepeating(String str) {
		// Calculate char count for input string
		setCharCountArray(str);
		int index;
		for (int i = 0; i < str.length();  i++) {
			index = str.charAt(i);
			if (count[str.charAt(i)] == 1) {
				index = i;
				return index;
			}   
		}  
		return -1;
	}
	
	public static void main(String[] args) {
		String myStr = "geekforgeeks";
		System.out.println(myStr);
		int index = firstNonRepeating(myStr);
		System.out.println("First non-repeating character index:" + index);
		System.out.println("First non-repeating charater:" + myStr.charAt(index));
	}
}
