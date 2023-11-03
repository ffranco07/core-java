import java.util.*;

public class ConcurrentModificationExceptionTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");

		System.out.println("Orig: " + list);
		
		// SUCCESS with traditional for loop
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("e")) {
				list.remove(list.get(i));
			}
		}

		System.out.println("list: " + list);
		
		// SUCCESS using Iterator interface
		Iterator it = list.iterator();
		while (it.hasNext()) {
			if (it.next().equals("b")) {
				it.remove();
			}
		}
		
		System.out.println("list: " + list);
		
		// FAILURE with enhanced for loop
		for (String elem : list) {
			if (elem.equals("d")) {
				list.remove(elem);
			}
		}

		System.out.println("list: " + list);
	}
}
