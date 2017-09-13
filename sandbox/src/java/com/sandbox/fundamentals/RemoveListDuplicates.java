import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;

public class RemoveListDuplicates {

	private Collection<String> removeDuplicates(List<String> dupList) {
		return new HashSet<String>(dupList);
	}

	public static void main(String[] args) {
		RemoveListDuplicates rld = new RemoveListDuplicates();
		List<String> dupList = new ArrayList<String>();
		dupList.add("a");
		dupList.add("b");
		dupList.add("c");
		dupList.add("b");
		Collection<String> noDupList = rld.removeDuplicates(dupList);
		for (String elem : noDupList) {
			System.out.println("elem is: " + elem);
		}
	}
}
