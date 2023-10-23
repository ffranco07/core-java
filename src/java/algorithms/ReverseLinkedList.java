public class ReverseLinkedList {
	
	public static Node reverse(Node n) {
		Node tail = n;
		while (tail.next != null) {
			System.out.println("reverse ... tail.val is: " + tail.val + " tail.next is: " + tail.next);
			tail = tail.next;
		}
		reverseHelper(n);
		return (tail);
	}
	
	public static Node reverseHelper(Node n) {
		System.out.println("reverseHelper ... n.val is: " + n.val + " n.next is: " + n.next);
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
	
	public static void main(String[] args) {
		Node n = new Node(1, new Node(2, new Node(3, new Node(20, null))));
		display(n);
		n = reverse(n);
		display(n);
	}
	
	public static class Node {
		int val;
		Node next;
		
		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return "" + val;
		}
	}
}
