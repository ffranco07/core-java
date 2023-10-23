public class Employee {
	String name;
	int age;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	/* 
	 * Rules for implementing equals() and hashCode():
	 * 
	 * 1) If object1 and object2 are equal according to their equals() 
	 *    method, they must also have the same hash code.
	 * 2) If object1 and object2 have the same hash code (collision), they 
	 *    do NOT have to be equal too (hash code value just points to same 
	 *    bucket for both objects stored as separate entries in same LinkedList 
	 *    within the bucket)
	 *
	 * The hash code of a key is calculated (via hash function) and used to determine where 
	 * to store the object internally within bucket array.  Object comparison for equivalence
	 * is determined from rule item 1) above.  Both of these functions are important to search 
	 * for unique objects within java collections framework.
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee employee = (Employee) obj;
		return (employee.getAge() == this.getAge() && employee.getName() == this.getName());
	}
	
	@Override
	public int hashCode() {
		int result=17;
		result = 31 * result + age;
		result = 31 * result + (name!=null ? name.hashCode() : 0);
		return result;
	}
}
