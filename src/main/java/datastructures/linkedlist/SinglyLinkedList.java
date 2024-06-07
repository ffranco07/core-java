/**
 * @author Francisco Franco
 *
 * Implementing a singly linked list in java
 *
 * Time Complexity: O(1) -> for add/remove to front or add to end with tail pointer
 * Time Complexity: O(n) -> for search
 * Space Complexity: O(n)
 */

public class SinglyLinkedList {
	private int size = 0; // number of elements
	private Node head = null; // head of the list
	private Node tail = null; // tail of the list
	
	// Default constructor
	public SinglyLinkedList() {
		size = 0;
	}
	
	// 	// Inner class
	// 	public class Node {
	// 		int data; 
	// 		Node next;
	
	// 		public Node (int d) {
	// 			this.data = d;
	// 			this.next = null;
	// 		}
	// 	}
	
	// Add to end of list with no tail pointer
	// NOT optimized method since need to iterate to last node in list every time
	// Time Complexity: O(n) 
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

	// Linked list add to end using tail pointer 
	// Optimized method to add to the end of list using tail pointer directly 
	// Time Complexity: O(1) 
	public boolean addToEnd(int data) {
		if (head == null) {
			head = new Node(data);
			if (tail == null) {
				tail = head;
			}
		}
		else {
			// Create new node to add
			Node newNode = new Node(data);
			
			// Ensures the previous tail node links to the new node.
			// Ex. List: A -> B -> C -> D
			// tail still points to C here before tail is reinitailzed which then sets tail to D
			tail.next = newNode;
			
			// Add new node data to last node
			// Ex. List: A -> B -> C -> D
			// The tail is reinitialized and tail points to D 
			tail = newNode;
		}
		size++;
		return true;
	}

	// Linked list add to front 
	// Optimized method to add to the front of list using head pointer directly 
	// Time Complexity: O(1) 
	public boolean addToFront(int data) {
		if (head == null) {
			head = new Node(data);
			if (tail == null) {
				tail = head;
			}
		}
		else {
			// Create new node to add
			Node newNode = new Node(data);
			
			// Point newNode.next to the current head
			newNode.next = head;
			
			// Update head to the new node 
			head = newNode;
		}
		size++;
		return true;
	}
 
	// Time Complexity: O(n) (if position >= size) 
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
			Node prevNode = null;
			for (int i = 0; i < position; i++) {
				prevNode = last;
				last = last.next;
			}
			// Update prevNode.next pointer to last.next node since "last" will be removed
			// Ex. List: A -> B -> C -> D
			// Ex. Remove index/position 1 which should be B
			// Ex. After for loop above, prevNode will be A and "last" will be B
			// Ex. prevNode.next pointer (A pointer) will point to last.next node which is C
			// After remove:
			// List: A -> C -> D
			prevNode.next = last.next;
		}
		size--;
	}
	
	// Time Complexity: O(1) 
	public void removeFromFront() {
		if (head == null) {
			return;
		}
		head = head.next;
		size--;
	}
	
	// Print linked list
	public void printLinkedList(SinglyLinkedList linkedList) {
		StringBuffer buffer = new StringBuffer();
		if (linkedList.head == null) {
			buffer.append("NULL");
		}
		else {
			Node last = linkedList.head;
			while (last != null) {
				buffer.append(last.data);
				last = last.next;
				if (last != null) {
					buffer.append("->");
				}
			}
		}
		System.out.println("List: " + buffer.toString());
		System.out.println("size:" + size);
	}
	
	// Driver code
	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		//linkedList.addToFront(1);
		//linkedList.addToFront(2);
		//linkedList.addToFront(3);
		//linkedList.addToFront(4);
		linkedList.addToEnd(1);
		linkedList.addToEnd(2);
		linkedList.addToEnd(3);
		linkedList.addToEnd(4);
		System.out.println("#####################");
		linkedList.printLinkedList(linkedList);
		System.out.println("#####################");
		System.out.println("head: " + linkedList.head.getData());
		System.out.println("tail: " + linkedList.tail.getData());
		int index0 = 0, index1 = 1;
		System.out.println("#####################");
		System.out.println("Removed index: " + index0);
		linkedList.remove(index0);
		linkedList.printLinkedList(linkedList);
		System.out.println("#####################");
		System.out.println("Removed index: " + index1);
		linkedList.remove(index1);
		linkedList.printLinkedList(linkedList);
		System.out.println("#####################");
		System.out.println("Removed from Front");
		linkedList.removeFromFront();
		linkedList.printLinkedList(linkedList);
		System.out.println("#####################");
		System.out.println("Removed from Front");
		linkedList.removeFromFront();
		linkedList.printLinkedList(linkedList);
	}
}
		
