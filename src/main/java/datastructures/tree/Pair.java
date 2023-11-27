/**
 * @author Francisco Franco
 *
 * Node class used in linked list data structure
 */

public class Pair {
	Node node;
	int depth;
	int currSum;
	
	// =================
	// Constructors
	// =================
	
	Pair(Node node, int depth) {
		this.node = node;
		this.depth = depth;
	}
	
	Pair(Node node, int depth, int currSum) {
		this.node = node;
		this.depth = depth;
		this.currSum = currSum;
	}

	@Override
	public String toString() {
		String objStr = "Pair [depth=" + depth 
			+ "]";
		return objStr;
	}
}
