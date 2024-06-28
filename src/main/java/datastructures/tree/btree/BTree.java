/**
 * @author Francisco Franco
 *
 * A B-Tree implementation with following properties:
 *
 * Balanced Tree:
 * A B-Tree is a balanced tree, meaning that the path from the root 
 * to any leaf is roughly the same length, ensuring efficient operations.
 *
 * Degree/Order of the Tree:
 * The order m of the B-Tree defines the maximum number of children each 
 * node can have.
 *
 * Node Capacity:
 * Each node (except root) must contain between m/2 and m children 
 * if it is an internal node, where m is the order of the tree.
 * The root node must have at least two children if it is not a leaf node.
 * The node capacity determines how many children and keys each node can 
 * have, ensuring the tree stays balanced.
 * 
 * Split Operation: 
 * Ensures that nodes do not exceed their maximum capacity by redistributing 
 * keys and adjusting the tree structure.
 *
 * The B-Tree is designed to maintain balanced height and efficient operations 
 * for large datasets, making it a suitable choice for databases and file systems 
 * where logarithmic time complexity for searches, insertions, and deletions 
 * is desirable.
 * 
 * Search, Insertion, Deletion:
 * Time Complexity: O(log n)
 * Space Complexity: O(n)
 * 
 * Traversal:
 * Time Complexity: O(n)
 *
 */

public class BTree {
	// Pointer to root node
	public BTreeNode root;
	
	// Minimum Degree/Order of the tree
	// Max number of children that any node 
	// in the tree can have.
	public int t;
	
	// =================
	// Constructor
	// =================

	public BTree(int t){
		// Initializes tree as empty
		this.root = null;
		this.t = t;
	}

	// Method to insert a new key into tree
	public void insert(int k) {
		if (root == null) {
			root = new BTreeNode(t, true);
			root.keys[0] = k;
			root.n = 1;
		} 
		else {
			if (root.n == 2 * t - 1) {
				BTreeNode s = new BTreeNode(t, false);
				s.childNodes[0] = root;
				s.splitChild(0, root);
				int i = 0;
				if (s.keys[0] < k) {
					i++;
				}
				s.childNodes[i].insertNonFull(k);
				root = s;
			} 
			else {
				root.insertNonFull(k);
			}
		}
	}
	
	// Method to traverse the tree
	public void traverse() {
		if (this.root != null)
			this.root.traverse();
		System.out.println();
	}
	
	// Method to search a key in this tree
	public BTreeNode search(int k) {
		if (this.root == null)
			return null;
		else
			return this.root.search(k);
	}

	// Driver Code
	public static void main(String[] args) {
		// Initialize b-tree with degree of 3
		BTree tree = new BTree(3);
		
		// Inserting nodes
		tree.insert(10);
		tree.insert(20);
		tree.insert(5);
		tree.insert(6);
		tree.insert(12);
		tree.insert(30);
		tree.insert(7);
		tree.insert(17);
		
		// DEBUG
		System.out.print("Traversal of the constructed tree is ");
		tree.traverse();
		
		// Search for this data key
		int key = 6;
		if (tree.search(key) != null) {
			// DEBUG
			System.out.println("key: " + key + " | Present");
		} 
		else {
			// DEBUG
			System.out.println("key: " + key + " | Not Present");
		}
		
		// Search for this data key
		key = 15;
		if (tree.search(key) != null) {
			// DEBUG
			System.out.println("key: " + key + " | Present");
		}
		else {
			// DEBUG
			System.out.println("key: " + key + " | Not Present");
		}
	}
}
