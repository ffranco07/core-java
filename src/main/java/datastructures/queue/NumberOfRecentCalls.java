//package com.sandbox.algorithms;

import java.util.*;

/**
 * @author Francisco Franco
 *
 * Implement ping(int t), which records a call 
 * at time t, and then returns an integer representing 
 * the number of calls that have happened in the 
 * range [t - 3000, t]. Calls to ping will have increasing t.
 *  
 */

public class NumberOfRecentCalls {
	private Queue<Integer> queue;

	// ================
	// Constructor
	// ================

	public NumberOfRecentCalls() {
		this.queue = new LinkedList<>();
	}

	/**
	 * @param description
	 * @param myArray
	 */
	private void printArray(String description, int[] myArray) {
		System.out.print(description + ": ");
		for (int l = 0; l < myArray.length; l++) {
			System.out.print(myArray[l] + " ");
		}
		System.out.println("");
	}
	
	/**
	 * Time Complexity: O(1) -> To insert and delete at the beginning or at the end of the queue.
	 * @param t
	 * @return
	 */
	public int ping(int t) {
		// Check incoming call at time t to remove
		// last call time in queue (front of queue) 
		// if t - 3000 exceeds last call time
		// queue.peek() checks front of queue
		while (!queue.isEmpty() && queue.peek() < t - 3000) {
			// Remove from front of queue
			queue.poll();
		}
		// Record call at time t
		// Add to back of queue
		queue.offer(t);
		return queue.size();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberOfRecentCalls numCalls = new NumberOfRecentCalls();
		int[] callTimes = {1, 100, 3001, 4000};
		numCalls.printArray("Orig", callTimes);
		for (int t : callTimes) {
			System.out.println("t: " + t + " queue size: " + numCalls.ping(t));
		}
	}
}
