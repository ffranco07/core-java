/**
 * @author Francisco Franco
 *
 * A sliding window algorithm
 */

import java.util.Random;

public class SubarrayMaxSum {
	private static int count;

	public SubarrayMaxSum() {
		count = 1;
	}

	/**
	 * @param tag
	 * @param myArray
	 */
	private static void printArray(String tag, int[] myArray) {
		StringBuilder builder = new StringBuilder();

		if (tag.equals("Step")) {
			builder.append("Step " + count + ": ");
			count++;
		}
		else {
			builder.append(tag + ": ");
		}
		for (int l = 0; l < myArray.length; l++) {
			builder.append(myArray[l] + " ");
		}
		System.out.println(builder.toString());
	}

	public static int findMaxSum(int[] array, int targetSize) {
		int maxSum = 0;
		int tempSum = 0;
		for (int i = 0; i < array.length - 1; i++) {
			tempSum = 0;
			for (int j = i+1; j < array.length; j++) {
				if (j - i == 1) {
					tempSum = array[i] + array[j];
				}
				else {
					tempSum += array[j];
				}
				
				// DEBuG
				//System.out.println("tempSum: " + tempSum);

				if (targetSize == ((j - i) + 1)) {
					if (maxSum < tempSum) {
						maxSum = tempSum;
					}
					break;
				}
			}
		}		
		
		return maxSum;
	}
	
	// Driver code
	public static void main(String args[]) {
		// Find max sum for a sub array of a particular size
		//int[] array = {6, 1, 6, 8, -3, -2};
		int max = 10, min = -3;
		int[] array = new int[6];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(max - min) + min;
		}
		printArray("Orig", array);
		int targetSize = 2;
		System.out.println("subarray targetSize: " + targetSize);
		int maxSum = findMaxSum(array, targetSize);
		System.out.println("maxSum: " + maxSum);
	}
	
} 
