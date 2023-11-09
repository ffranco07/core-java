//package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 * Creates a series of numbers in which each number 
 * (Fibonacci Number) is the sum of the two preceding numbers.
 *
 * f(n) = f(n-1) + f(n-2) for n > 1 and f(0) = 0 and f(1) = 1
 */

public class FibonacciSequence {
    
	/**
	 * @param myArray
	 */
	private String arrayToString(int[] myArray) {
		StringBuilder builder = new StringBuilder();
		for (int l = 0; l < myArray.length; l++) {
	    builder.append(myArray[l] + " ");
		}
		return builder.toString();
  }

	/**
	 * Recursive method (NOT AS EFFICIENT as iterative method below)
	 *
	 * Top-down approach 
	 * Start from the top (the original problem) and move down toward the base cases
	 *
	 * Time Complexity: O(2^n) Upper Bound with Exponential Time
	 * Space Complexity: O(1) 
	 *
	 * @param size
	 * @return
	 */
	public static int fibSeqRecursion(int size){
		// Base case which is executed at the end of recursive step
		if (size == 0) {
			return 0;
		}
		// Base case which is executed at the end of recursive step
		if (size == 1) {
			return 1;
		} 
		// Start here
		int sum = fibSeqRecursion(size - 1) + fibSeqRecursion(size - 2);
		return sum;
	}
	
	/**
	 * Iterative method
	 *
	 * Bottom-up approach
	 * Start at the bottom (base cases) and work our way up to larger problems
	 *
	 * Time Complexity: O(n) Upper Bound with Linear Time
	 * Space Complexity: O(1) 
	 *
	 * @param size
	 * @return
	 */
	public int[] fibSeqIterative1(int size) {
		int[] seq = new int[size];
		int x = 0;
		int y = 1;
		int sum;
		for (int i = 0; i < size; i++) {
	    switch (i) {
	    case 0:
				seq[i] = 0;
				break;
	    case 1:
				seq[i] = 1;
				break;	
	    default:
				sum = x + y;
				seq[i] = sum;
				x = y;
				y = sum;
				break;
	    }
		}
		return seq;
	}
	
	/**
	 * Iterative method
	 *
	 * Bottom-up approach
	 * Start at the bottom (base cases) and work our way up to larger problems
	 *
	 * Time Complexity: O(n) Upper Bound with Linear Time
	 * Space Complexity: O(1) 
	 *
	 * @param size
	 * @return
	 */
	public int[] fibSeqIterative2(int size) {
		int[] fibSeq = new int[size];
		fibSeq[0] = 0;
		fibSeq[1] = 1;
		for (int i = 2; i < size; i++) {
			fibSeq[i] = fibSeq[i - 1] + fibSeq[i - 2];
		}
		return fibSeq;
	}
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Ex. 1, 1, 2, 3, 5, 8, 13
		FibonacciSequence fs = new FibonacciSequence();
		int size = 5;
		System.out.println("fibSeq input size: " + size);
		System.out.println("fibSeqRecursion output: " + fs.fibSeqRecursion(size));
		int[] seq = fs.fibSeqIterative2(size);
		System.out.println("fibSeqIterative output: " + fs.arrayToString(seq));
	}    
}
