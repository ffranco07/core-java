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
 * Given the root of a binary tree and an integer targetSum, 
 * return true if there exists a path from the root to a leaf 
 * such that the sum of the nodes on the path is equal to targetSum, 
 * and return false otherwise.
 * 
 */ 

public class BinaryTreePathSum {
	Node root = null;
	int target = 0;
	
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
	 * Time Complexity: O(n) where n is the number of nodes
	 * Space Complexity: O(n)
	 * 
	 * @param node
 	 * @param currSum
	 * @return
	 */
	public boolean dfs(Node node, int currSum) {
		if (node == null) {
			return false;
		}
		
		if (node.left == null && node.right == null) {
			return (currSum + node.data) == target;
		}
		
		currSum += node.data;
		boolean left = dfs(node.left, currSum);
		boolean right = dfs(node.right, currSum);
		return left || right;
	}
	
	/** 
	 * Find path sum
	 * 
	 * @param root
 	 * @param targetSum
	 * @return
	 */
	public boolean hasPathSumRecursive(Node root, int targetSum) {
		target = targetSum;
		return dfs(root, 0);
	}
	
	/** 
	 * Time Complexity: O(n) where n is the number of nodes
	 * Space Complexity: O(n)
	 * 
	 * @param root
 	 * @param targetSum
	 * @return
	 */
	public boolean hasPathSumIterative(Node root, int targetSum) {
		if (root == null) {
			return false;
		}
		
		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, 0, 0));
		
		while (!stack.empty()) {
			Pair pair = stack.pop();
			Node node = pair.node;
			int currSum = pair.currSum;
			
			if (node.left == null && node.right == null) {
				if ((currSum + node.data) == targetSum) {
					return true;
				}
			}
			
			currSum += node.data;
			if (node.left != null) {
				stack.push(new Pair(node.left, 0, currSum));
			}
			if (node.right != null) {
				stack.push(new Pair(node.right, 0, currSum));
			}
		}
		
		return false;
	}
	
	// Driver Code
	public static void main(String[] args) {
		BinaryTreePathSum tree = new BinaryTreePathSum();
		
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

		int targetSum = 28;
		System.out.println("targetSum: " + targetSum);
		
		// Check if has path sum via recursive method
		boolean hasPathSum = tree.hasPathSumRecursive(tree.root, targetSum);
		System.out.println("Recursive hasPathSum: " + hasPathSum);
		
		// Check if has path sum via iterative method
		hasPathSum = tree.hasPathSumIterative(tree.root, targetSum);
		System.out.println("Iterative hasPathSum: " + hasPathSum);
	}
}
