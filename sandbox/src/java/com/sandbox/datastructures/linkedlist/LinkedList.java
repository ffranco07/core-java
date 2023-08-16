public class LinkedList {
	private int size = 0; // number of elements
	private Node head = null; // head of the list
	
	public LinkedList() {}
	
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
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.printLinkedList(linkedList);
	}
}
		
