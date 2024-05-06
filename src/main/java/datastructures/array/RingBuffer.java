/**
 * @author Francisco Franco
 *
 * RingBuffer class is an array that is 
 * used as a queue and can "wrap around"
 * both read and write positions
 */

public class RingBuffer {
	private int capacity = 0;
	private int writePosition = 0;
	private int fillCount = 0;
	private Object[] elemArray;
	
	public RingBuffer(int capacity) {
		this.capacity = capacity;
		this.elemArray = new Object[capacity];
	}
	
	public boolean put(Object element) {
		if (fillCount < capacity) {
			if (writePosition >= capacity) {
				writePosition = 0;
			}
			elemArray[writePosition] = element;
			writePosition++;
			fillCount++;
			return true;
		}
		return false;
	}

	public Object take() {
		if (fillCount == 0) {
			return null;
		}
		// Calculate read position below
		int nextSlot = writePosition - fillCount;
		if (nextSlot < 0) {
			nextSlot += capacity;
		}
		Object element = elemArray[nextSlot];
		fillCount--;
		return element;
	}

	public static void main(String[] args) {
		System.out.println("NEED TO IMPLEMENT");
	}
}
