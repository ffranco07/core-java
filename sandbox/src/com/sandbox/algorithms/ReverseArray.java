package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 */

public class ReverseArray {
	
	/**
	 * @param myArray
	 */
	private void printArray(String description, int[] myArray) {
		System.out.print(description);
		for (int l = 0; l < myArray.length; l++) {
			System.out.print(myArray[l] + " ");
		}
		System.out.println("");
	}

	/**
	 * Time Complexity: O(2^n)
	 * Recursive method
	 * 
	 * @param myArray
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	public int[] reverseArray(int[] myArray, int startIndex, int endIndex) {
		int temp;
		if(startIndex <= endIndex) {
			temp = myArray[startIndex];
			//System.out.println("temp is: " + temp);
			myArray[startIndex] = myArray[endIndex];
			myArray[endIndex] = temp;
			reverseArray(myArray, startIndex + 1, endIndex - 1);
		}
		return myArray;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] myArray = {1, 2, 3, 4, 5};
		ReverseArray ra = new ReverseArray();
		ra.printArray("Original: ", myArray);
		int[] reversed = ra.reverseArray(myArray, 0, myArray.length -1);
		ra.printArray("Reversed: ", reversed);
	}
} 
