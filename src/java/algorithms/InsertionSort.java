//package com.sandbox.algorithms;

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
	 * @param tag
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
	 * @param myArray
	 * @return
	 */
	public int[] sortArray(int[] myArray) {
		int value, j;
		for (int i = 1; i < myArray.length; i++) {
			value = myArray[i];
			j = i - 1;
			// Shift right ALL elements of arr[0..i-1], that are
			// greater than value, to one position ahead
			// of their current position.
			//
			// The while loop ends with negative j value
			// hence add 1 to value
			while (j >=0 && myArray[j] > value) {
				myArray[j+1] = myArray[j];
				// Decrement j index
				j--;
			}
			// Set decremented j+1 element to value
			myArray[j+1] = value;
			if (i == myArray.length - 1) {
				printArray("Sorted", myArray);
			}
			else {
				printArray("Step", myArray);
			}
		}
		return myArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] myArray = { 12, 11, 13, 5, 6 };
		InsertionSort is = new InsertionSort();
		is.printArray("Orig", myArray);
		is.sortArray(myArray);
	}
}
