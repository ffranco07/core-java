//package com.sandbox.algorithms;

import java.util.*;

/**
 * @author Francisco Franco
 *
 * You are given a string s. Continuously remove duplicates 
 * (two of the same character beside each other) until you 
 * can't anymore. Return the final string after this.
 *
 * For example, given s = "abbaca", you can first remove the 
 * "bb" to get "aaca". Next, you can remove the "aa" to get 
 * "ca". This is the final answer.
 *  
 */

public class RemoveDuplicates {
	
	/**
	 * Time Complexity: O(n) -> Stack's operations are O(1) 
	 * Space Complexity: O(n) -> Stack's size can grow linearly with the input size.
	 * @param s
	 * @return
	 */
	public static String removeDuplicates(String s) {
		StringBuilder stack = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			// Check if char in s is already in stack, if so then delete
			if (stack.length() > 0 && stack.charAt(stack.length() - 1) == s.charAt(i)) {
				stack.deleteCharAt(stack.length() - 1);
			}
			else {
				stack.append(s.charAt(i));
			}
		}
		return stack.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abbaca";
		System.out.println("Orig: " + s);
		s = removeDuplicates(s);
		System.out.println("Removed: " + s);
	}
}
