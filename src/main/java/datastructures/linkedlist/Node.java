
/**
 * @author Francisco Franco
 *
 * Node class used in linked list data structures
 */

public class Node {
	public int data;
	public Node prev;
	public Node next;
	
	// =================
	// Constructors
	// =================
	
	public Node (int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	// =================
	// Public methods
	// =================
	
	public Node (int data, Node next) {
		this.data = data;
		this.next = next;
	}
	
	public Node (int data, Node prev, Node next) {
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public int getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}
	
	@Override
	public String toString() {
		String objStr = "Node [data=" + data
			+ ", prev=" + prev 
			+ ", next=" + next
			+ "]";
		return objStr;
	}
}
