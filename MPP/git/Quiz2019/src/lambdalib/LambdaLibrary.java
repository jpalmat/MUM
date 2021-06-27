package lambdalib;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.Pair;
import quizclasses.Transaction;


public class LambdaLibrary {
//	public final static String IMPLEMENT = "implement!";
	
	//sample query
	public final static TriFunction<List<Employee>, Integer, Integer, List<Employee>> SAMPLE
	   = (list, namelength, year) -> list.stream()
	                                     .filter(e -> e.getName().length() > namelength)
	                                     .filter(e -> e.getYearOfBirth() > year)
	                                     .collect(Collectors.toList());
	   
	   public final static TriFunction<List<Employee>, Integer, Integer, List<Pair>> IMPLEMENT
	   = (list, minSalary, maxSalary) -> list.stream()
		.filter(e -> e.getSalary() > minSalary)
		.filter(e -> e.getSalary() < maxSalary)
		.sorted(Comparator.comparing(Employee::getName).thenComparing((e1, e2) -> e2.getSalary()==e1.getSalary()? 0 : e2.getSalary() < e1.getSalary() ? -1 : 1))
		.map(e1 -> new Pair(e1.getName(), e1.getSalary()))
		.collect(Collectors.toList());
	   
	   static Comparator<Transaction> con = Comparator.comparing(Transaction::getValue, (t1, t2) -> t1 == t2 ? 0 : t1 < t2 ? -1 : 1);
	   public final static BiFunction<List<Transaction>, Integer, List<Transaction>> GETBYYEAR
	   = (list, year) -> list.stream()
		.filter(t -> t.getYear()==year)
		.sorted(con)
		.collect(Collectors.toList());
	   
	   
}
