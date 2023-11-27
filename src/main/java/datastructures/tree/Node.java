
/**
 * @author Francisco Franco
 *
 * Node class used in tree data structure
 */

public class Node {
	int data;
	Node left, right;

	// =================
	// Constructor
	// =================
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public int getData() {
		return data;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	@Override
	public String toString() {
		String objStr = "Node [data=" + data 
			+ "]";
		return objStr;
	}
}
