//package com.sandbox.algorithms;

/*
 * Given a list of scrambled plane tickets, 
 * each with a starting city and end city, 
 * put together the path of the trip.
 *
 * Input: [['Chennai', 'Bangalore'], ['Bombay', 'Delhi'], 
 * ['Goa', 'Chennai'], ['Delhi', 'Goa'], ['Bangalore', 'Beijing']]
 *
 * Output: [['Bombay', 'Delhi'], ['Delhi', 'Goa'], 
 * ['Goa', 'Chennai'], ['Chennai', 'Bangalore'], ['Bangalore', 'Beijing']]
 */

/**
 * @author Francisco Franco
 */

public class TripPath {

	private static final boolean DEBUG = true;

	// Print input array
	private static void printArray(String prefix, String[][] arr) {
		StringBuilder builder = new StringBuilder();
		builder.append(prefix);
		for (int k = 0; k < arr.length; k++) {
			if (k == 0) {
				builder.append("[");
			}
			builder.append("[" + arr[k][0] + "," + arr[k][1] + "]");
			if (k == arr.length - 1) {
				builder.append("]");
			}
			else {
				builder.append(",");
			}
		}
		System.out.println(builder.toString());
	}
		
	// Swap array values at respective indices in array
	private static void swap(String[][] arr, int n, int m) {
		String[] temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
	
	// Unscramble trip path
	public static String[][] findTripPath(String[][] arr) {
		int i = 0;
		int j = 1;
		String[] temp = null;
		String city = null;
		String destination = null;
		String lastCity = null;
		boolean foundConnection = false;
		while (i < arr.length) {
			destination = arr[i][1];
			if (DEBUG) {
				// DEBUG
				System.out.println("destination:" + destination);
			}
			// Check if destination has a matching city
			while(j < arr.length) {
				city = arr[j][0];
				if (DEBUG) {
					// DEBUG
					System.out.println("city:" + city);
				}
				if (destination.equals(city)) {
					foundConnection = true;
					break;
				}
				j++;
			}
			if (DEBUG) {
				// DEBUG
				System.out.println("foundConnection:" + foundConnection);
			}
			if (!foundConnection) {
				if (i != (arr.length - 1)) {
					swap(arr, i, (arr.length - 1));
				}
				lastCity = arr[(arr.length - 1)][0];
				break;
			}
			i++;
			j = 0;
			foundConnection = false;
		}
		
		i = 0;
		j = arr.length - 2;
		
		while (i <= j) {
			if (DEBUG) {
				// DEBUG
				System.out.println("lastCity:" + lastCity);
			}
			if (arr[i][1].equals(lastCity)) {
				lastCity = arr[i][0];
				if (DEBUG) {
					// DEBUG
					System.out.println("NEW lastCity:" + lastCity);
				}
				swap(arr, i, j);
				j--;
				i = 0;
			}
			else {
				i++;
			}
			if (DEBUG) {
				// DEBUG
				System.out.println("i:" + i + " j:" + j);
			}
		}
		return arr;
	}
	
	public static void main(String args[] ) throws Exception {
		String[][] inputArray = {{"Chennai", "Bangalore"}, {"Bombay", "Delhi"}, {"Goa", "Chennai"}, {"Delhi", "Goa"}, {"Bangalore", "Beijing"}};
	
		//String[][] inputArray = {{"Chennai", "Bangalore"},  {"Bangalore", "Beijing"}, {"Bombay", "Delhi"}, {"Goa", "Chennai"}, {"Delhi", "Goa"}};
		printArray("Input: ", inputArray);
		
		String[][] outputArray = findTripPath(inputArray);
		printArray("Output: ", outputArray);
	
	}
}
