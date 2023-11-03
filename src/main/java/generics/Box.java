package com.sandbox.generics;

/**
 * @author Francisco Franco
 *
 * Generic class (Declares class to use Generics)
 *
 */
public class Box<T> {
	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
	// Main method to execute functions above
	public static void main(String[] args) {
		// Invoke a Generic Type
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
    
		integerBox.add(new Integer(10));
		stringBox.add(new String("Hello World"));
		
		System.out.printf("Integer Value :%d\n\n", integerBox.get());
		System.out.printf("String Value :%s\n", stringBox.get());
	}
}
