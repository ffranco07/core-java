//package com.sandbox.datastructures.tree;

import java.util.Stack;

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
 * Given the root of a binary tree, find the length of the longest 
 * path from the root to a leaf.
 *
 */ 

public class BinaryTreeMaxDepth {
	Node root = null;
	
	// 	// Inner class
	// 	public class Pair {
	//     Node node;
	//     int depth;
	//     Pair(Node node, int depth) {
	// 			this.node = node;
	// 			this.depth = depth;
	//     }
	// 	}
	
	// Insert node data in tree
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
	
	// Find max depth of tree recursively
	public int maxDepthRecursive(Node root) {
		if (root == null) {
			return 0;
		}
		
		int left = maxDepthRecursive(root.left);
		int right = maxDepthRecursive(root.right);
		return Math.max(left, right) + 1;
	}

	/** 
	 * Find max depth of tree iterative
	 * Time Complexity: O(n) where n is the number of nodes
	 * Space Complexity: O(h) where h is the height of the tree
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepthIterative(Node root) {
		if (root == null) {
			return 0;
		}
		
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, 1, 0));
		int ans = 0;
		
		while (!stack.empty()) {
			Pair pair = stack.pop();
			Node node = pair.node;
			int depth = pair.depth;
			
			ans = Math.max(ans, depth);
			if (node.left != null) {
				stack.push(new Pair(node.left, depth + 1, 0));
			}
			if (node.right != null) {
				stack.push(new Pair(node.right, depth + 1, 0));
			}
		}
		
		return ans;
	}
	
	// Driver Code
	public static void main(String[] args) {
		BinaryTreeMaxDepth tree = new BinaryTreeMaxDepth();
		
		// Inserting nodes
		tree.root = tree.insert(tree.root, 4);
		tree.insert(tree.root, 2);
		tree.insert(tree.root, 3);
		tree.insert(tree.root, 1);
		tree.insert(tree.root, 7);
		tree.insert(tree.root, 6);
		tree.insert(tree.root, 8);
		tree.insert(tree.root, 9);

		// Print BST via BinaryTreePrintRootToLeaf
		BinaryTreePrintRootToLeaf btPrint = new BinaryTreePrintRootToLeaf();
		btPrint.printPaths(tree.root);
		
		// Find max depth recursively
		int maxDepth = tree.maxDepthRecursive(tree.root);
		System.out.println("Recursive max depth: " + maxDepth);
		
		// Find max depth iterative
		maxDepth = tree.maxDepthIterative(tree.root);
		System.out.println("Iterative max depth: " + maxDepth);
	}
}
