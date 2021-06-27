package prob11a_b;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		
		System.out.println("******** A");
		System.out.println(emps.stream().filter(em -> em.salary > 100000).filter(em -> em.lastName.charAt(0)>'M')
										.sorted((e1, e2) -> e1.lastName.compareTo(e2.lastName))
										.map(e -> e.firstName.concat(" ").concat(e.lastName)).collect(Collectors.joining(", ")));
		

		System.out.println("******** B");
		System.out.println(LambdaLibrary.EMPLOYEES_COMPANY.apply(emps, 100000, "M"));               
		  

	}
	
	
	

}