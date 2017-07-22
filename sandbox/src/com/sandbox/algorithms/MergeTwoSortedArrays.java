package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 *
 * Given two sorted arrays, merge them into a single sorted array
 */

public class MergeTwoSortedArrays {

	/**
	 * @param myArray
	 */
	private void printArray(String description, int[] myArray) {
		System.out.print(description);
		for (int l = 0; l < myArray.length; l++) {
			System.out.print(myArray[l] + " ");
		}
		System.out.println("");
	}

	/**
	 * Time Complexity: O(n1 + n2) where n1 = a.length and n2 = b.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] merge(int a[], int b[]) {
		int[] sorted = new int[a.length + b.length];
		int aIndex = a.length - 1;
		int bIndex = b.length - 1;
		int sIndex = sorted.length - 1;
		while (aIndex >= 0 && bIndex >= 0) {
			// System.out.println("aIndex is: " + aIndex);
			// System.out.println("bIndex is: " + bIndex);
			// System.out.println("sIndex is: " + sIndex);
			if (a[aIndex] > b[bIndex]) {
				sorted[sIndex--] = a[aIndex--];
			} else {
				sorted[sIndex--] = b[bIndex--];
			}
		}

		// Means went through entire array b then
		// look at remaining elements in a
		while (aIndex >= 0) {
			sorted[sIndex--] = a[aIndex--];
		}

		// Means went through entire array a then
		// look at remaining elements in b
		while (bIndex >= 0) {
			sorted[sIndex--] = b[bIndex--];
		}
		return sorted;
	}

	/**
	 * Time Complexity: O(n1 + n2) where n1 = a.length and n2 = b.length
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int[] merge2(int a[], int b[]) {
		int[] sorted = new int[a.length + b.length];
		int aIndex = 0;
		int bIndex = 0;
		int sIndex = 0;
		while (aIndex < a.length && bIndex < b.length) {
			// System.out.println("aIndex is: " + aIndex);
			// System.out.println("bIndex is: " + bIndex);
			// System.out.println("sIndex is: " + sIndex);
			if (a[aIndex] < b[bIndex]) {
				sorted[sIndex++] = a[aIndex++];
			} else {
				sorted[sIndex++] = b[bIndex++];
			}
		}

		// Store remaining elements in a into sorted array
		while (aIndex < a.length) {
			sorted[sIndex++] = a[aIndex++];
		}

		// Store remaining elements in b into sorted array
		while (bIndex < b.length) {
			sorted[sIndex++] = a[aIndex++];
		}
		return sorted;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] a = {11, 22, 33, 44};
		// int[] b = {37, 48, 59, 100};
		int[] a = { 1, 3, 7, 9 };
		int[] b = { 2, 4, 6, 8 };
		MergeTwoSortedArrays mtsa = new MergeTwoSortedArrays();
		mtsa.printArray("Array a: ", a);
		mtsa.printArray("Array b: ", b);
		int[] merged = mtsa.merge2(a, b);
		mtsa.printArray("Merged: ", merged);
	}
}
