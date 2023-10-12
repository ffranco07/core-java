/**
 * @author Francisco Franco
 *
 * The Challenge
 *
 * Write a function that takes in a 2-dimensional array 
 * that represents garden plots and the amount of carrots 
 * each plot contains. This function should return the 
 * number of carrots eaten by Baby Leveret.
 *
 * Start at center then traverse 
 * WNES (WEST->NORTH-EAST->SOUTH)
 *
 * 	         A   B   C   D   E   F   G
 *        +---------------------------+
 *     1  | 2 | 3 | 1 | 4 | 2 | 2 | 3 |
 *        |---+---+---+---+---+---+---|
 *     2  | 2 | 3 | 0 | 4 | 0 | 3 | 0 |
 *        |---+---+---+---+---+---+---|
 *     3  | 1 | 7 | 0 | 2 | 1 | 2 | 3 |
 *        |---+---+---+---+---+---+---|
 *     4  | 9 | 3 | 0 | 4 | 2 | 0 | 3 |
 */

public class LeveretMunch {

	/**
	 * @param gardenPlot
	 * @return
	 */
	public static int getEatenCarrots(int[][] gardenPlot) {
		int rows = gardenPlot.length;
		int columns = gardenPlot[0].length;

		System.out.println("rows:" + rows);
		System.out.println("columns:" + columns);
		
		int xIndex = rows/2 - 1;
		int yIndex = columns/2;
		
		System.out.println("1) xIndex:" + xIndex);
		System.out.println("1) yIndex:" + yIndex);

		// Plot value closest to center
		int lastVal = gardenPlot[xIndex][yIndex];
		int nextVal = gardenPlot[xIndex + 1][yIndex];
		int consumed = 0;
		
		boolean isLastWest = false;
		boolean isLastNorth = false;
		boolean isLastEast = false;
		boolean isLastSouth = false;

		if (nextVal > lastVal) {
			lastVal = nextVal;
			consumed+=nextVal;
			xIndex++;
		}
		else {
			consumed = lastVal;
		}
		
		System.out.println("1) lastVal:" + lastVal);
		System.out.println("1) consumed:" + consumed);
		
		while (xIndex >= 0 && yIndex >= 0) {
			System.out.println("2) xIndex:" + xIndex);
			System.out.println("2) yIndex:" + yIndex);
			System.out.println("2) lastVal:" + lastVal);
			System.out.println("2) consumed:" + consumed);

			try {
				Thread.sleep(1000);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			// Check next value WEST
			if (yIndex > 0 && !isLastWest) { 
				nextVal = gardenPlot[xIndex][yIndex - 1];
				System.out.println("WEST nextVal:" + nextVal);
				if (nextVal >= lastVal) {
					lastVal = nextVal;
					consumed+=nextVal;
					yIndex--;
					isLastEast = true;
					continue;
				}
				else {
					lastVal = nextVal;
				}
			}
			else {
				isLastWest = false;
			}
			
			// Check next value NORTH
			if (xIndex > 0 && !isLastNorth) {
				nextVal = gardenPlot[xIndex - 1][yIndex];
				System.out.println("NORTH nextVal:" + nextVal);
				if (nextVal >= lastVal) {
					lastVal = nextVal;
					consumed+=nextVal;
					xIndex--;
					isLastSouth = true;
					continue;
				}
				else {
					lastVal = nextVal;
				}
			}
			else {
				isLastNorth = false;
			}
			
			// Check next value EAST
			if (yIndex < columns - 1 && !isLastEast) {
				nextVal = gardenPlot[xIndex][yIndex + 1];
				System.out.println("EAST nextVal:" + nextVal);
				if (nextVal >= lastVal) {
					lastVal = nextVal;
					consumed+=nextVal;
					yIndex++;
					isLastWest = true;
					continue;
				}
				else {
					lastVal = nextVal;
				}
			}
			else {
				isLastEast = false;
			}
			
			// Check next value SOUTH
			if (xIndex < rows - 1 && !isLastSouth) {
				nextVal = gardenPlot[xIndex + 1][yIndex];
				System.out.println("SOUTH nextVal:" + nextVal);
				if (nextVal >= lastVal) {
					lastVal = nextVal;
					consumed+=nextVal;
					xIndex++;
					isLastNorth = true;
					continue;
				}
				else {
					lastVal = nextVal;
				}
			}
			else {
				isLastSouth = false;
			}
			
			break;
		}
		return consumed;
	}
	
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		int[][] myArr = {{2, 3, 1, 4, 2, 2, 3}, {2, 3, 0, 4, 0, 3, 0}, {1, 7, 0, 2, 1, 2, 3}, {9, 3, 0, 4, 2, 0, 3}};
		int eatenCarrots = getEatenCarrots(myArr);
		System.out.println("eatenCarrots:" + eatenCarrots);
	}
}
		
