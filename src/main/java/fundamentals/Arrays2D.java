public class Arrays2D {
	public static String columnToStr(int[] column) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (int k = 0; k < column.length; k++) {
			builder.append(column[k]);
			if (k < (column.length - 1)) {
				builder.append(", ");
			}
		}
		builder.append("}");
		return builder.toString();
	}
	
	public static void main(String args[]) {
		// Java stores as "array of arrays"
		// 3 arrays with 4 elements each OR
		// 3 rows, with 4 columns
		int[][] arr2d={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println("arr2d:" + arr2d);
		System.out.println("arr2d length:" + arr2d.length);
		System.out.println("arr2d[0]:" + columnToStr(arr2d[0]));
		System.out.println("arr2d[0] length:" + arr2d[0].length);
		System.out.println("arr2d[1]:" + columnToStr(arr2d[1]));
		System.out.println("arr2d[1] length:" + arr2d[1].length);
		System.out.println("arr2d[2]:" + columnToStr(arr2d[2]));
		System.out.println("arr2d[2] length:" + arr2d[2].length);
		System.out.println("arr2d[0][3]:" + arr2d[0][3]);

		int rows = arr2d.length;
		System.out.println("rows:" + rows);
		int columns = arr2d[0].length;
		System.out.println("columns" + columns);
		int i, j;
		StringBuilder builder = new StringBuilder();
		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				builder.append(arr2d[i][j] + " ");
			}
			if (j != (columns - 1)) {
				builder.append("\n");
			}
		}
		System.out.println(builder.toString());
	}
}
