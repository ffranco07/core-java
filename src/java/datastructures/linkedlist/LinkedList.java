/**
 * @author Francisco Franco
 *
 * Implementing a Linked List in java
 *
 */

public class LinkedList {
	private int size = 0; // number of elements
	private Node head = null; // head of the list
	
	// Default constructor
	public LinkedList() {
		size = 0;
	}
	
	// Inner class
	public class Node {
		int data; 
		Node next;
		
		public Node (int d) {
			this.data = d;
			this.next = null;
		}
	}
	
	// Linked list add method
	public boolean add(int data) {
		if (head == null) {
			head = new Node(data);
		}
		else {
			// Initialize last node with head
			Node last = head;
			
			// Iterate to last node
			while(last.next != null) {
				last = last.next;
			}
			
			// Add new node data to last node
			last.next = new Node(data);
		}
		size++;
		return true;
	}

	public void remove(int position) {
		// Remove first node if position value is negative
		if (position < 0) {
			position = 0;
		}
		// Remove last node if position value 
		// is greater than or equal to size
		else if (position >= size) {
			position = size - 1;
		}
		
		if (head == null) {
			return;
		}

		if (position == 0) {
			head = head.next;
		}
		else {
			Node last = head;
			Node prevNode = null;;
			
			for (int i = 0; i < position; i++) {
				prevNode = last;
				last = last.next;
			}
			
			// Update previous node's next pointer to 
			// last.next node since "last" will be removed
			prevNode.next = last.next;
		}
		size--;
	}
	
	// Print linked list
	public void printLinkedList(LinkedList linkedList) {
		if (linkedList.head == null) {
			System.out.println("linked list is NULL");
		}
		else {
			Node last = linkedList.head;
			while (last != null) {
				System.out.println("data:" + last.data);
				last = last.next;
			}
		}
	}
	
	// Driver code
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.remove(1);
		linkedList.printLinkedList(linkedList);
	}
}
		
