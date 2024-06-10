import java.util.PriorityQueue; 
import java.util.Scanner;

/**
 * @author Francisco Franco
 * 
 * A Huffman tree is a type of binary tree used in data compression algorithms, 
 * notably Huffman coding, which is a lossless data compression algorithm. 
 * 
 * The priority queue is a crucial data structure used during the construction 
 * of the Huffman Tree to ensure that nodes are combined in the correct order 
 * based on their frequencies.
 *
 * The Huffman Tree itself is a visual and conceptual representation of the 
 * optimal prefix-free encoding scheme for the given set of characters and 
 * their frequencies.
 * 
 * Here's a step-by-step explanation of how to create a simple Huffman tree:
 * ==================
 * Steps to Create a Huffman Tree:
 * ==================
 * Frequency Calculation:
 * Determine the frequency of each character in the input data 
 * (e.g., a string of text).
 * ==================
 * Create Leaf Nodes:
 * Create a leaf node for each character, storing the character and 
 * its frequency.
 * ==================
 * Build the Tree:
 * Repeat the following steps until there is only one node left in the 
 * priority queue (or list):
 * ==================
 * Select Nodes:
 * Select two nodes with the lowest frequencies. These nodes will become 
 * the children of a new internal node.
 * ==================
 * Create Internal Node:
 * Create a new internal node with a frequency equal to the sum of the two 
 * selected nodes' frequencies.
 * ==================
 * Update Queue:
 * Add the new internal node back into the priority queue.
 * ==================
 * Assign Codes:
 * Traverse the tree from the root to each leaf node. Assign a binary code 
 * to each character based on the path taken: typically, a left edge 
 * represents '0' and a right edge represents '1'.
 * ==================
 * Time Complexity:  O(nlogn) where n is the number of unique characters.
 * Space Complexity: O(n)
 * 
 */  

public final class HuffmanTree { 
  
	// Recursive function to print the path / huffman-code through the tree traversal. 
	// Here s is the huffman code generated. 
	public static void printCode(HuffmanNode root, String s) { 
		// Bbase case; if the left and right are null 
		// then its a leaf node and we print 
		// the code s generated by traversing the tree. 
		if (root.left == null && root.right == null && Character.isLetter(root.character)) { 
			// c is the character in the node 
			System.out.println("char:" + root.character + " freq:" + root.frequency + " code:" + s); 
			return; 
		} 
		
		// If we go to left then append "0" to the path code. 
		// If we go to the right append "1" to the path code. 
		// Recursive calls for left and right sub-tree of the generated tree. 
		printCode(root.left, s + "0"); 
		printCode(root.right, s + "1"); 
	} 
  
	// Driver code 
	public static void main(String[] args) { 
		Scanner s = new Scanner(System.in); 
		
		// Number of characters 
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
		int[] charFreq = { 5, 9, 12, 13, 16, 45 }; 
		
		// Create a priority queue q as a min-priority queue (min-heap) 
		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(charArray.length, new MyComparator()); 
		
		for (int i = 0; i < charArray.length; i++) { 
			// Create a Huffman node object 
			// and add it to the priority queue q 
			HuffmanNode hn = new HuffmanNode(charArray[i], charFreq[i]); 
			
			// Add huffman node hn to the queue 
			q.add(hn); 
		} 
		
		// Create a root node 
		HuffmanNode root = null; 
		
		// Here we will extract the two minimum value 
		// from the heap each time until 
		// its size reduces to 1, extract until 
		// all the nodes are extracted 
		while (q.size() > 1) { 
			
			// First min extract
			HuffmanNode x = q.peek(); 
			q.poll(); 
			
			// Second min extract 
			HuffmanNode y = q.peek(); 
			q.poll(); 
			
			// Sum the frequency of the two nodes 
			// and assigning values to the new node f 
			HuffmanNode f = new HuffmanNode('-', x.frequency + y.frequency); 
			
			// First extracted node as left child 
			f.left = x; 
			
			// Second extracted node as the right child 
			f.right = y; 
			
			// Set root to the f node 
			root = f; 
			
			// Add f node to the priority-queue 
			q.add(f); 
		}
		
		// DEBUG
		//while (!q.isEmpty()) {
		//HuffmanNode node = q.poll(); // Removes the element with the highest priority (smallest frequency)
		//System.out.println("Character: " + node.character + ", Frequency: " + node.frequency);
		//}
		
		// Print the codes by recursively traversing the tree 
		printCode(root, ""); 
	} 
} 
