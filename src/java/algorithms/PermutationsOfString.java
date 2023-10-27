import java.util.*;

/**
 * @author Francisco Franco
 *
 * A permutation is an arrangement of all or part of a set of objects, 
 * with regard to the order of the arrangement.
 *
 * Examples:
 *
 * Input: str = cd 
 * Output: cd dc
 *
 * Input: str = abb 
 * Output: abb abb bab bba bab bba 
 *
 */

public class PermutationsOfString {
	
	// Recursive method that prints out each permutation of string
	// Time Complexity: O(N^2), where N is the length of the given string
	// Auxiliary Space: O(N)
	private static String permutationRecursive(String prefix, String str) {
		// DEBUG
		//System.out.println("prefix: " + prefix + " str: " + str);
    int strLength = str.length();
		String remainingChars = null;
		String start = null , end = null;
		StringBuilder builder = new StringBuilder();
		// BASE CASE FOR RECURSIVE TERMINATION
		// WHERE PREFIX BECOMES THE PERMUTATION
    if (strLength == 0) {
			// DEBUG
			//System.out.println("prefix: " + prefix);
			return prefix;
		}
    else {
			for (int i = 0; i < strLength; i++) {
				// DEBUG
				//System.out.println("i: " + i + " str: " + str);
				// Method substring excludes i here
				start = str.substring(0, i);
				// DEBUG
				//System.out.println("start: " + start);
				// Method substring excludes strLength here
				end = str.substring(i+1, strLength);
				// DEBUG
				//System.out.println("end: " + end);
				remainingChars = start + end;
				builder.append(permutationRecursive(prefix + str.charAt(i), remainingChars));
				if (i < strLength - 1) {
					builder.append(", ");
				}
			}
		}
		return builder.toString();
	}

	// Iterative method that prints out each permutation of string
	private static void permutationIterative(String str) {
		// Queue uses FIFO (like a Lunch Line)
		Queue<String> currentQueue = null;
		Queue<String> nextQueue = null;
		int charNumber = 1;
		String prefix = null;
		String permChars = null;
		// Add char c to middle of permChars below
		for (char c : str.toCharArray()) {
			// DEBUG
			System.out.println("##################");
			// DEBUG
			System.out.println("charNumber: " + charNumber);
			if (currentQueue == null) {
				currentQueue = new ArrayDeque<>(1);
				currentQueue.add(String.valueOf(c));
				// DEBUG
				System.out.println("Initialized currentQueue: " + currentQueue);
			} 
			else {
				int currentQueueSize = currentQueue.size();
				// DEBUG
				System.out.println("currentQueueSize: " + currentQueueSize);
				int numElements = currentQueueSize * charNumber;
				// DEBUG
				System.out.println("numElements: " + numElements);
				nextQueue = new ArrayDeque<>(numElements);
				// DEBUG
				System.out.println("nextQueue: " + nextQueue);
				for (int i = 0; i < currentQueueSize; i++) {
				  prefix = currentQueue.remove();
					// DEBUG
					System.out.println("prefix: " + prefix);
					for (int j = 0; j < charNumber; j++) {
						permChars = prefix.substring(0, j) + c + prefix.substring(j, prefix.length());
						// DEBUG
						System.out.println("permChars: " + permChars);
						nextQueue.add(permChars);
					}
				}
				currentQueue = nextQueue;
			}
			charNumber++;
		}
		System.out.println(currentQueue);
	}
	
	public static void permutationRecursive(String str) {
		String allPermutations = permutationRecursive("", str);
		System.out.println("[" + allPermutations + "]");
	}
	
	// Driver code
	public static void main(String[] args) {
		String s = "abb";
		System.out.println("Orig:" + s);
		//String s = "ABC";
		//String s = "ABCD";
		System.out.println("Recursive:");
		permutationRecursive(s);
		System.out.println("Iterative:");
		permutationIterative(s);
	}
}
