//package com.sandbox.algorithms;

import java.util.Random;

/**
 * @author Francisco Franco
 *
 * An in-place (same array, no new data structure needed) and 
 * comparison-based sort algorithm that sorts an array by repeatedly 
 * FINDING the minimum element (considering ascending order) from unsorted part 
 * and putting it at the beginning.  Repeatedly selects smallest element value.
 * 
 * 1. Find the minimum value in the list (Move minimum index) 
 * 2. Swap it with the value in the current position (index)
 * 3. Repeat this process for all the elements until the entire array is sorted
 */

public class SelectionSort {
	private int count;
	
	public SelectionSort() {
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

	private void swap(int[] myArray, int iIndex, int jIndex) {
		int temp = myArray[iIndex];
		myArray[iIndex] = myArray[jIndex];
		myArray[jIndex] = temp;
	}
	
	/**
	 * Time Complexity: O(n^2)
	 * Auxiliary Space: O(1)
	 *
	 * @param numbers
	 * @return
	 */
	public int[] sortArray(int[] numbers) {
		int numbersLength = numbers.length;
		int min, minIndex;
		for (int i = 0; i < (numbersLength - 1); i++) {
			min = numbers[i];
			minIndex = i;
			for (int j = i + 1; j < numbersLength; j++) {
				// Move min index to the right if 
				// next position at j is less than min
				if (numbers[j] < min) {
					min = numbers[j];
					minIndex = j;
				}
			}
			// Now we have min index and can swap its value 
			// with current index value at the front of array
			swap(numbers, i, minIndex);
			if (i == numbers.length - 2) {
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
		//int[] numbers = {64, 25, 12, 22, 11};
		Random random = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}
		SelectionSort ss = new SelectionSort();
		ss.printArray("Orig", numbers);
		ss.sortArray(numbers);
	}
}
