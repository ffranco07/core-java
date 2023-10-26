import java.util.Random;

/*
 * @author Francisco Franco
 *
 * MergeSort is a sorting algorithm, which 
 * leverages the divide-and-conquer principle.
 *
 * 1) Divide: Break input into left half and right half with midIndex, leftHalf, rightHalf
 * 2) Recursion: Recursive call for each half (sub problem)
 * 3) Conquer: Combine/Merge these results from each half (sub problem)
 * 
 * Time Complexity: O(N log(N)), Merge Sort is a 
 * recursive algorithm and time complexity can be 
 * expressed as following recurrence relation.
 * T(n) = 2T(n/2) + ?(n)
 *
 * Auxiliary Space: O(N), In merge sort all elements 
 * are copied into an auxiliary array. So N auxiliary 
 * space is required for merge sort.
 */

public class MergeSort {
	
	private static void printArray(String tag, int[] numbers) {
		StringBuilder builder = new StringBuilder();
    for (int i = 0; i < numbers.length; i++) {
			builder.append(numbers[i]);
			if (!(i == numbers.length - 1)) {
				builder.append(" ");
			}
		}
		System.out.println(tag + ": " + builder.toString());
  }
	
	private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
		// DEBUG
		System.out.println("MERGING LEFT HALF & RIGHT HALF INPUT ARRAY LENGTH:" + inputArray.length);
		
		// DEBUG
		printArray("LEFT HALF TO MERGE", leftHalf);
		
		// DEBUG
		printArray("RIGHT HALF TO MERGE", rightHalf);
		
		// DEBUG
		//try {
		//Thread.sleep(2000);
		//}
		//catch (Exception e) {
		//e.printStackTrace();
		//}
		
		// SIZE OF LEFT HALF & RIGHT HALF
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;
		
		// THREE INDICES
		int i = 0, j = 0, k = 0;
		
		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] <= rightHalf[j]) {
				inputArray[k] = leftHalf[i];
				i++;
			}
			else {
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}
		
		while (i < leftSize) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		
		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
		// DEBUG
		printArray("inputArray", inputArray);
	}
	
	private static void mergeSort(int[] inputArray) {
    int inputLength = inputArray.length;
    
    if (inputLength < 2) {
      return;
    }
    
    int midIndex = inputLength / 2;
    int[] leftHalf = new int[midIndex];
		int[] rightHalf = new int[inputLength - midIndex];
    
    for (int i = 0; i < midIndex; i++) {
      leftHalf[i] = inputArray[i];
    }
    for (int j = midIndex; j < inputLength; j++) {
      rightHalf[j - midIndex] = inputArray[j];
    }

		// DEBUG
		printArray("LEFT HALF", leftHalf);

		// DEBUG
		printArray("RIGHT HALF", rightHalf);
    // RECURSIVE CALL FOR LEFT HALF
    mergeSort(leftHalf);
		// DEBUG
		System.out.println("LEFT HALF MERGE SORT DONE");
		
		// RECURSIVE CALL FOR RIGHT HALF
    mergeSort(rightHalf);
		// DEBUG
		System.out.println("RIGHT HALF MERGE SORT DONE");
    
		// COMBINE/MERGE LEFT HALF WITH RIGHT HALF
    merge(inputArray, leftHalf, rightHalf);
		
		System.out.println("##########################");
  }

	// Driver code
	public static void main(String[] args) {
		//int[] numbers = {37, 34, 81, 78, 11, 6};

		Random rand = new Random();
    //int[] numbers = new int[10];
		int[] numbers = new int[6];
		
		for (int i = 0; i < numbers.length; i++) {
			//numbers[i] = rand.nextInt(1000000);
			numbers[i] = rand.nextInt(100);
    }

		// DEBUG
		printArray("Orig", numbers);

		// Merge sort numbers
    mergeSort(numbers); 

    // DEBUG
		printArray("Sorted", numbers);
  }
}
