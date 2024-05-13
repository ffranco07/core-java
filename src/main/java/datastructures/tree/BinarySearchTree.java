//package com.sandbox.datastructures.tree;

/**
 * @author Francisco Franco
 * 
 * A binary tree is a tree whose elements
 * have at most 2 children.  For example, 
 * each node has 0 children, 1 child, or 2 children. 
 * Java program to search a given data key in a given BST
 * 
 * Tree Structure Terms
 * Node: An object containing a key or value. 
 *       Almost all nodes have pointers to child nodes.
 *       Leaf nodes do not link to child nodes.
 * Root: The node at the top of the tree. Only 1 root per tree.
 * Edge: The link between two nodes.
 * Parent: Any node (except root) with 1 edge upward to a node.
 * Child: The node below a parent node connected by its edge downward.
 * Degree of a node: The total number of branches of that node.
 * Height of a node: Number of edges to its most distant leaf node. 
 * Depth of a node:  Number of edges back up to the root.
 * Subtree: The descendants of a node.
 * Forest: A collection of disjoint trees
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
	
	// Insert node data in BST
	public Node insert(Node root, int data) {
		// If the tree is empty, return a new node
		if (root == null) {
			root = new Node(data);
			return root;
		}
		
		// Otherwise, recurse down the tree
		// to insert as either left or right 
		// child node depending on data value
		if (data < root.data)
			root.left = insert(root.left, data);
		else if (data > root.data)
			root.right = insert(root.right, data);
		
		// Return the (unchanged) root pointer
		return root;
	}
	
	// Search for node data in a BST
	public Node search(Node root, int data) {
		// Base cases
		// Root is null so return root as null
		// Data key matches root's data so return root node
		if (root == null || data == root.data) {
			return root;
		}
		// Data key is less than root's data key
		else if (data < root.data) {
			return search(root.left, data);
		}
		// Data key is greater than root's data key
		else if (data > root.data) {
			return search(root.right, data);
		}
		return null;
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
