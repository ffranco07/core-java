//package com.sandbox.algorithms;

import java.util.*;

/**
 * @author Francisco Franco
 *
 * Given a string s containing just the characters 
 * '(', ')', '{', '}', '[' and ']', determine if the 
 * input string is valid. The string is valid if all 
 * open brackets are closed by the same type of closing 
 * bracket in the correct order, and each closing bracket 
 * closes exactly one open bracket.
 *
 * For example, s = "({})" and s = "(){}[]" are valid, 
 * but s = "(]" and s = "({)}" are not valid.
 */

public class ValidParentheses {

	/**
	 * Time Complexity: O(n) -> Stack's push & pop operations are O(1) and 
	 *                          each element can only be pushed or popped once
	 * Space Complexity: O(n) -> Stack's size can grow linearly with the input size.
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		// Parentheses complementary key-value map
		Map<Character, Character> matching = new HashMap<>();
		matching.put('(', ')');
		matching.put('[', ']');
		matching.put('{', '}');
		Stack<Character> stack = new Stack<>();
		for (char c: s.toCharArray()) {
			if (matching.containsKey(c)) { // if c is an opening bracket
				stack.push(c);
			} 
			else {
				if (stack.empty()) {
					return false;
				}
				
				char previousOpening = stack.pop();
				if (matching.get(previousOpening) != c) {
					return false;
				}
			}
		}
		
		return stack.empty();
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "()[]{}";
		System.out.println(s + " matching parentheses isValid: " + isValid(s));
		s = "(]";
		System.out.println(s + " matching parentheses isValid: " + isValid(s));
	}
}
