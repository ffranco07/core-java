/**
 * @author Francisco Franco
 *
 * Implementing a doubly linked list in java
 *
 * Time Complexity: O(1) -> for add/remove to front or end
 * Time Complexity: O(n) -> for search
 * Space Complexity: O(n)
 */

public class DoublyLinkedList {
	private int size = 0; // number of elements
	private Node head = null; // head of the list
	private Node tail = null; // tail of the list
	
	// ===================
	// Constructor
	// ===================

	public DoublyLinkedList() {
		size = 0;
	}
	
	// ===================
	// Inner class
	// ===================
	
	// 	public class Node {
	// 		int data; 
	// 		Node next;
	
	// 		public Node (int d) {
	// 			this.data = d;
	// 			this.next = null;
	// 		}
	// 	}

	// ===================
	// Private methods
	// ===================

	// Print linked list
	private void printLinkedList(DoublyLinkedList linkedList) {
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
	
	// ===================
	// Public methods
	// ===================
	
	// Add to end of list (unoptimized)
	// NOT optimized since need to iterate to last node in list every time
	// Time Complexity: O(n) 
	public boolean addUnoptimized(int data) {
		if (head == null) {
			head = new Node(data);
		}
		else {
			// Initialize last node with head
			Node last = head;
			
			// Iterate to last node with last.next = null 
			while(last.next != null) {
				last = last.next;
			}
			
			// Create new Node with data
			Node newNode = new Node(data);
			
			// Set newNode.prev pointer to last/tail node
			newNode.prev = last;
			
			// Add new node data to last node
			last.next = newNode;
		}
		size++;
		return true;
	}

	// Add to end using tail pointer
	// Optimized since using tail pointer directly 
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
			
			// Ex. List: A -> B -> C
			// tail points to C here
			// Set newNode.prev pointer for D to tail C
			newNode.prev = tail;
			
			// Ensures the previous tail node links to the new node.
			// Ex. List: A -> B -> C
			// tail still points to C here before tail is reinitialized which then sets tail to D
			tail.next = newNode;
			
			// Add new node data to last node
			// Ex. List: A -> B -> C -> D
			// The tail is reinitialized and tail is now set to D 
			tail = newNode;
		}
		size++;
		return true;
	}

	// Add to front 
	// Optimized since using head pointer directly 
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
 
	// Remove from specific position
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
			Node curr = head;
			for (int i = 0; i < position; i++) {
				curr = curr.next;
			}
			// Update curr.prev.next pointer to curr.next node since "curr" will be skipped/removed
			// Ex. List: A -> B -> C -> D
			// Ex. Remove index/position 1 which should be B
			// Ex. After for loop above, curr.prev will be A and "curr" will be B
			// Ex. curr.prev.next pointer (A pointer) will point to curr.next node which is C
			// After remove:
			// List: A -> C -> D
			curr.prev.next = curr.next;
		}
		size--;
	}
	
	// Remove from first
	// Time Complexity: O(1) 
	public void removeFirst() {
		if (head == null) {
			return;
		}
		head = head.next;
		size--;
	}
	
	// Remove last
	// Optimized since using tail.prev pointer directly 
	// Time Complexity: O(1)
	public void removeLast() {
		if (head == null || tail == null) { 
			return;
		}
		if (head == tail) {
			head = tail = null;
		}
		else {
			tail = tail.prev;
			tail.next = null;
		}
		size--;
	}
	
	// Driver code
	public static void main(String[] args) {
		DoublyLinkedList linkedList = new DoublyLinkedList();
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
		System.out.println("Removed First");
		linkedList.removeFirst();
		linkedList.printLinkedList(linkedList);
		System.out.println("#####################");
		System.out.println("Removed Last");
		linkedList.removeLast();
		linkedList.printLinkedList(linkedList);
	}
}
		
