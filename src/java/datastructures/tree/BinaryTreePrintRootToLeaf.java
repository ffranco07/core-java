//package com.sandbox.datastructures.tree;

/**
 * @author Francisco Franco
 *
 * Print Node values from root to leafs
 *
 * NOTES: 
 * 1) Each Node has reference to Left and Right Nodes
 * 2) Ordered search where where left <= n < right
 */

public class BinaryTreePrintRootToLeaf {
	// 	// Inner class
	// 	private class Node {
	// 		public int data;
	// 		public Node left;
	// 		public Node right;
	
	// 		// Constructor
	// 		public Node(int value) {
	// 			this.data = value;
	// 			this.left = null;
	// 			this.right = null;
	// 		}
	// 	}
	
	// Print out array
	private void printArray(int[] path, int fillCount) {
		System.out.print("Tree path: ");
		for (int i = 0; i < fillCount; i++) {
			// Print on same line
			System.out.print(path[i]);
			if (i != fillCount - 1) {
				System.out.print("->");
			}
		}
		// Print new line
		System.out.println("");
	}
	
	/**
	 * Time Complexity: O(n^2)
	 * 
	 * @param node
	 * @param path
	 * @param fillCount
	 */
	private void printPathsRecursive(Node node, int[] path, int fillCount) {
		// Terminating recursive condition
		if (node == null) {
			return;
		}
		// Add this node to path array and 
		// increment fill node count in array
		path[fillCount] = node.data;
		fillCount++;
		
		// Terminating recursive condition at leaf node
		if (node.left == null && node.right == null) {
			printArray(path, fillCount);
		}
		else {
			printPathsRecursive(node.left, path, fillCount);
			printPathsRecursive(node.right, path, fillCount);
		}
	}

	// Invoke recursive function
	public void printPaths(Node node) {
		// path value array
		int path[] = new int[10];
		printPathsRecursive(node, path, 0);
	}
	
	// Main method to execute functions above
	public static void main(String[] args) {
		BinaryTreePrintRootToLeaf tree = new BinaryTreePrintRootToLeaf();
		Node root = new Node(3);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		root.right.right.right = new Node(9);
		tree.printPaths(root);
	}
}
