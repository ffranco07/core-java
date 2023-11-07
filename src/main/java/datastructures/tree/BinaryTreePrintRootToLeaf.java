//package com.sandbox.datastructures.tree;

/**
 * @author Francisco Franco
 *
 * Print Node values from root to leafs using Depth-First Search (DFS) 
 * using preorder traversal
 * 
 * NOTES: 
 * 1) Each Node has reference to Left and Right Nodes
 * 2) Ordered search where where left <= n < right
 *
 * Name of each traversal is describing when the current node's logic is performed:
 * preorder  -> before children    -> DLR (Data, Left, Right)
 * inorder   -> middle of children -> LDR (Left, Data, Rigth)
 * postorder -> after children     -> LRD (Left, Right, Data)
 *
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
	 * DFS - preorder (Data, Left, Right)
	 * Time Complexity: O(n) where n is the number of nodes
	 * Space Complexity: O(h) where h is the height of the tree
	 * 
	 * @param node
	 * @param path
	 * @param fillCount
	 */
	private void printPathsRecursive(Node root, int[] path, int fillCount) {
		// Base case
		// Terminating recursive condition
		if (root == null) {
			return;
		}
		// Add this root data to path array and 
		// increment fill node count in array
		path[fillCount] = root.data;
		fillCount++;
		
		// Base case
		// Terminating recursive condition at leaf node
		if (root.left == null && root.right == null) {
			printArray(path, fillCount);
		}
		else {
			printPathsRecursive(root.left, path, fillCount);
			printPathsRecursive(root.right, path, fillCount);
		}
	}

	// Invoke recursive function
	public void printPaths(Node root) {
		// path value array
		int path[] = new int[10];
		printPathsRecursive(root, path, 0);
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
