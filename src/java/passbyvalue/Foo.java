public class Foo {

	private String attribute;

	public Foo(String attribute) {
		this.attribute = attribute;
	}
	
	public String getAttribute() {
		return attribute;
	}
	
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	@Override
	public String toString() {
		return "Foo [attribute=" + attribute + "]";
	}
}
