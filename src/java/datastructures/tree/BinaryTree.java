package com.sandbox.algorithms;

/**
 * @author Francisco Franco
 * 
 * A binary tree is a tree whose elements
 * have at most 2 children.  For example, 
 * each node has 0 children, 1 child, or 2 children. 
 *
 * This module determines if binary tree 
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
 */

public class BinaryTree {
	public Node root;

	/* Returns maximum of two integers */
	private int max(int a, int b) {
		return (a >= b) ? a : b;
	}

	/*
	 * The function Compute the "height" of a tree. 
	 * Height is the number of nodes along the 
	 * longest path from the root node down to the 
	 * farthest leafnode.
	 */
	private int height(Node node) {
		// Base case tree is empty
		if (node == null) {
			return 0;
		}
		// If tree is not empty then height = 1 + max of left
		// height and right heights */
		int counter = 1 + max(height(node.left), height(node.right));
		System.out.println("counter is: " + counter + " for node: " + node.id);
		return counter;
	}

	/*
	 * Returns true if binary tree 
	 * with root as root is height-balanced
	 */
	private boolean isBalanced(Node node) {
		int lh; /* for height of left subtree */
		int rh; /* for height of right subtree */

		/* If tree root node is empty 
		 * then return true */
		if (node == null) {
			return true;
		}

		System.out.println("node id: " + node.id);
		if (node.left != null)
			System.out.println("node left id: " + node.left.id);
		if (node.right != null)
			System.out.println("node right id: " + node.right.id);
		
		/* Get the height of left and right sub trees */
		lh = height(node.left);
		rh = height(node.right);

		if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			System.out.println("left height: " + lh + " right height: " + rh);
			return true;
		}

		/* If we reach here then tree is not height-balanced */
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		// Initialize parent root Node
		tree.root = new Node(1);
		// Initialize left root node child
		tree.root.left = new Node(2);
		// Initialize right root node child
		tree.root.right = new Node(3);
		// Initialize left left root node child
		tree.root.left.left = new Node(4);
		// Initialize left right root node child
		tree.root.left.right = new Node(5);
		// Initialize left left left root node child
		//tree.root.left.left.left = new Node(6);
		if (tree.isBalanced(tree.root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}
	
	// ===================
	// Inner class
	// ===================

	// A binary tree node
	public static class Node {
		private int id;
		protected Node left, right;

		public Node(int d) {
			id = d;
		}
	}
}
