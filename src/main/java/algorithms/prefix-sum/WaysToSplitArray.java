
/**
 * @author Francisco Franco
 *
 * Prefix sum is a technique that can be used on arrays (of numbers). 
 * The idea is to create an array prefix where prefix[i] is the sum 
 * of all elements up to the index i (inclusive). For example, given 
 * nums = [5, 2, 1, 6, 3, 8], we would have prefix = [5, 7, 8, 14, 17, 25].
 *
 * Given an integer array nums, find the number of ways to split the array 
 * into two parts so that the first section has a sum greater than or equal 
 * to the sum of the second section. The second section should have at least 
 * one number.
 */

import java.util.Random;

public class WaysToSplitArray {
	
	public WaysToSplitArray() {}
	
	/**
	 * @param tag
	 * @param nums
	 */
	private static void printArray(String tag, int[] nums) {
		StringBuilder builder = new StringBuilder();
		builder.append(tag + ": ");
		for (int l = 0; l < nums.length; l++) {
			builder.append(nums[l] + " ");
		}
		System.out.println(builder.toString());
	}
	
	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public static int waysToSplitArray(int[] nums) {
		int n = nums.length;
		
		long[] prefix = new long[n];
		prefix[0] = nums[0];
		
		for (int i = 1; i < n; i++) {
			prefix[i] = nums[i] + prefix[i - 1];
		}
		
		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			long leftSection = prefix[i];
			long rightSection = prefix[n - 1] - prefix[i];
			if (leftSection >= rightSection) {
				ans++;
			}
		}
		return ans;
	}
	
	// Driver code
	public static void main(String args[]) {
		// int[] array = {6, 1, 6, 8, -3, -2};
		int max = 10, min = -3;
		int[] nums = new int[6];
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(max - min) + min;
		}
		printArray("Orig", nums);

		// Number of ways to split array
		int numOfWays = waysToSplitArray(nums);
		System.out.println("Num of Ways: " + numOfWays);
	}
}
