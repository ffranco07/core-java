/**
 * @author Francisco Franco
 *
 * A palindrome is any word or phrase or sentence 
 * or dates of the year that reads the same both 
 * forward and backward. Examples are civic, radar, 
 * level, rotor, kayak, madam, and refer
 */

public class Palindrome {

	public static boolean checkPalindrome(String str1) {
		for (int i = 0, j = str1.length() - 1; i < j; i++) {
			if (str1.charAt(i) != str1.charAt(j)) {
				return false;
			}
			j--;
		}
		return true;
	}
	
	public static void main(String args[]) {
		String str1 = "madam";
		boolean isPalindrome = checkPalindrome(str1);
		System.out.println("str1: " + str1 + " isPalindrome: " + isPalindrome);
	}
}
