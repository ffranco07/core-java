import java.util.Random;

/*
 * MergeSort is a sorting algorithm, which 
 * leverages the divide-and-conquer principle.
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
	public static void main(String[] args) {

		Random rand = new Random();
    //int[] numbers = new int[10];
		int[] numbers = new int[6];

		for (int i = 0; i < numbers.length; i++) {
      //numbers[i] = rand.nextInt(1000000);
			numbers[i] = rand.nextInt(100);
    }

		// DEBUG
		printArray("NON-SORTED", numbers);

    mergeSort(numbers); 

    // DEBUG
		printArray("SORTED", numbers);
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
    for (int i = midIndex; i < inputLength; i++) {
      rightHalf[i - midIndex] = inputArray[i];
    }

		// DEBUG
		printArray("LEFT HALF", leftHalf);

		// DEBUG
		printArray("RIGHT HALF", rightHalf);
    
    mergeSort(leftHalf);
		// DEBUG
		System.out.println("LEFT HALF MERGE SORT DONE");
    mergeSort(rightHalf);
		// DEBUG
		System.out.println("RIGHT HALF MERGE SORT DONE");
    
    merge(inputArray, leftHalf, rightHalf);
		
		System.out.println("##########################");
  }

  private static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf) {
		
		
		// DEBUG
		System.out.println("MERGING LEFT HALF & RIGHT HALF INPUT ARRAY LENGTH:" + inputArray.length);

		// DEBUG
		printArray("LEFT HALF TO MERGE", leftHalf);

		// DEBUG
		printArray("RIGHT HALF TO MERGE", rightHalf);

		try {
			Thread.sleep(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
    int leftSize = leftHalf.length;
    int rightSize = rightHalf.length;
    
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
	}

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
}
