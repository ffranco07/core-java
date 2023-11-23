/**
 * @author Francisco Franco
 *
 */

public class ReverseLinkedList {
	
	public static Node reverse(Node n) {
		Node tail = n;
		while (tail.next != null) {
			System.out.println("reverse ... tail.data is: " + tail.data + " tail.next is: " + tail.next);
			tail = tail.next;
		}
		reverseHelper(n);
		return (tail);
	}
	
	public static Node reverseHelper(Node n) {
		System.out.println("reverseHelper ... n.data is: " + n.data + " n.next is: " + n.next);
		if (n.next != null) {
			Node reverse = reverseHelper(n.next);
			// Set reverse next pointer from null to previous node
			reverse.next = n;
			// Set current node pointer to null;
			n.next = null;
			return (n);
		}
		return (n);
	}
	
	public static void display(Node n) {
		for (; n != null; n = n.next) {
			System.out.println(n);
		}
	}

	// Print linked list
	public static void printLinkedList(Node head) {
		StringBuffer buffer = new StringBuffer();
		if (head == null) {
			buffer.append("linked list is NULL");
		}
		else {
			Node last = head;
			while (last != null) {
				buffer.append(last.data);
				last = last.next;
				if (last != null) {
					buffer.append("->");
				}
			}
			System.out.println(buffer.toString());
		}
	}
	
	// Driver code
	public static void main(String[] args) {
		Node n = new Node(1, new Node(2, new Node(3, new Node(20, null))));
		printLinkedList(n);
		n = reverse(n);
		printLinkedList(n);
	}
}
