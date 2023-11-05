
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
 * Given a binary string s (containing only "0" and "1"). 
 * You may choose up to one "0" and flip it to a "1". 
 * What is the length of the longest substring achievable 
 * that contains only "1"?
 *
 * For example, given s = "1101100111", the answer is 5. 
 * If you perform the flip at index 2, the string becomes 
 * 1111100111.
 *
 */

import java.util.Random;

public class LongestBinarySubstring {

	public LongestBinarySubstring() {
	}

	/**
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findLongestSubstringOnly1s(String s) {
		int left = 0;
		int right = 0;
		int currNumOfZeros = 0; // The current number of zeros in the window
		int result = 0;

		for (right = 0; right < s.length(); right++) {
			if (s.charAt(right) == '0') {
				currNumOfZeros++;
			}
			while (currNumOfZeros > 1) {
				if (s.charAt(left) == '0') {
					currNumOfZeros--;
				}
				left++;
			}

			result = Math.max(result, right - left + 1);
		}

		return result;
	}

	// Driver code
	public static void main(String args[]) {
		// Find longest substring only 1's after first 0 flipped to 1
		// str = "1101100111";
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		int randomNum;
		for (int i = 0; i < 6; i++) {
			randomNum = random.nextInt(2);
			// System.out.println("randomNum: " + randomNum);
			if (randomNum == 0) {
				builder.append("0");
			} else {
				builder.append("1");
			}
		}

		System.out.println("Orig: " + builder.toString());

		// Find longest substring only 1's after 0 flipped to 1
		int longestSubstring = findLongestSubstringOnly1s(builder.toString());
		System.out.println("longestSubstring: " + longestSubstring);
	}
}
