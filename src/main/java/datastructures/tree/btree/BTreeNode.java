/**
 * @author Francisco Franco
 *
 * BTreeNode class used in b-tree data structure
 */
public class BTreeNode {
	// An array of keys
	int[] keys;
	
	// Minimum degree/order
	// Defines the range for number of keys
	int t;
	
	// Array of child nodes pointers
	BTreeNode[] childNodes; 
	
	// Current number of keys
	int n;
	
	// True when node is leaf, false otherwise
	boolean isLeaf;
	
	// =================
	// Constructor
	// =================
	
	public BTreeNode(int t, boolean isLeaf) {
		this.t = t;
		this.isLeaf = isLeaf;
		// All nodes (including root) may contain at most (2 * t - 1) keys.
		this.keys = new int[2 * t - 1];
		this.childNodes = new BTreeNode[2 * t];
		this.n = 0;
	}
	
	// =================
	// Insertion 
	// =================
	
	/**
	 * 1) Initialize x as root. 
	 * 2) While x is not leaf, do following:
	 *   a) Find the child of x that is going to be traversed next. 
	 *      Let the child be y. 
	 *   b) If y is not full, change x to point to y. 
	 *   c) If y is full, split it and change x to point to one of 
	 *      the two parts of y. If k is smaller than mid key in y, 
	 *      then set x as the first part of y, else, second part of y. 
	 *      When we split y, we move a key from y to its parent x. 
	 * 3) The loop in step 2 stops when x is leaf. x must have space 
	 *    for 1 extra key as we have been splitting all nodes in advance. 
	 *    So simply insert k to x.
	 */
	public void insertNonFull(int k) {
	int i = n - 1;
		if (isLeaf) {
			while (i >= 0 && keys[i] > k) {
				keys[i + 1] = keys[i];
				i--;
			}
			keys[i + 1] = k;
			n++;
		} 
		else {
			while (i >= 0 && keys[i] > k) {
				i--;
			}
			if (childNodes[i + 1].n == 2 * t - 1) {
				splitChild(i + 1, childNodes[i + 1]);
				if (keys[i + 1] < k) {
					i++;
				}
			}
			childNodes[i + 1].insertNonFull(k);
		}
	}

	// Method splitChild moves a key up.
	// Splitting occurs when a node exceeds its capacity, 
	// pushing the middle value up and dividing the remaining 
	// values into child nodes.
	// This is the reason B-Trees grow up, unlike BSTs which grow down. 
	public void splitChild(int i, BTreeNode y) {
		BTreeNode z = new BTreeNode(y.t, y.isLeaf);
		z.n = t - 1;
		for (int j = 0; j < t - 1; j++) {
			z.keys[j] = y.keys[j + t];
		}
		if (!y.isLeaf) {
			for (int j = 0; j < t; j++) {
				z.childNodes[j] = y.childNodes[j + t];
			}
		}
		y.n = t - 1;
		for (int j = n; j > i; j--) {
			childNodes[j + 1] = childNodes[j];
		}
		childNodes[i + 1] = z;
		for (int j = n - 1; j >= i; j--) {
			keys[j + 1] = keys[j];
		}
		keys[i] = y.keys[t - 1];
		n++;
	}
	
	// Method to traverse all nodes in a 
	// subtree rooted with this node
	public void traverse() {
		// There are n keys and n+1 children, traverse
		// through n keys and first n children
		int i = 0;
		for (i = 0; i < this.n; i++) {
			// If this is not leaf, then before printing
			// key[i], traverse the subtree rooted with
			// child childNodes[i].
			if (this.isLeaf == false) {
				childNodes[i].traverse();
			}
			System.out.print(keys[i] + " ");
		}
		
		// Print the subtree rooted with last child
		if (isLeaf == false) {
			childNodes[i].traverse();
		}
	}
	
	// Method to search a key in the 
	// subtree rooted with this node.
	// Returns NULL if k is not present.
	public BTreeNode search(int k) { 
		// Find the first key greater than or equal to k
		int i = 0;
		while (i < n && k > keys[i])
			i++;
		// If the found key is equal to k, return this node
		if (keys[i] == k)
			return this;
		
		// If the key is not found here and this is a leaf
		// node return NULL
		if (isLeaf == true)
			return null;
		
		// Go to the appropriate child
		return childNodes[i].search(k);
	}
}
