
/**
 * @author Francisco Franco
 *
 * Prefix sum is a technique that can be used on arrays (of numbers). 
 * The idea is to create an array prefix where prefix[i] is the sum 
 * of all elements up to the index i (inclusive). For example, given 
 * nums = [5, 2, 1, 6, 3, 8], we would have prefix = [5, 7, 8, 14, 17, 25].
 *
 *
 * Given an integer array nums, an array queries where queries[i] = [x, y] 
 * and an integer limit, return a boolean array that represents the answer 
 * to each query. A query is true if the sum of the subarray from x to y is 
 * less than limit, or false otherwise.
 *
 * For example, given nums = [1, 6, 3, 2, 7, 2], 
 * queries = [[0, 3], [2, 5], [2, 4]], and limit = 13, the answer is 
 * [true, false, true]. For each query, the subarray sums are [12, 14, 12].
 */

import java.util.Random;

public class PrefixSumQueries {

	public PrefixSumQueries() {}
	
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
	 * @param tag
	 * @param myArray
	 */
	private static void printArray(String tag, boolean[] myArray) {
		StringBuilder builder = new StringBuilder();
		builder.append(tag + ": ");
		for (int l = 0; l < myArray.length; l++) {
			builder.append(myArray[l] + " ");
		}
		System.out.println(builder.toString());
	}

	/**
	 * @param tag
	 * @param myArray
	 */
	private static void print2DArray(String tag, int[][] array2d) {
		int i, j;
		int rows = array2d.length;
		int columns = array2d[0].length;
		StringBuilder builder = new StringBuilder();
		builder.append(tag + ": {");
		for (i = 0; i < rows; i++) {
			builder.append("{");
			for (j = 0; j < columns; j++) {
				builder.append(array2d[i][j]);
			
				if (j != (columns - 1)) {
					builder.append(", ");
				}
			}
			builder.append("}");
			if (i != (rows - 1)) {
				builder.append(", ");
			}
		}
		builder.append("}");
		System.out.println(builder.toString());
	}

	/**
	 * Without prefix sum, Time Complexity: O(n*m)
	 * With prefix sum, Time Complexity: O(n+m)
	 * Space Complexity: O(n)
	 * 
	 * @param nums
	 * @param queries
	 * @param limit
	 * @return
	 */
	public static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
    int[] prefix = new int[nums.length];
    prefix[0] = nums[0];
		
    for (int i = 1; i < nums.length; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
    }
		
    boolean[] ans = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
			int x = queries[i][0], y = queries[i][1];
			int curr = prefix[y] - prefix[x] + nums[x];
			ans[i] = curr < limit;
    }
    
    return ans;
	}

	// Driver code
	public static void main(String args[]) {
		// Find max sum for a subarray of a particular size
		// int[] array = {6, 1, 6, 8, -3, -2};
		int max = 10, min = -3;
		int[] nums = new int[6];
		Random random = new Random();
		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(max - min) + min;
		}
		printArray("Orig", nums);
		
		// Queries to compare prefix sum indices against limit
		int[][] queries = {{0, 3}, {2, 5}, {2, 4}};
		print2DArray("Queries", queries);
		
		// Limit
		int limit = 13;
		System.out.println("Limit: " + limit);

		// Subarray max sum for target size
		boolean[] prefixSumExceedsLimit = answerQueries(nums, queries, limit);
		printArray("Exceeds Limit" , prefixSumExceedsLimit);
	}
}
