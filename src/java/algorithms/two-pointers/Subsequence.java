/**
 * @author Francisco Franco
 *
 * Given two strings s and t, return true if s is a 
 * subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a sequence of characters 
 * that can be obtained by deleting some (or none) of the 
 * characters from the original string, while maintaining 
 * the relative order of the remaining characters. For 
 * example, "ace" is a subsequence of "abcde" while "aec" 
 * is not.
 */

public class Subsequence {

	/**
	 * Time Complexity : O(n) 
   * Auxiliary Space : O(1) 
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean checkIsSubsequence(String s, String t) {
		int i = 0;
		int j = 0;
		
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		
		return i == s.length();
	}

	public static void main(String args[]) {
		String str1 = "ace";
		String str2 = "abcde";
		boolean isSubsequence = checkIsSubsequence(str1, str2);
		System.out.println("str1: " + str1 + " str2: " + str2 + " isSubsequence: " + isSubsequence);
	}
}
