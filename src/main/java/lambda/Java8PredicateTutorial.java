import java.util.function.Predicate;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Francisco Franco
 *
 * Predicate lambda function passed as a parameter
 * to filter for even numbers
 * 
 */

public class Java8PredicateTutorial {
	public static void main(String[] args) {
		// Since input to predicate function is an integer
		Predicate<Integer> lambdaFunc = x -> (x%2) == 0;
		List<Integer> nums = Arrays.asList(99, 66, 88, 16);

		// DEBUG
		System.out.println("nums: " + nums);
		
		// Java predicate and lambda stream example usage
		List<Integer> evenNums = nums.stream().filter(lambdaFunc).collect(Collectors.toList());
		
		// DEBUG
		System.out.println("evenNums: " + evenNums);
	
	}
}
