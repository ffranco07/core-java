public class Main {

	public static void main(String[] args) {
		Foo f = new Foo("f");
		changeReference(f); // It won't change the reference!
		System.out.println(f.toString());
		modifyReference(f); // It will modify the object that the reference variable "f" refers to!
		System.out.println(f.toString());
	}
	
	public static void changeReference(Foo a) {
		Foo b = new Foo("b");
		// Only address/pointer of a changed to address/pointer of b
		a = b;
		System.out.println("changeReference(..) DONE!");
	}
	
	public static void modifyReference(Foo c) {
		// Value of c changed here
		c.setAttribute("c");
		System.out.println("modifyReference(..) DONE!");
	}
}
