/**
 * @author Francisco Franco
 *
 * Implementing a Linked List in java
 *
 * Time Complexity: O(1) -> for add/remove from beginning
 * Time Complexity: O(n) -> for search
 * Space Complexity: O(n)
 */

public class LinkedList {
	private int size = 0; // number of elements
	private Node head = null; // head of the list
	
	// Default constructor
	public LinkedList() {
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
			Node prevNode = null;
			int nodeIndex = 1;

			//while (last.next != null) {
			//prevNode = last;
			//last = last.next;
			//if (nodeIndex == position) {
			//prevNode.next = last.next;
			//	break;
			//}
			//}
			
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
		StringBuffer buffer = new StringBuffer();
		if (linkedList.head == null) {
			buffer.append("linked list is NULL");
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
			System.out.println(buffer.toString());
			System.out.println("size:" + size);
		}
	}
	
	// Driver code
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.printLinkedList(linkedList);
		int index0 = 0, index1 = 1;
		linkedList.remove(index0);
		System.out.println("Remove index: " + index0);
		linkedList.printLinkedList(linkedList);
		linkedList.remove(index1);
		System.out.println("Remove index: " + index1);
		linkedList.printLinkedList(linkedList);
	}
}
		
