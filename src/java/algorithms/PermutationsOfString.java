import java.util.*;

/**
 * @author Francisco Franco
 *
 */

public class PermutationsOfString {
	
	// Recursive method that prints out each permutation of string
	// Time Complexity: O(N^2), where N is the length of the given string
	// Auxiliary Space: O(N)
	private static void permutation(String prefix, String str) {
    int strLength = str.length();
		String remainingChars = null;
		String start = null , end = null;
		// DEBUG
		//System.out.println("prefix: " + prefix);
		// DEBUG
		//System.out.println("str: " + str);
		// BASE CASE FOR RECURSIVE TERMINATION
    if (strLength == 0) {
			System.out.println("perm: " + prefix);
		}
    else {
			for (int i = 0; i < strLength; i++) {
				// DEBUG
				//System.out.println("i: " + i + " str: " + str);
				start = str.substring(0, i);
				// DEBUG
				//System.out.println("start: " + start);
				end = str.substring(i+1, strLength);
				// DEBUG
				//System.out.println("end: " + end);
				remainingChars = start + end;
				permutation(prefix + str.charAt(i), remainingChars);
			}
		}
	}

	// Iterative method that prints out each permutation of string
	private static void permutationIterative(String str) {
		// Queue uses FIFO (like a Lunch Line)
		Queue<String> currentQueue = null;
		int charNumber = 1;
		for (char c : str.toCharArray()) {
			if (currentQueue == null) {
				currentQueue = new ArrayDeque<>(1);
				currentQueue.add(String.valueOf(c));
			} 
			else {
				int currentQueueSize = currentQueue.size();
				int numElements = currentQueueSize * charNumber;
				Queue<String> nextQueue = new ArrayDeque<>(numElements);
				for (int i = 0; i < currentQueueSize; i++) {
					String tempString = currentQueue.remove();
					for (int j = 0; j < charNumber; j++) {
						int n = tempString.length();
						nextQueue.add(tempString.substring(0, j) + c + tempString.substring(j, n));
					}
				}
				currentQueue = nextQueue;
			}
			charNumber++;
		}
		System.out.println(currentQueue);
	}
	
	public static void permutation(String str) { 
    permutation("", str); 
	}
	
	// Driver code
	public static void main(String[] args) {
		String s = "ABC";
		System.out.println("Orig:" + s);
		//String s = "ABC";
		//String s = "ABCD";
		System.out.println("RECURSIVE:");
		permutation(s);
		System.out.println("ITERATIVE:");
		permutationIterative(s);
	}
}
