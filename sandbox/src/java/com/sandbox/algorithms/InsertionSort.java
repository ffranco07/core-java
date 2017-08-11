package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 * A comparison sort algorithm in which each iteration
 * removes an element from the input array and inserts it
 * into the correct position in the array.
 */

public class InsertionSort {
	private int count;
	
	public InsertionSort() {
		count = 1;
	}
	
	/**
	 * @param myArray
	 */
	private void printArray(boolean isOriginal, int[] myArray) {
		if (isOriginal) {
			System.out.print("Orig: ");
		} else {
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
		int value, j;
		for (int i = 1; i < myArray.length; i++) {
			value = myArray[i];
			j = i - 1;
			// Move ALL elements of arr[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position.
			// while loop ends with negative j value
			while (j >=0 && myArray[j] > value) {
				myArray[j+1] = myArray[j];
				// Decrement j index
				j = j-1;
			}
			// Set decremented j+1 element to value
			myArray[j+1] = value;
			printArray(false, myArray);
		}
		return myArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] myArray = { 12, 11, 13, 5, 6 };
		InsertionSort is = new InsertionSort();
		is.printArray(true, myArray);
		is.sortArray(myArray);
	}
}
