//package com.sandbox.algorithms;

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

	/**
	 * Time Complexity: O(n^2)
	 * Auxiliary Space: O(1)
	 *
	 * @param myArray
	 * @return
	 */
	public int[] sortArray(int[] myArray) {
		boolean swapped = true;
		int temp;
		// Pass through entire array
		while (swapped) {
			swapped = false;
			for (int i = 0; i < myArray.length - 1; i++) {
				if (myArray[i] > myArray[i+1]) {
					swapped = true;
					temp = myArray[i];
					myArray[i] = myArray[i+1];
					myArray[i+1] = temp;
					printArray("Swap Step", myArray);	
				}
			}
			if (!swapped) {
				printArray("Sorted", myArray);
			}
		}
		return myArray;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] myArray = {20, 15, 12, 30, -5, 3, 456};
		//int[] myArray = {-5, 12, 15, 20, 30, 72, 456};
		BubbleSort bs = new BubbleSort();
		bs.printArray("Orig", myArray);
		bs.sortArray(myArray);
	}

}
