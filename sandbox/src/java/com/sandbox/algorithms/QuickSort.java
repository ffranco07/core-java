//package com.sandbox.algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * @author Francisco Franco
 *
 * QuickSort is a sorting algorithm, which 
 * leverages the divide-and-conquer principle. 
 * It has an average O(n log n) complexity and 
 * is one of the most used sorting algorithms, 
 * especially for big data volumes.
 */

public class QuickSort {
	
	// Swap array values at respective indices in array
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// Calculate partition
	private static int partition(int arr[], int begin, int end) {
		int pivot = arr[end];
		int i = (begin-1);
		
		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, end);
		return i+1;
	}
	
	// Quick sort the array
	private static void sort(int[] arr, int begin, int end) {
		if (begin < end) {
			// Find partion index
			int partitionIndex = partition(arr, begin, end);
			// Divide 
			sort(arr, begin, partitionIndex-1);
			sort(arr, partitionIndex+1, end);
		}
	}
	
	// Complete the quickSort function
	private static int[] quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
		return arr;
	}

	// Print the array
	private static void printArray(boolean isOriginal, int[] myArray) {
		StringBuilder builder = new StringBuilder();
		if (isOriginal) {
			builder.append("Orig: ");
		}
		else {
			System.out.print("Result: ");
		}
		for (int l = 0; l < myArray.length; l++) {
			builder.append(myArray[l] + " ");
		}
		System.out.println(builder.toString());
	}
	
	// Main method
	public static void main(String[] args) throws IOException {
		int[] arr = {4, 5, 3, 7, 2};
		printArray(true, arr);
		
		int[] result = quickSort(arr);
		printArray(false, result);
	}
}
