import java.util.List;
import java.util.ArrayList;

/**
 * @author Francisco Franco
 *
 * Module that find first non-repeating
 * String word in ArrayList
 */

public class FirstNonRepeatingWord {

	public static int[] counts;

	private static void printArray(List<String> inputStr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < inputStr.size(); i++) {
			builder.append(inputStr.get(i));
			if (i != inputStr.size() - 1) {
				builder.append(",");
			}
		}
		System.out.println(builder.toString());
	}

	private static void setWordCounts(List<String> inputList) {
		counts = new int[inputList.size()];
		int j;
		for (int i = 0; i < inputList.size(); i++) {
			j = i + 1;
			while (j < inputList.size()) {
				if (inputList.get(i).equals(inputList.get(j))) {
					counts[i]++;
				}
				j++;
			}
		}
	}

	private static int findIndex(List<String> inputList) {
		setWordCounts(inputList);
		for (int k = 0; k < counts.length; k++) {
			if (counts[k] == 0) {
				return k;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("me");
		myList.add("you");
		myList.add("him");
		myList.add("me");
		printArray(myList);
		int index = findIndex(myList);
		System.out.println("index: " + index);
	}
}
