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
	private void printArray(int[] myArray) {
		System.out.print("Fib Seq: ");
		for (int l = 0; l < myArray.length; l++) {
	    System.out.print(myArray[l] + " ");
		}
		System.out.println("");
	}
	
	/**
	 * Time Complexity: O(n) Upper Bound
	 * Linear Time
	 *
	 * @param size
	 * @return
	 */
	public int[] fibSeq(int size) {
		int[] seq = new int[size];
		int x = 1;
		int y = 1;
		int sum;
		for (int i = 0; i < size; i++) {
	    switch (i) {
	    case 0:
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
	 * Time Complexity: O(2^n) Upper Bound
	 * Recursive method 
	 * NOT AS EFFICIENT as iterative method above
	 * Exponential Time 
	 *
	 * @param size
	 * @return
	 */
	public static int fibSeqRecursion(int size){
		if (size <= 1) {
	    return 1;
		} 
		else {
	    int sum = fibSeqRecursion(size - 1) + fibSeqRecursion(size - 2);
			return sum;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Ex. 1, 1, 2, 3, 5, 8, 13
		FibonacciSequence fs = new FibonacciSequence();
		int[] seq = fs.fibSeq(10);
		fs.printArray(seq);
	}    
}
