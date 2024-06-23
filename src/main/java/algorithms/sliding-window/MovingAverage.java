import java.util.List;
import java.util.ArrayList;

/**
 * @author Francisco Franco
 *
 * A sliding window algorithm
 *
 * A subarray can be defined by two indices, 
 * the start and end. For example, with [1, 2, 3, 4], 
 * the subarray [2, 3] has a starting index of 1 and 
 * an ending index of 2. Let's call the starting index 
 * the left bound and the ending index the right bound. 
 * Another name for subarray in this context is "window"
 *
 * In terms of time complexity, any algorithm that looks 
 * at every subarray will be at least O(n^2) which is 
 * usually too slow. A sliding window guarantees a maximum 
 * of 2n window iterations - the right pointer can move 
 * n times and the left pointer can move n times. This 
 * means if the logic done for each window is O(1), sliding
 * window algorithms run in O(n), which is much faster.
 *
 * Given an integer array nums and an integer k, find the sum 
 * of the subarray with the largest sum whose length is k.
 */

import java.util.Random;

public class MovingAverage {

	public MovingAverage() {}
	
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
	 * @param tag
	 * @param myList
	 */
	private static void printList(String tag, List<?> myList) {
		StringBuilder builder = new StringBuilder();
		builder.append(tag + ": ");
		for (int l = 0; l < myList.size(); l++) {
			builder.append(myList.get(l) + " ");
		}
		System.out.println(builder.toString());
	}

	/**
	 * Time Complexity: O(n * k)
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static List<Float> smoothData(int[] nums, int k) {
		List<Float> avgList = new ArrayList<Float>();
		int currSum = 0, count = 0, left = 0, right = 0, numsLength = nums.length;
		float avg = (float)0.00;
		if (numsLength >= k) {
			while (right != numsLength) {
				currSum += nums[right];
				count+=1;
				if (count % k == 0) {
					avg = Math.round((float)currSum / (float)k * 100) / 100.0f;
					// DEBUG
					//System.out.println("currSum: " + currSum + " k: " + k + " avg: " + avg);
					avgList.add(avg);
					currSum = 0;
					count = 0;
					left+=1;
					right = left;
				}
				else {
					right++;
				}
			}
		}
		else {
			avgList.add(-1.0f);
		}
		return avgList;
	}
	
	// Driver code
	public static void main(String args[]) {
		// Find moving average
		//int[] nums = {1, 1, 1, 1, 2, 1, 1};
		int[] nums = {2, 3, 4, 5, 1, 2, 3, 1, 3};
		// Number of elements to compute average
		//int k = 3;
		int k = 5;
		printArray("Orig", nums);
		System.out.println("k: " + k);

		// Implement moving average function/method
		List<Float> avgList = smoothData(nums, k);
		printList("Avg List", avgList);
	}
}
