//package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 */

public class ReverseArray {

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
	 * @param array
	 * @param i
	 * @param j
	 */
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**	 
	 * Time Complexity: O(n) since still need to traverse entire array
	 * Space Complexity: O(1)
	 * 
	 * @param myArray
	 * @return
	 */
	public int[] reverseArray2(int[] array) {
		int arrayLength = array.length;
		int j = arrayLength - 1;
		for (int i = 0; i < arrayLength / 2; i++) {
			swap(array, i, j);
			j--;
		}
		return array;
	}
	
	/**	 
	 * Time Complexity: O(n) since still need to traverse entire array
	 * Space Complexity: O(1)
	 * 
	 * @param myArray
	 * @return
	 */
	public int[] reverseArray(int[] myArray) {
		int temp;
		int startIndex = 0;
		int endIndex = myArray.length - 1;
		while (startIndex <= endIndex) {
			if (startIndex <= endIndex) {
				temp = myArray[endIndex];
				myArray[endIndex] = myArray[startIndex];
				myArray[startIndex] = temp;
				startIndex++;
				endIndex--;
			}
		}
		return myArray;
	}

	/**
	 * Time Complexity: O(n) since we only call the reverse function n/2 times
	 * Space Complexity: O(1)
	 * 
	 * @param myArray
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public int[] reverseArrayRecursive(int[] myArray, int startIndex, int endIndex) {
		int temp;
		if (startIndex <= endIndex) {
			swap(myArray, startIndex, endIndex);
			reverseArrayRecursive(myArray, startIndex + 1, endIndex - 1);
		}
		return myArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] myArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		ReverseArray ra = new ReverseArray();
		ra.printArray("Original", myArray);
		int[] reversed = ra.reverseArrayRecursive(myArray, 0, myArray.length - 1);
		ra.printArray("Recursive", reversed);
		System.out.println("################");
		int[] myArray2 = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		ra.printArray("Original", myArray2);
		//int[] reversed = ra.reverseArray(myArray2);
		int[] reversed2 = ra.reverseArray2(myArray2);
		ra.printArray("Iterative", reversed2);
	}
}
