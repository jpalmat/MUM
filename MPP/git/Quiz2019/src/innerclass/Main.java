 package innerclass;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import quizclasses.Employee;
import quizclasses.EmployeeTestData;
import quizclasses.Pair;
import quizclasses.TraderTransactTestData;
import quizclasses.Transaction;

/** SOLVE THE PROBLEMS HERE BY REPLACING LAMBDA EXPRESSIONS IN YOUR PIPELINE SOLUTIONS 
 *  WITH LOCAL INNER CLASSES
 *
 */
public class Main {
	
	
	public static void main(String[] args) {
		
		//SAMPLE: Use local inner classes to replace lambdas in your pipeline solution to 
		//this sample problem:
		//Print all Employee records for which name has length > 5 and birth year is > 1970
		
		class NameLength implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getName().length() > 5;
			}
		}
		class BirthYear implements Predicate<Employee> {
			public boolean test(Employee e) {
				return e.getYearOfBirth() > 1970;
			}
		}
		System.out.println("Sample Query");
		List<Employee> sampleData = EmployeeTestData.getList();
		
		List<Employee> result = sampleData.stream()
							        .filter(new NameLength())
							        .filter(new BirthYear())
							        .collect(Collectors.toList());
		System.out.println(result);
		
		
				
		prob1();
		prob2();
		prob3();
	}
	

	//Transform your pipeline solution to prob1 in the pipeline package so that
	//every lambda is replaced by an instance of a
	//local inner class of the correct type
	public static void prob1() {
		
		//use this list 
		List<Employee> list = EmployeeTestData.getList();

		Comparator<Employee> empCompa = Comparator.comparing(Employee::getName).thenComparing((e1, e2) -> e2.getSalary()==e1.getSalary()? 0 : e2.getSalary() < e1.getSalary() ? -1 : 1);
		
		List<Pair> list1 = list.stream()
				.filter(new SalaryValidation())
				.sorted(empCompa)
				.map(e1 -> new Pair(e1.getName(), e1.getSalary()))
				.collect(Collectors.toList());
				list1.forEach(n -> System.out.println(n));
		
	}
	
	///Transform your pipeline solution to prob2 so that
	//every lambda is replaced by an instance of a
	//local inner class of the correct type
	public static void prob2() {
		//use this list	
		List<Transaction> list = TraderTransactTestData.getTransactions();
		
		List<Transaction> listTransaction = list.stream()
		.filter(new YearValidation())
		.sorted(Comparator.comparing(Transaction::getValue))
		.collect(Collectors.toList());
		
		listTransaction.forEach(t -> System.out.println(t));
	}
	
	//Transform your pipeline solution to prob3 so that
	//every lambda is replaced by an instance of a
	//local inner class of the correct type
	public static void prob3() {
		//Use this list
		List<Transaction> list = TraderTransactTestData.getTransactions();  
		
	                
	}
}

class SalaryValidation implements Predicate<Employee> {
	public boolean test(Employee e) {
		return e.getSalary()>55000 && e.getSalary()<120000;
	}
}

class YearValidation implements Predicate<Transaction> {
	public boolean test(Transaction e) {
		return e.getYear() == 2011;
	}
}