//package com.sandbox.algorithms;

import java.util.Random;

/**
 * @author Francisco Franco
 *
 * A sinking sort algorithm that compares each
 * pair of adjacent elements and swaps them if
 * they are in the wrong order.  In case of ascending sort,
 * lesser values bubble to front of array.
 */

public class BubbleSort {
	private int count;
	
	public BubbleSort() {
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
	 * @param myArray
	 * @return
	 */
	public int[] sortArray(int[] numbers) {
		boolean swapped = true;
		int temp;
		// Pass through entire array
		while (swapped) {
			swapped = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i] > numbers[i+1]) {
					swapped = true;
					swap(numbers, i, i+1);
					printArray("Swap Step", numbers);	
				}
			}
			if (!swapped) {
				printArray("Sorted", numbers);
			}
		}
		return numbers;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] numbers = {20, 15, 12, 30, -5, 3, 456};
		//int[] numbers = {-5, 12, 15, 20, 30, 72, 456};
		Random random = new Random();
		int[] numbers = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}
		BubbleSort bs = new BubbleSort();
		bs.printArray("Orig", numbers);
		bs.sortArray(numbers);
	}

}
