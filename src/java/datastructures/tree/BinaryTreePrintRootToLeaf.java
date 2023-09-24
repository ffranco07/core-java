package com.sandbox.datastructures.tree;

/**
 * @author Francisco Franco
 *
 * Print Node values from root to leafs
 *
 * NOTES: 
 * 1) Node has reference to Left and Right Nodes
 * 2) Ordered search where where left <= n < right
 */

public class BinaryTreePrintRootToLeaf {
	// Inner class
	private class Node {
		public int value;
		public Node leftNode;
		public Node rightNode;
		
		public Node(int value) {
			this.value = value;
			this.leftNode = null;
			this.rightNode = null;
		}
	}
	
	// Invoke recursive function
	private void printPaths(Node node) {
		// path value array
		int path[] = new int[1000];
		printPathsRecursive(node, path, 0);
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
		// Add this node to path array
		path[fillCount] = node.value;
		fillCount++;
		
		// Terminating recursive condition
		if (node.leftNode == null && node.rightNode == null) {
			printArray(path, fillCount);
		}
		else {
			printPathsRecursive(node.leftNode, path, fillCount);
			printPathsRecursive(node.rightNode, path, fillCount);
		}
	}
	
	// Print out array
	private void printArray(int[] path, int fillCount) {
		for (int i = 0; i < fillCount; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println("");
	}
	
	// Main method to execute functions above
	public static void main(String[] args) {
		BinaryTreePrintRootToLeaf tree = new BinaryTreePrintRootToLeaf();
	  BinaryTreePrintRootToLeaf.Node root = tree.new Node(3);
		root.leftNode = tree.new Node(2);
		root.rightNode = tree.new Node(7);
		root.leftNode.leftNode = tree.new Node(1);
		root.rightNode.leftNode = tree.new Node(6);
		root.rightNode.rightNode = tree.new Node(8);
		root.rightNode.rightNode.rightNode = tree.new Node(9);
		tree.printPaths(root);
	}
}
