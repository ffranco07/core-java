import java.util.List;
import java.util.ArrayList;

/**
 * @author Francisco Franco
 *
 * Flatten 2D array to 1D array
 */

public class Flatten2DArray {
	
	public static void printArray(int[] array) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			builder.append(array[i]);
		}
		System.out.println(builder.toString());
	}
	
	public static int[] flattenArray(int[][] array) {
		List<Integer> retList = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				retList.add(array[i][j]);
			}
		}
		return retList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void main(String[] args) {
		int[][] inputArray = {{1, 2}, {3, 4}, {5, 6, 7, 8, 9}};
		int[] retArray = flattenArray(inputArray);
		printArray(retArray);
	}
}
