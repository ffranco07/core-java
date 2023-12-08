//package com.sandbox.algorithms;

import java.util.*;

/**
 * @author Francisco Franco
 *
 * Given a stream of integers and a window size, 
 * calculate the moving average of all integers 
 * in the sliding window.
 *
 * Implement the MovingAverage class:
 * MovingAverage(int size) Initializes the object
 * with the size of the window size.
 * double next(int val) Returns the moving average 
 * of the last size values of the stream.
 *  
 */

public class MovingAverage {
	private int windowSize = -9;
	private Queue<Integer> queue;
	private double sum = 0;

	// ================
	// Constructor
	// ================
	
	public MovingAverage(int size) {
		this.windowSize = size;
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
	public double next(int val) {
		if (queue.size() < windowSize) {
			// Add to back of queue
			queue.offer(val);
			sum+=val;
			// DEBUG
			//System.out.println("ADD sum:" + sum);
		}
		else { 
			//int frontVal = queue.peek();
			// DEBUG
			//System.out.println("frontVal:" + frontVal);
			
			// Subtract value from front of queue and add val
			// to fullfill sliding window
			sum = sum - queue.poll() + val;
			
			// DEBUG
			//System.out.println("Sliding sum:" + sum); 
			
			// Add to back of queue
			queue.offer(val);
			
		}
		return (sum / (double)queue.size());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int windowSize = 3;
		MovingAverage movingAvg = new MovingAverage(windowSize);
		System.out.println("Window size: " + windowSize);
		int[] values = {1, 10, 3, 5};
		movingAvg.printArray("Values", values);
		for (int val : values) {
			System.out.println("val: " + val + " sliding avg: " + movingAvg.next(val));
		}
	}
}
