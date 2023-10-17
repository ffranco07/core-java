//package com.sandbox.algorithms;

import java.util.Random;

/**
 * @author Francisco Franco
 *
 * QuickSort is a sorting algorithm, which 
 * leverages the divide-and-conquer principle.
 *  
 * Time Complexity: Varies between O(n log n) in the best case 
 * to O(n2) in the worst case. It is one of the most used 
 * sorting algorithms, especially for big data volumes.
 */

public class QuickSort {
	
	// Print input array
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
	
	// Swam elements at indices
	private static void swap(int[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }
	
	// Calculate partition
  private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		//  Use additional pointers to traverse array/subarray (during recursion)
    int leftPointer = lowIndex;
    int rightPointer = highIndex - 1;

    while (leftPointer < rightPointer) {

      // Walk from the left until we find a number greater than the pivot
			// or hit the right pointer.
      while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
        leftPointer++;
      }

      // Walk from the right until we find a number less than the pivot
			// or hit the left pointer.
      while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
        rightPointer--;
      }

      swap(array, leftPointer, rightPointer);
    }
    
    // This is different from what the video has and fixes an issue where 
		// the last value could potentially be out of order. 
    // Thanks to viewer Wilson Barbosa for suggesting the fix!
    if(array[leftPointer] > array[highIndex]) {
      swap(array, leftPointer, highIndex);
    }
    else {
      leftPointer = highIndex;
    }
    
    return leftPointer;
  }

	private static void quicksort(int[] array, int lowIndex, int highIndex) {
		// Base case
		if (lowIndex >= highIndex) {
      return;
    }
		
    int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
    int pivot = array[pivotIndex];
    swap(array, pivotIndex, highIndex);

    int leftPointer = partition(array, lowIndex, highIndex, pivot);
		
		// Recursive calls
    quicksort(array, lowIndex, leftPointer - 1);
    quicksort(array, leftPointer + 1, highIndex);
  }

	// Quick sort the array
  private static void quicksort(int[] array) {
    quicksort(array, 0, array.length - 1);
  }
	
	public static void main(String[] args) {
    Random rand = new Random();
    int[] numbers = new int[10];
		
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = rand.nextInt(100);
    }
		
		printArray("Orig", numbers);
		
    quicksort(numbers);
		
		printArray("Sorted", numbers);
  }
}
