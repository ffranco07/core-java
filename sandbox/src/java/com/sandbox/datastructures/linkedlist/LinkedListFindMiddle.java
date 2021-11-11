/**
 * @author Francisco Franco
 *
 * Java program to find and print the middle element of linked list
 *
 */
public class LinkedListFindMiddle {
	Node[] nodeArray = null;

	public LinkedListFindMiddle(int size) {
		nodeArray = new Node[size];
	}
	
	// Inner class
	public class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public int getData() {
			return data;
		}

		public Node getNext() {
			return next;
		}
	}

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
	
	public static void main(String[] args) {
		// Initialize data array
		int[] dataArray = {1, 2, 3, 4, 5, 6};
		
		// Initialize linked list
		LinkedListFindMiddle linkedList = new LinkedListFindMiddle(dataArray.length);

		// Print data array
		linkedList.printDataArray(dataArray);
		
		// Set linked list node array from data array
		LinkedListFindMiddle.Node node = null;
		for (int i = 0; i < dataArray.length; i++) {
			node = linkedList.new Node(dataArray[i]);
			if (i < (dataArray.length - 1)) {
				node.next = node;
			}
			linkedList.nodeArray[i] = node;
		}
		
		int midIndex;
		if ((linkedList.nodeArray.length - 1) % 2 == 0) {
			// DEBUG
			//System.out.println("Linked list node array length minus 1 is EVEN");
			midIndex = linkedList.nodeArray.length / 2;
			// DEBUG
			//System.out.println("midIndex:" + midIndex);
			// Print out middle element
			System.out.println("Middle element:" + linkedList.nodeArray[midIndex].getData());
		}
		else {
			// DEBUG
			//System.out.println("Linked list node array length minus 1 is ODD");
			midIndex = linkedList.nodeArray.length / 2;
			// DEBUG
			//System.out.println("midIndex:" + midIndex);
			System.out.println("There are 2 middle nodes, printing second middle element");
			// Print out middle element
			System.out.println("Middle element:" + linkedList.nodeArray[midIndex].getData());
		}
	}
}

	
