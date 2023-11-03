/**
 * @author Francisco Franco
 *
 * Given an integer array nums sorted in ascending order, 
 * return an array of the squares of each number sorted in 
 * ascending order.
 */

public class SquaresOfSortedArray {

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
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 * 
	 * @param nums
	 * @return
	 */
	public static int[] sortedSquares(int[] nums) {
		int n = nums.length, left = 0, right = n - 1;
		int result[] = new int[n];
		// Two pointers at left most index and right most index
		// working towards each other
		for(int index = n - 1; index >= 0; index--) {
			if (Math.abs(nums[left]) > nums[right]) {
				result[index] = (int)Math.pow(nums[left], 2);
				left++;
			}
			else {
				result[index] = (int)Math.pow(nums[right], 2);
				right--;
			}
		}
		return result;
	}

	// Driver code
	public static void main(String[] args) {
		int[] myArray = {-4, -1, 0, 3, 10};
		printArray("Original", myArray);
		int[] result = sortedSquares(myArray);
		printArray("Sorted Squares", result);
	}
}
