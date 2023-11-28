//package com.sandbox.algorithms;

import java.util.Random;

/**
 * @author Francisco Franco
 *
 * You are a professional robber planning to rob houses 
 * along a street. Each house has a certain amount of money 
 * stashed, the only constraint stopping you from robbing 
 * each of them is that adjacent houses have security systems 
 * connected and it will automatically contact the police if 
 * two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money 
 * of each house, return the maximum amount of money you can 
 * rob tonight without alerting the police.
 * 
 */

public class HouseRobber {
	
	/**
	 * @param tag
	 * @param myArray
	 */
	private static void printArray(String tag, int[] myArray) {
		StringBuilder builder = new StringBuilder();
		builder.append(tag + ": ");
		
		for (int l = 0; l < myArray.length; l++) {
			builder.append(myArray[l] + " ");
		}
		System.out.println(builder.toString());
	}

	/**
	 * Recursive -> Top-down approach
	 * Time Complexity: O(2^n)
	 * Auxiliary Space: O(n)
	 *
	 * @param numbers
	 * @return
	 */
	public static int robRecursive(int[] nums, int i) {
		// DEBUG
		//System.out.println("i" + i);
    if (i < 0) {
			return 0;
    }
		int max = Math.max(robRecursive(nums, i - 2) + nums[i], robRecursive(nums, i - 1));
    // DEBUG
		//System.out.println("max: " + max);
		return max;
	}
	
	/**
	 * Iterative + 2 variables -> Botttom-up approach
	 * Time Complexity: O(n)
	 * Auxiliary Space: O(n)
	 *
	 * @param numbers
	 * @return
	 */
	public static int robIterative(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		if (nums.length <= 2) {
			if (nums.length == 1) {
				return nums[0];
			}
			else {
				return Math.max(nums[0], nums[1]);
			}
		}
		int prevAmount = nums[0];
		int newAmount = Math.max(nums[0], nums[1]);
		int maxAmount = 0;
		for (int i = 2; i < nums.length; i++) {
			maxAmount = Math.max(prevAmount + nums[i], newAmount);
			prevAmount = newAmount;
			newAmount = maxAmount;
		}
		return maxAmount;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = {2, 7, 9, 3, 1};
		//Random random = new Random();
		//int[] numbers = new int[10];
		//for (int i = 0; i < numbers.length; i++) {
		//numbers[i] = random.nextInt(100);
		//}
		printArray("Orig", numbers);
		
		int maxRobAmount = robRecursive(numbers, numbers.length - 1);
		System.out.println("Recursive maxRobAmount: " + maxRobAmount);
		
		maxRobAmount = robIterative(numbers);
		System.out.println("Iterative maxRobAmount: " + maxRobAmount);
	}
}
