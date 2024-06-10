/**
 * @author Francisco Franco
 *
 * Node class used in the Huffman tree data structure
 */
 
public final class HuffmanNode { 
	public int frequency; 
	public char character;
  
	public HuffmanNode left; 
	public HuffmanNode right;

	// =================
	// Constructor
	// =================
	
	public HuffmanNode(char character, int frequency) {
		this.character = character;
		this.frequency = frequency;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public String toString() {
		String objStr = "HuffmanNode [character=" + character
			+ ", frequency=" + frequency
			+ "]";
		return objStr;
	}
} 

