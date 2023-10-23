import java.util.*;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		
		// Create map to count occurance of each number
		HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
		
		for(int i: nums) {
			if(counter.containsKey(i)){
				counter.put(i, counter.get(i)+1);
			}
			else{
				counter.put(i, 1);
			}    
		}

		// DEBUG
		TreeMap<Integer, Integer> sortedMap = new TreeMap<Integer, Integer>(new ValueComparator(counter));
		sortedMap.putAll(counter);
		
		int i=0;
		for(Map.Entry<Integer, Integer> entry: sortedMap.entrySet()){
			result.add(entry.getKey());
			i++;
			if(i==k)
				break;
		}
		return result;
	}

 
	public class ValueComparator implements Comparator<Integer> {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		public ValueComparator(HashMap<Integer, Integer> m){
			map.putAll(m);
		}
		
		public int compare(Integer i1, Integer i2){
			int diff = map.get(i2)-map.get(i1);
			if(diff==0){
				return 1;
			}
			else{
				return diff;
			}
		}
	}
		
	public static void main(String[] args) {
		int[] myArray = {1, 2, 2, 3, 4, 5, 6, 7, 7, 7}; 
		TopKFrequentElements tkfe = new TopKFrequentElements();
		List<Integer> myList = tkfe.topKFrequent(myArray, 2);
		for (Integer myInt : myList) {
			System.out.println("myInt is: " + myInt);
		}
	}
}
	
	
