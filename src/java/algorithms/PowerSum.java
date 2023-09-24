//package com.sandbox.algorithms;

// Java program to count number of ways 
// to express x as sum of n-th power 
// of unique natural numbers. 
public class PowerSum {  
  
	// num is current num. 
	private static int countWaysUtil(int x, int n, int num) { 
		// Base cases 
		int val = (int) (x - Math.pow(num, n)); 
		if (val == 0) 
			return 1; 
		if (val < 0) 
			return 0;

		System.out.println("countWaysUtil(val:" + val + " n:" + n + " num+1:" + (num + 1));
		System.out.println("countWaysUtil(x:" + x + " n:" + n + " num+1:" + (num + 1));
		
		// Consider two possibilities, num is 
		// included and num is not included. 
		return countWaysUtil(val, n, num + 1) + 
			countWaysUtil(x, n, num + 1); 
	} 
	
	// Returns number of ways to express 
	// x as sum of n-th power of two. 
	private static int countWays(int x, int n) { 
		return countWaysUtil(x, n, 1); 
	} 
	
	// Driver code 
	public static void main(String args[]) { 
		int x = 10, n = 2; 
		System.out.println(countWays(x, n)); 
	} 
} 
