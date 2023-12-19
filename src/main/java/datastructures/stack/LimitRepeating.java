
/**
 * @author Francisco Franco
 *
 */

import java.util.Stack;

public class LimitRepeating {

	public LimitRepeating() {}
	
	/**
	 * Time Complexity: O(n) -> where n is the length of string s input size
	 * Space Complexity: O(n) -> StringBuilder size can grow linearly with the string s input size.
	 * @param s
	 * @param limit
	 * @param doDebug
	 * @return
	 */
	public static String limitRepeating(String s, int limit, boolean doDebug) {
		int bIndex = 0, count = 1;
		StringBuilder builder = new StringBuilder();
		builder.append(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (doDebug) {
				System.out.println("###################");
				System.out.println("builder: " + builder.toString());
				System.out.println("count: " + count);
				System.out.println("builder last char: " + builder.charAt(bIndex));
				System.out.println("s char: " + s.charAt(i));
			}
			if (builder.charAt(bIndex) == s.charAt(i)) {
				if (count < limit) {
					builder.append(s.charAt(i));
					count++;
				}
			}
			else {
				builder.append(s.charAt(i));
				bIndex = builder.length() - 1;
				count = 1;
			}
		}
		return builder.toString();
	}

	/**
	 * Time Complexity: O(n) -> where n is the length of string s input size 
	 * Space Complexity: O(n) -> Stack's size can grow linearly with the string s input size.
	 * @param s
	 * @param limit
	 * @param doDebug
	 * @return
	 */
	public static String limitRepeatingUsingStack(String s, int limit, boolean doDebug) {
		int count = 1;
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (doDebug) {
				System.out.println("###################");
				System.out.println("count: " + count);
				System.out.println("stack last char: " + stack.peek());
				System.out.println("s char: " + s.charAt(i));
			}
			if (stack.peek() == s.charAt(i)) {
				if (count < limit) {
					stack.push(s.charAt(i));
					count++;
				}
			}
			else {
				stack.push(s.charAt(i));
				count = 1;
			}
		}
		StringBuilder builder = new StringBuilder();
		for (Character c : stack) {
			builder.append(c);
		}
		return builder.toString();
	}
	
	// Driver code
	public static void main(String args[]) {
		String orig = "AAAABBBCDEFAABBBBCCCCCC";
		System.out.println("orig: " + orig);
		String output = limitRepeating(orig, 3, false); 
		System.out.println("output 1: " + output);
		output = limitRepeatingUsingStack(orig, 3, false);
		System.out.println("output 2: " + output);
	}
}
