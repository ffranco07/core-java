package com.sandbox.algorithms;

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
	 * @param myArray
	 */
	private void printArray(boolean isOriginal, int[] myArray) {
		if (isOriginal) {
			System.out.print("Orig: ");
		}
		else {
			System.out.print(count + ") ");
		}
		for (int l = 0; l < myArray.length; l++) {
			System.out.print(myArray[l] + " ");
		}
		System.out.println("");
		if (!isOriginal)
			count++;
	}

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * @param myArray
	 * @return
	 */
	public int[] sortArray(int[] myArray) {
		int temp;
		for (int pass = 0; pass < (myArray.length-1); pass++) {
			for (int j = 0; j < (myArray.length-pass-1); j++) {
				if (myArray[j] > myArray[j+1]) {
					// Swap elements so that they are ordered
					temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
				}
				printArray(false, myArray);	
			}
		}
		return myArray;
	}
	
	/**
	 * Time Complexity: O(n^2)
	 * Best Case Time Complexity: O(n)
	 * Basically just skips 2nd for loop if myArray is already ordered
	 * 
	 * @param myArray
	 * @return
	 */
	public int[] sortArrayImproved(int[] myArray) {
		int temp;
		boolean swapped = true;
		for (int pass = 0; pass < (myArray.length -1) && swapped; pass++) {
			swapped = false;
			for (int j = 0; j < (myArray.length-pass-1); j++) {
				if (myArray[j] > myArray[j+1]) {
					// Swap elements so that they are ordered
					temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
					swapped = true;
				}
				printArray(false, myArray);
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
		bs.printArray(true, myArray);
		bs.sortArrayImproved(myArray);
	}

}
