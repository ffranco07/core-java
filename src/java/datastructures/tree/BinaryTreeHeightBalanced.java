//package com.sandbox.datastructures.tree;

/**
 * @author Francisco Franco
 * 
 * A binary tree is a tree whose elements
 * have at most 2 children.  For example, 
 * each node has 0 children, 1 child, or 2 children. 
 * Java program to determine if binary tree
 * is height balanced or not
 * 
 * An empty tree (T) is height balanced.
 * A non empty binary tree (T) is height balanced if:
 *    1) Left subtree of T is balanced
 *    2) Right subtree of T is balanced
 *    3) The difference between heights of left subtree
 *       and right subtree is not more than 1
 *
 * A AVL tree is a balanced binary search tree
 * AVL - Adelson-Velskii and Landis (inventors)
 *
 * NOTES: 
 * 1) Node has reference to Left and Right Nodes
 * 2) Ordered search where where left <= n < right
 * 3) "Balanced" means not terribly imbalanced"
 */

public class BinaryTreeHeightBalanced {
	private static final boolean DEBUG = true;

	public Node root;

	// 	// A binary tree node
	// 	private static class Node {
	// 		public int data;
	// 		public Node left, right;
	
	// 		public Node(int d) {
	// 			data = d;
	// 			left = right = null;
	// 		}
	// 	}
	
	private void log(String message) {
		if (DEBUG) {
			System.out.println(message);
		}
	}

	/* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
	/* returns maximum of two integers */
	private int max(int a, int b) {
		return (a >= b) ? a : b;
	}
	
	/*
	 * The function Compute the "height" of a tree. 
	 * Height is the number of nodes along the longest path 
	 * from the root node down to the farthest leaf node.
	 */
	private int height(Node node) {
		// Base case tree is empty
		if (node == null) {
			return 0;
		}
		// If tree is not empty then height = 1 + max of left
		// height and right heights */
		log(" height() node id: " + node.data);
		if (node.left != null)
			log("height() node left id: " + node.left.data);
		if (node.right != null)
			log("height() node right id: " + node.right.data);
		int counter = 1 + max(height(node.left), height(node.right));
		log("height() counter: " + counter + " for node: " + node.data);
		return counter;
	}
	
	/*
	 * Returns true if binary tree with root as root is 
	 * height-balanced
	 */
	private boolean isBalanced(Node node) {
		int lh; /* for height of left subtree */
		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (node == null) {
			return true;
		}

		log("isBalaned() node id: " + node.data);
		if (node.left != null)
			log("isBalanced() node left id: " + node.left.data);
		if (node.right != null)
			log("isBalanced() node right id: " + node.right.data);
		
		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		// Recursion happens here
		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			log("isBalanced() left height: " + lh + " right height: " + rh);
			return true;
		}
		
		/* If we reach here then tree is not height-balanced */
		return false;
	}
	
	/**
	 * Main method to execute functions above
	 */
	public static void main(String args[]) {
		BinaryTreeHeightBalanced tree = new BinaryTreeHeightBalanced();
		// Initialize parent root Node
		tree.root = new Node(1);
		// Initialize root left node child
		tree.root.left = new Node(2);
		// Initialize root right node child
		tree.root.right = new Node(3);
		// Initialize root left left node child
		tree.root.left.left = new Node(4);
		// Initialize root left right node child
		tree.root.left.right = new Node(5);
		// Initialize root left left left node child
		//tree.root.left.left.left = new Node(6);
		if (tree.isBalanced(tree.root))
			tree.log("Tree is balanced!");
		else
			tree.log("Tree is not balanced!");
	}
}
