
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
 * Given an array of positive integers nums and an integer 
 * k, return the number of subarrays where the product of 
 * all the elements in the subarray is strictly less than k.
 *
 * For example, given the input nums = [10, 5, 2, 6], k = 100, 
 * the answer is 8. The subarrays with products less than k are:
 * 
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * 
 */

import java.util.Random;

public class SubarrayProductLessThanK {

	public SubarrayProductLessThanK() {}

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
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) {
			return 0;
		}
		
		int ans = 0;
		int left = 0;
		int curr = 1;
		
		for (int right = 0; right < nums.length; right++) {
			curr *= nums[right];
			while (curr >= k) {
				curr /= nums[left];
				left++;
			}
			ans += right - left + 1;
		}
		
		return ans;
	}
	
	// Driver code
	public static void main(String args[]) {
		// Find longest subarray size less than or equal to target sum
		int[] nums = new int[6];
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(10);
		}
		printArray("Orig", nums);
		
		// Target sum
		int targetProduct = 20;
		System.out.println("targetProduct: " + targetProduct);
		
		// Find longest subarray size for target sum
		int numSubarrayProduct = numSubarrayProductLessThanK(nums, targetProduct);
		System.out.println("numSubarrayProduct: " + numSubarrayProduct);
	}
}
