/*
 *
 * For primitive arguments (int, long, etc.), the pass by value 
 * is the actual value of the primitive
 * For objects, the pass by value is the value of the reference 
 * to the object. A copy of address/pointer passed as method parameter 
 * object.
 */

public class Main {

	public static void main(String[] args) {
		// f is reference to object Foo with attribute g
		Foo f = new Foo("g");
		changeReference(f); // It won't change the reference "f" since "a" address/pointer changed to "b" in changeReference method
		System.out.println(f.toString());
		modifyReference(f); // It will modify the object that the reference variable "f" refers to since "c" address/pointer not changed in modifyReference method
		System.out.println(f.toString());
	}
	
	// Copy of address/pointer of "f" passed to changeReference method
	public static void changeReference(Foo a) {
		Foo b = new Foo("b");
		// Only address/pointer of "a" changed to address/pointer of "b"
		// Address/pointer of "a" no longer pointing to "f"
		a = b;
		System.out.println("changeReference(..) DONE!");
	}
	
	public static void modifyReference(Foo c) {
		// Value of c changed here
		c.setAttribute("c");
		System.out.println("modifyReference(..) DONE!");
	}
}
