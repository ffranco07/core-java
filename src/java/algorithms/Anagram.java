import java.util.Arrays;

/**
 * @author Francisco Franco
 *
 * An anagram of a string is another string that contains the same characters, 
 * only the order of characters can be different. For example, "abcd" and "dabc" 
 * are an anagram of each other.
 */

public class Anagram {

	// Swap chars
	private static void swap(char[] inputChars, int iIndex, int jIndex) {
		char temp = inputChars[iIndex];
		inputChars[iIndex] = inputChars[jIndex];
		inputChars[jIndex] = temp;
	}

	// Implement sort chars
	private static char[] sortChars(char[] inputChars) {
		for (int i = 0; i < inputChars.length - 1; i++) {
			for (int j = i + 1; j < inputChars.length; j++) {
				if (inputChars[j] < inputChars[i]) {
					swap(inputChars, i, j);
				}
			}
		}
		return inputChars;
	}
	
	// Check if two strings are anagram
	public static boolean checkAreAnagram(String str1, String str2) {
		// Set lengths of each string
		int length1 = str1.length();
		int length2 = str2.length();
		
		// Check length are equal, otherwise not anagram
		if (length1 != length2) {
			return false;
		}
		
		// Get string chars
		char[] str1Chars = str1.toCharArray();
		char[] str2Chars = str2.toCharArray();
		
		// Sort each string in place 
		//Arrays.sort(str1Chars);
		//Arrays.sort(str2Chars);

		sortChars(str1Chars);
		sortChars(str2Chars);
		
		// DEBUG
		System.out.println("String.valueOf(str1Chars):" + String.valueOf(str1Chars));
		// DEBUG
		System.out.println("String.valueOf(str2Chars):" + String.valueOf(str2Chars));
		
		if (String.valueOf(str1Chars).equals(String.valueOf(str2Chars))) {
			return true;
		}
			
		return false;
	}

	public static void main(String args[]) {
		String str1 = "listen";
		String str2 = "silent";
		boolean areAnagram = checkAreAnagram(str1, str2);
		System.out.println("areAnagram:" + areAnagram);
	}
}
	
