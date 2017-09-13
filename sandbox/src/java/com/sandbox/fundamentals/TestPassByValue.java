
public class TestPassByValue {
	
	public static void foo(Dog d) {
		// Change aDog pointer value to Rover
		d.setName("Rover");
		
		// d is a new pointer here at address 74
		// Since Java does not "pass by reference" 
		// but rather "pass by value of the reference 
		// to the object" or "value of the memory address"
		// aDog variable/pointer is not affected here
		d = new Dog("Fifi");
		d.getName().equals("Fifi"); // true
	}
	
	public static void main( String[] args){
		// aDog is a new pointer here at address 42
		Dog aDog = new Dog("Max");
		// Pass aDog pointer object to foo
		foo(aDog);
		if (aDog.getName().equals("Max")) { // false since value changed from reference to object aDog in foo method above
			System.out.println( "Java passes by value." );
		}
		// Java does not pass by reference (or pointer) to 
		// methods but rather by value
		// In Java, you can not change where the pointer
		// points to
		else if (aDog.getName().equals("Fifi")) {
			System.out.println( "Java passes by reference." );
		}
		else if (aDog.getName().equals("Rover")) {
			System.out.println("Java value changed");
		}
	}

	public static class Dog {
		String name = null;
		
		public Dog(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}

