import java.util.Comparator;

/**
 * @author Francisco Franco
 *
 */

public final class MyComparator implements Comparator<HuffmanNode> {
	@Override
	public int compare(HuffmanNode x, HuffmanNode y) {
		// Min-heap: smallest frequency has highest priority
		return x.frequency - y.frequency; 
	}
}
