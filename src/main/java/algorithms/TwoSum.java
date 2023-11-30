//package com.sandbox.algorithms;

import java.util.*;

/**
 * @author Francisco Franco
 *
 * Find sum of two elements in array
 * that add up to a given sum value/target
 */

public class TwoSum {

	/**
	 * @param description
	 * @param myArray
	 */
	private static void printArray(String description, int[] myArray) {
		System.out.print(description + ": ");
		for (int l = 0; l < myArray.length; l++) {
			System.out.print(myArray[l] + " ");
		}
		System.out.println("");
	}

	/**
	 * Time Complexity: O(n^2) -> Brute Force
	 * 
	 * @param sum
	 * @param myArray
	 */
	public static String findSum(int[] myArray, int sum) {
		boolean foundSum = false;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < myArray.length; i++) {
			for (int j = i + 1; j < myArray.length; j++) {
				if (myArray[i] + myArray[j] == sum) {
					buffer.append(sum+  " = " + myArray[i] + " + " + myArray[j]);
				  foundSum = true;
					break;
				}
			}
			if (foundSum) {
				break;
			}
		}
		if (!foundSum) {
			buffer.append("Sum not found in myArray!");
		}
		return buffer.toString();
	}

	/**
	 * Time Complexity: O(n) -> Using HashMap
	 * 
	 * @param sum
	 * @param myArray
	 */
	public static int[] twoSum(int[] nums, int target) {
		// Map containing num value and index
		Map<Integer, Integer>map = new HashMap<>();
		int num, complement;
		for (int i = 0; i < nums.length; i++) {
			num = nums[i];
			complement = target - num;
			// Check complement matches former num key in map
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			// Use num as key 
			map.put(num, i);
		}
		return new int[] {-1, -1};
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 5;
		int[] myArray = {1, 2, 5, 4};
		TwoSum twoSum = new TwoSum();
		printArray("Orig", myArray);
		System.out.println("Result via nested for loop: " + findSum(myArray, sum));
		int[] result = twoSum(myArray, sum);
		printArray("Result via HashMap", result);
	}
}
