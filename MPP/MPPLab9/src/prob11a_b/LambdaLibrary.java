package prob11a_b;

import java.util.List;
import java.util.stream.Collectors;

public class LambdaLibrary {
	
	public static final TriFunction<List<Employee>, Integer, String, String> EMPLOYEES_COMPANY = (list, salary, letter) -> list.stream()
			.filter(em -> em.salary > salary)
			.filter(em -> em.lastName.charAt(0)>letter.charAt(0))
			.sorted((e1, e2) -> e1.lastName.compareTo(e2.lastName))
			.map(e -> e.firstName.concat(" ").concat(e.lastName))
			.collect(Collectors.joining(", "));



//	public static final BiFunction<List<Customer>, String, List<String>> NAMES_IN_CITY = (list, searchStr) ->
//	list.stream()
//	.filter(cust -> cust.getCity().startsWith(searchStr)) 
//	.map(cust -> cust.getName()) 
//	.sorted() 
//	.collect(Collectors.toList());
}
