import java.util.HashSet;

// Hashing retrieval is a two-step process.
//
// 1) Find the right bucket (using hashCode())
// 2) Search the bucket for the right element (using equals())
//
// 1) If object1 and object2 are equal according to their equals() 
//    method, they must also have the same hash code.
// 2) If object1 and object2 have the same hash code, they do NOT have to be equal too.

public class ClientTest {
	public static void main(String[] args) {
		Employee employee = new Employee("rajeev", 24);
		Employee employee1 = new Employee("rajeev", 25);
		Employee employee2 = new Employee("rajeev", 24);
		
		HashSet<Employee> employees = new HashSet<Employee>();
		employees.add(employee);
		System.out.println(employees.contains(employee2));
		System.out.println("employee.hashCode(): " + employee.hashCode() + "\n" + "employee1.hashCode(): " + employee1.hashCode() + "\n" + "employee2.hashCode(): " + employee2.hashCode());
	}
}
