//package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 * Find sum of two elements in set/array
 * that add up to a given sum value
 */

public class SumTwoElementsInSet {

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * @param sum
	 * @param myArray
	 */
	public void findSum(int sum, int[] myArray) {
		boolean foundSum = false;
		for (int i = 0; i < myArray.length; i++) {
			for (int j = i + 1; j < myArray.length; j++) {
				if (myArray[i] + myArray[j] == sum) {
					System.out.println("Found sum is:" + "\n" + sum + " = " + myArray[i] + " + " + myArray[j]);
					foundSum = true;
					break;
				}
			}
			if (foundSum) {
				break;
			}
		}
		if (!foundSum) {
			System.out.print("Sum not found in myArray!");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 8;
		int[] myArray = { 1, 2, 5, 4 };
		SumTwoElementsInSet sumTwoElemSet = new SumTwoElementsInSet();
		sumTwoElemSet.findSum(sum, myArray);
	}
}
