//package com.sandbox.datastructures.linkedlist;

/**
 * @author Francisco Franco
 *
 * Given two numbers represented by two lists, write a function 
 * that returns the sum in the form of a linked list.
 *
 * Example:
 *    Input: 
 *    List1: 7->5->9->4->6 // represents number 75946
 *    List2: 8->4 // represents number 84
 *    Output: 
 *    Resultant list: 7->6->0->3->0// represents number 76030
 *    Explanation: 75946+84=76030
 *
 * NOTES: 
 * 1) Node only has reference to Next Node
 *
 */

public class LinkedListAddNumbers {
	public static Node head1, head2;
	
	// 	public static class Node {
	// 		int data;
	// 		Node next;
	
	// 		Node(int d) {
	// 			data = d;
	// 			next = null;
	// 		}
	// 	}

	// Appends preceding zeros in case a list is having lesser nodes than the other one
	private void addPrecedingZeros(Node start1, Node start2) {
		Node next1 = start1.next;
		Node next2 = start2.next;
		while (next1 != null && next2 != null) {
			next1 = next1.next;
			next2 = next2.next;
		}
		if (next1 == null && next2 != null) {
			while (next2 != null) {
				Node node = new Node(0);
				node.next = start1.next;
				start1.next = node;
				next2 = next2.next;
			}
		} 
		else if (next2 == null && next1 != null) {
			while (next1 != null) {
				Node node = new Node(0);
				node.next = start2.next;
				start2.next = node;
				next1 = next1.next;
			}
		}
	}

	// Adds lists and returns the carry
	private int sumTwoNodes(Node first, Node second, Node result) {
		if (first == null) {
			return 0;
		}
		int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
		Node node = new Node(number % 10);
		node.next = result.next;
		result.next = node;
		return number / 10;
	}
	
	/* 
	 * Adds contents of two linked lists 
	 * and return the head node of resultant list 
	 */
	 /* Adds contents of two linked lists and prints it */
	public Node addTwoLists(Node first, Node second) {
		Node start1 = new Node(0);
		start1.next = first;
		Node start2 = new Node(0);
		start2.next = second;
		
		addPrecedingZeros(start1, start2);
		Node result = new Node(0);
		if (sumTwoNodes(start1.next, start2.next, result) == 1) {
			Node node = new Node(1);
			node.next = result.next;
			result.next = node;
		}
		// Since result node with 0 value just a holder
		return result.next;
	}
	
	// Utility function to print a linked list
	public void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println("");
	}
	
	// Main method to execute functions above
	public static void main(String[] args) {
		LinkedListAddNumbers list = new LinkedListAddNumbers();
		
		// creating first list
		list.head1 = new Node(7);
		list.head1.next = new Node(5);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(4);
		list.head1.next.next.next.next = new Node(6);
		System.out.print("First List: ");
		list.printList(head1);
		
		// creating seconnd list
		list.head2 = new Node(8);
		list.head2.next = new Node(4);
		System.out.print("Second List: ");
		list.printList(head2);
		
		// add the two lists and see the result
		Node rs = list.addTwoLists(head1, head2);
		System.out.print("Resultant List: ");
		list.printList(rs);
	}
}
