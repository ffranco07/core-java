import java.util.function.Function;
import java.util.function.Consumer;

public class Java8Tester {
	public static void main(String args[]){
		Java8Tester tester = new Java8Tester();

		Function<String, String> function = (String s1) -> s1 + "  Franco!";
		System.out.println(function.apply("Howdy"));

		Consumer<String> consumer = (String s) -> System.out.println(s);
		consumer.accept("Hello Pancho!");
		
		// my boolean interface
		BooleanOperation oper = n -> n % 2 == 0;
		boolean myBoolean = oper.execute(4);
		System.out.println("myBoolean is: " + myBoolean);

		//with type declaration
		MathOperation addition = (int a, int b) -> a + b;
		
		//with out type declaration
		MathOperation subtraction = (a, b) -> a - b;
		
		//with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> { return a * b; };
		
		//without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		int myAdd = addition.operation(2, 2);
		System.out.println("myAdd is: " + myAdd);
		
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));
		
		//without parenthesis
		GreetingService greetService1 = message ->
      System.out.println("Hello " + message);
		
		//with parenthesis
		GreetingService greetService2 = (message) ->
      System.out.println("Hello " + message);
		
		greetService1.sayMessage("Franco");
		greetService2.sayMessage("Chingon");
	}

	public interface BooleanOperation {
		boolean execute (int n);
	}
	
	public interface MathOperation {
		int operation(int a, int b);
	}
	
	public interface GreetingService {
		void sayMessage(String message);
	}
	
	private int operate(int a, int b, MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}
}
