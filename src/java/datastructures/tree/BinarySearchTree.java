//package com.sandbox.datastructures.tree;

/**
 * @author Francisco Franco
 * 
 * A binary tree is a tree whose elements
 * have at most 2 children.  For example, 
 * each node has 0 children, 1 child, or 2 children. 
 * Java program to search a given data key in a given BST
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(n)
 * 
 */ 

public class BinarySearchTree {
	Node root = null;
	
	// 	// Inner class
	// 	public class Node {
	//     int data;
	//     Node left, right;
	
	//     public Node(int item) {
	// 			data = item;
	// 			left = right = null;
	//     }
	// 	}
	
	/**
	 * @param status
	 */
	private void printResult(int data, boolean notFound) {
		if (notFound) {
			System.out.println("Data: " + data + " not found");
		}
		else {
			System.out.println("Data: " + data + " found");
		}
	}
	
	// A utility function to insert
	// a new node with given data key in BST
	public Node insert(Node root, int data) {
		// If the tree is empty, return a new node
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		// Otherwise, recur down the tree
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);
		
		// Return the (unchanged) root pointer
		return root;
	}
	
	// Utility function to search a data in a BST
	public Node search(Node root, int data) {
		// Base Cases: root is null or data is present at root
		if (root == null || root.data == data)
			return root;
		
		// Data key is greater than root's data key
		if (root.data < data)
			return search(root.right, data);
		
		// Data key is smaller than root's data key
		return search(root.left, data);
	}
	
	// Driver Code
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		// Inserting nodes
		tree.root = tree.insert(tree.root, 4);
		tree.insert(tree.root, 2);
		tree.insert(tree.root, 3);
		tree.insert(tree.root, 1);
		tree.insert(tree.root, 7);
		tree.insert(tree.root, 6);
		tree.insert(tree.root, 8);

		// Print BST via BinaryTreePrintRootToLeaf
		BinaryTreePrintRootToLeaf btPrint = new BinaryTreePrintRootToLeaf();
		btPrint.printPaths(tree.root);
		
		// Search for this data key
		int key = 7;
		
		// Searching in a BST
		tree.printResult(key, (tree.search(tree.root, key) == null));
		
		// Search for this data key
		key = 20;
		
		// Searching in a BST
		tree.printResult(key, (tree.search(tree.root, key) == null));
	}
}
