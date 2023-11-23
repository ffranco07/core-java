/**
 * @author Francisco Franco
 *
 * Java program to find and print the middle element of linked list
 *
 */
public class LinkedListFindMiddle {
	Node head = null;
	int size = 0;
	
	// 	// Inner class
	// 	public class Node {
	// 		private int data;
	// 		private Node next;
	
	// 		public Node(int data) {
	// 			this.data = data;
	// 			this.next = null;
	// 		}
	
	// 		public int getData() {
	// 			return data;
	// 		}
	
	// 		public Node getNext() {
	// 			return next;
	// 		}
	// 	}
	
	// Print input data array
	private void printDataArray(int[] dataArray) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (int i = 0; i < dataArray.length; i++) {
			builder.append(dataArray[i]);
			if (i < (dataArray.length - 1)) {
				builder.append(",");
			}
		}
		builder.append("}");
		System.out.println(builder.toString());
	}

	// Set linked list node array from data array
	public void addNodes(int[] dataArray) {
		Node last = null;
		for (int i = 0; i < dataArray.length; i++) {
			// DEBUG
			System.out.println("last: " + last);
			if (head == null) {
				head = new Node(dataArray[i]);
				last = head;
			}
			else {
				last.next = new Node(dataArray[i]);
				last = last.next;
			}
			size++;
		}
	}

	// Find node 
	public Node findNode(int index) {
		if (head == null) {
			return null;
		}
		Node last = head;
		int count = 0;
		while (last != null) {
			if (count == index) {
				return last;
			}
			last = last.next;
			count++;
		}
		return null;
	}
	
	// Find middle index
	public void findMiddleNode() {
		int midIndex = -1;
		Node midNode = null;
		System.out.println("#########");
		// Check if linked list size is ODD since subtracting 1 from it
		if ((size - 1) % 2 == 0) {
			midIndex = size / 2;
			// DEBUG
			System.out.println("midIndex:" + midIndex);
			midNode = findNode(midIndex);
			if (midNode != null) {
				// Print out middle element
				System.out.println("element: " + findNode(midIndex).toString());
			}
		}
		else {
			// The linked list size is EVEN here
			System.out.println("There are 2 middle nodes, printing second middle element");
			midIndex = size / 2;
			// DEBUG
			System.out.println("midIndex:" + midIndex);
			midNode = findNode(midIndex);
			if (midNode != null) {
				// Print out middle element
				System.out.println("element: " + findNode(midIndex).toString());
			}
		}
	}
	
	// Most elegant solution using the fast and slow pointer technique. 
	// If we have one pointer moving twice as fast as the other, then by the time it 
	// reaches the end, the slow pointer will be halfway through since it is moving 
	// at half the speed.
	public Node findMiddleWithFastSlowPointers() {
    Node slow = head;
    Node fast = head;
		int count = 0;
    while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			count++;
    }
		// DEBUG
		System.out.println("#########");
		System.out.println("Via fast/slow pointers:");
		// DEBUG
		System.out.println("midIndex:" + count);
		// Print out middle element
		System.out.println("element: " + findNode(count).toString());
		return slow;
	}
	
	// Driver code
	public static void main(String[] args) {
		// Initialize data array
		int[] dataArray = {1, 2, 3, 4, 5};
		
		// Create linked list instance
		LinkedListFindMiddle linkedList = new LinkedListFindMiddle();
		
		// Print data array
		linkedList.printDataArray(dataArray);
		
		// Add data array to linked list
		linkedList.addNodes(dataArray);

		// Find middle index of linked list
		linkedList.findMiddleNode();

		// Find middle index of linked list with fast and slow pointers technique
		linkedList.findMiddleWithFastSlowPointers();
	}
}

	
