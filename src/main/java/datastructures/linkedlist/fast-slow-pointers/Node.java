
/**
 * @author Francisco Franco
 *
 * Node class used in linked list data structure
 */

public class Node {
	public int data; 
	public Node next;
	
	// =================
	// Constructors
	// =================
	
	public Node (int d) {
		this.data = d;
		this.next = null;
	}

	public Node (int d, Node next) {
		this.data = d;
		this.next = next;
	}
	
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}

	@Override
	public String toString() {
		String objStr = "Node [data=" + data 
			+ "]";
		return objStr;
	}
}
