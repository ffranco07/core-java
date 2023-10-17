//package com.sandbox.algorithms;

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
	
	/**
	 * Time Complexity: O(n^2)
	 * Auxiliary Space: O(1)
	 *
	 * @param myArray
	 * @return
	 */
	public int[] sortArray(int[] myArray) {
		int temp, minIndex;
		for (int i = 0; i < (myArray.length - 1); i++) {
			minIndex = i;
			for (int j = i+1; j < myArray.length; j++) {
				// Move min index if next position at j 
				// element value is less
				if (myArray[j] < myArray[minIndex]) {
					minIndex = j;
				}
			}
			// Now we have min index and can swap its value 
			// with current index value at the front of array
			temp = myArray[minIndex];
			myArray[minIndex] = myArray[i];
			myArray[i] = temp;
			if (i == myArray.length - 2) {
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
		int[] myArray = {64, 25, 12, 22, 11};
		SelectionSort ss = new SelectionSort();
		ss.printArray("Orig", myArray);
		ss.sortArray(myArray);
	}

}
