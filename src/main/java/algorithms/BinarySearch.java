//package com.sandbox.algorithms;

import java.util.Arrays;

/**
 * @author Francisco Franco
 *
 * A half interval search algorithm that finds 
 * the position (index) of a target value within 
 * a sorted array.
 *
 * With binary search, we initially consider the entire 
 * input (n elements). After the first step, we only 
 * consider n / 2 elements. After the second step, we only 
 * consider n / 4 elements, and so on. At each step, we are
 * reducing our search space by 50%, which gives us 
 * a logarithmic time complexity.
 *
 * O(log n) means that somewhere in your algorithm, 
 * the input is being reduced by a percentage at 
 * every step.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 */

public class BinarySearch {
	
	/**
	 * @param myArray
	 */
	private void printArray(int[] myArray) {
		System.out.print("Orig: ");
		for (int l = 0; l < myArray.length; l++) {
			System.out.print(myArray[l] + " ");
		}
		System.out.println("");
	}
	
	/**
	 * Time Complexity: O(log n)
	 * Space Complexity: O(1)
	 * 
	 * @param list
	 * @param value
	 * @return
	 */
	public int findIndex (int[] list, int value) {
		int lowIndex = 0;
		int hiIndex = list.length - 1;
		int midIndex;
		while(lowIndex <= hiIndex) {
			// ALWAYS CALCULATE MIDINDEX
			midIndex = (lowIndex + hiIndex) / 2;
			//System.out.println("midIndex is: " + midIndex);
			if (value > list[midIndex]) {
				lowIndex = midIndex + 1;
			}
			else if (value < list[midIndex]) {
				hiIndex = midIndex - 1;
			}
			else {
				return midIndex;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] ints = {30, 50, 20, 33, 1, 51, 66, 99, 12, 84};
		int myValue = 99;
		Arrays.sort(ints);
		BinarySearch bs = new BinarySearch();
		bs.printArray(ints);
		System.out.println("Search Value: " + myValue);
		int index = bs.findIndex(ints, myValue);
		System.out.println("Found Index: " + index);
		// Use internal library for binary search
		System.out.println("Library Arrays.binarySearch Found Index: " + Arrays.binarySearch(ints, myValue));
	}

}
