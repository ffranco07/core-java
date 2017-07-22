package com.sandbox.algorithms;

import java.util.Arrays;

/**
 * @author Francisco Franco
 *
 * A half interval search algorithm that finds 
 * the position (index) of a target value within 
 * a sorted array.
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
			midIndex = lowIndex + ((hiIndex - lowIndex) / 2);
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
		int[] whiteList = {30, 50, 20, 33, 1, 51, 66, 99, 12, 84};
		int myValue = 66;
		Arrays.sort(whiteList);
		BinarySearch bs = new BinarySearch();
		bs.printArray(whiteList);
		System.out.println("Search Value is: " + myValue);
		int index = bs.findIndex(whiteList, myValue);
		System.out.println("Found Index is: " + index);
	}

}
