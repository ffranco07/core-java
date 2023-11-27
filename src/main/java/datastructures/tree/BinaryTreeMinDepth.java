//package com.sandbox.datastructures.tree;

import java.util.Queue;
import java.util.LinkedList;

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

public class BinaryTreeMinDepth {
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
	
	/**
	 * Find min depth of tree recursively
	 * Time Complexity: O(n), as it traverses the tree only once 
	 * Space Complexity: O(h), where h is the height of the tree
	 * This space is due to the recursive call stack
	 *
	 * @param root
	 * @return
	 */
	public int minDepthRecursive(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return 1 + minDepthRecursive(root.right);
		}
		if (root.right == null) {
			return 1 + minDepthRecursive(root.left);
		}
		
		int left = minDepthRecursive(root.left);
		int right = minDepthRecursive(root.right);
		return Math.min(left, right) + 1;
	}
	
	/** 
	 * Find min depth of tree iterative
	 * Time Complexity: O(n) where n is the number of nodes
	 * Space Complexity: O(n), as we need to store the elements 
	 * in a queue for level order traversal
	 * 
	 * @param root
	 * @return
	 */
	// Iterative method to find
	// minimum depth of Binary Tree 
	public int minDepthIterative(Node root) { 
    // Corner Case 
    if (root == null) 
			return 0; 
		
    // Create an empty queue for level order traversal 
    Queue<Pair> queue = new LinkedList<>(); 
		
    // Enqueue Root and initialize depth as 1  
    queue.add(new Pair(root, 1)); 
		
    // Do level order traversal 
    while (queue.isEmpty() == false) { 
			Pair pair = queue.poll();
			Node node = pair.node; 
			int depth = pair.depth;
			
			// If this is the first leaf node seen so far 
			// Then return its depth as answer 
			if (node.left == null && node.right == null) 
				return depth;
			else {
				// If left subtree is not null, add it to queue 
				if (node.left != null) { 
					queue.add(new Pair(node.left, depth + 1));
				}
				  // If right subtree is not null, add it to queue 
				if (node.right != null) { 
					queue.add(new Pair(node.right, depth + 1));
				}
			}
		} 
    return 0; 
	} 
	
	// Driver Code
	public static void main(String[] args) {
		BinaryTreeMinDepth tree = new BinaryTreeMinDepth();
		
		// Inserting nodes
		tree.root = tree.insert(tree.root, 2);
		tree.insert(tree.root, 1);
		tree.insert(tree.root, 3);
		//tree.insert(tree.root, null);
		tree.insert(tree.root, 4);
		//tree.insert(tree.root, null);
		tree.insert(tree.root, 5);
		//tree.insert(tree.root, null);
		tree.insert(tree.root, 6);

		// Print BST via BinaryTreePrintRootToLeaf
		BinaryTreePrintRootToLeaf btPrint = new BinaryTreePrintRootToLeaf();
		btPrint.printPaths(tree.root);
		
		// Find min depth recursively
		int minDepth = tree.minDepthRecursive(tree.root);
		System.out.println("Recursive min depth: " + minDepth);
		
		// Find min depth iterative
	  minDepth = tree.minDepthIterative(tree.root);
		System.out.println("Iterative min depth: " + minDepth);
	}
}
