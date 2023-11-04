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
 */

import java.util.Random;

public class SubarrayMaxSum {
	
	public SubarrayMaxSum() {}
	
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
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findMaxSumSubarray(int[] nums, int k) {
    int currSum = 0;
    for (int i = 0; i < k; i++) {
			currSum += nums[i];
    }
		
    int maxSum = currSum;
    for (int i = k; i < nums.length; i++) {
			currSum += nums[i] - nums[i - k];
			maxSum = Math.max(maxSum, currSum);
    }
		
    return maxSum;
	}
	
	// Driver code
	public static void main(String args[]) {
		// Find max sum for a sub array of a particular size
		//int[] array = {6, 1, 6, 8, -3, -2};
		int max = 10, min = -3;
		int[] nums = new int[6];
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(max - min) + min;
		}
		printArray("Orig", nums);
		
		// Subarray target size
		int targetSize = 2;
		System.out.println("subarray targetSize: " + targetSize);
		
		// Subarray max sum for target size
		int maxSum = findMaxSumSubarray(nums, targetSize);
		System.out.println("maxSum: " + maxSum);
	}
} 
