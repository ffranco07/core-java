//package com.sandbox.algorithms;

import java.util.Random;

/**
 * @author Francisco Franco
 *
 * A comparison sort algorithm in which each iteration
 * removes an element from the input array and inserts it
 * into the correct position in the array. In place algorithm.
 */

public class InsertionSort {
	private int count;
	
	public InsertionSort() {
		count = 1;
	}
	
	/**
	 * @param myArray
	 */
	private void printArray(String tag, int[] myArray) {
		StringBuilder builder = new StringBuilder();

		if (tag.equals("Step")) {
			builder.append("Step " + count + ": ");
			count++;
		}
		else {
			builder.append(tag + ": ");
		}
		for (int l = 0; l < myArray.length; l++) {
			builder.append(myArray[l] + " ");
		}
		System.out.println(builder.toString());
	}

	/**
	 * Best Time Complexity: O(n)
	 * Worst Time Complexity: O(n^2)
	 * Auxiliary Space: O(1)
	 * 
	 * ALWAYS START ITERATION AT 1
	 * TO LOOK AT PREVIOUS ELEMENT
	 * @param numbers
	 * @return
	 */
	public int[] sortArray(int[] numbers) {
		int value, j;
		for (int i = 1; i < numbers.length; i++) {
			value = numbers[i];
			j = i - 1;
			// Shift right ALL elements of arr[0..i-1], that are
			// greater than value, to one position ahead
			// of their current position.
			//
			// The while loop ends with negative j value
			// hence add 1 to value
			while (j >=0 && numbers[j] > value) {
				numbers[j+1] = numbers[j];
				// Decrement j index
				j--;
			}
			// Set decremented j+1 element to value
			numbers[j+1] = value;
			if (i == numbers.length - 1) {
				printArray("Sorted", numbers);
			}
			else {
				printArray("Step", numbers);
			}
		}
		return numbers;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] numbers = { 12, 11, 13, 5, 6 };
		Random random = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}
		InsertionSort is = new InsertionSort();
		is.printArray("Orig", numbers);
		is.sortArray(numbers);
	}
}
