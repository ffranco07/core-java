import java.util.*;

/**
 * @author Francisco Franco
 *
 * Given an array nums containing n distinct numbers 
 * in the range [0, n], return the only number in the 
 * range that is missing from the array
 */

public class MissingNumber {
	
	public static int missingNumberViaArray(int[] nums) {
		int size = nums.length;
		// Each element automatically initialized to 0
		int[] temp = new int[size + 1];
		int ans = size;
		// * Use nums value as index into temp array *
		// For each number in nums set its 
		// index value in temp equal to 1
		for (int i = 0; i < size; i++) {
			temp[nums[i]] = 1;
		}
		// If index value in temp is 0
		// then return its index to find
		// missing number
		for (int j = 0; j < temp.length; j++) {
			if (temp[j] == 0) {
				return j;
			}
		}
		return ans;
	}

	public static int missingNumberViaSet(int[] nums) {
		int ans = nums.length;
		// Use Set data structure (no duplicates)
		// Add all numbers to the set
		Set<Integer> numSet = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			numSet.add(nums[i]);
		}
		// Check which number is not in the set
		// and return it
		for (int i = 0; i < nums.length + 1; i++) {
			if (!numSet.contains(i)) {
				return i;
			}
		}
		return ans;
	}
	
	public static int missingNumberViaMath(int[] nums) {
		int n = nums.length;
		int total = n * (n + 1) / 2;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		// DEBUG
		//System.out.println("total: " + total + " sum: " + sum);
		return total - sum;
	}

	public static void main(String[] args) {
		//int[] nums = {3, 0, 1};
		//int[] nums = {0, 1};
		int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		int missingNum = missingNumberViaMath(nums);
		System.out.println("missingNum: " + missingNum);
	}
}
