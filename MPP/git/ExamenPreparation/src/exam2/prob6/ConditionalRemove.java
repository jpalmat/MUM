package exam2.prob6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import exam2.prob5.Employee;
public class ConditionalRemove {
	static class StrLengthCondition implements Predicate<String> {
		public boolean test(String s) {
			return s.length() == 5;
		}
	}
	static class salary implements Predicate<Employee>{

		@Override
		public boolean test(Employee t) {
			// TODO Auto-generated method stub
			return t.getSalary()<60000;
		}
		
	}
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("Hello");add("Goodbye"); 
				
			}
		};
		ArrayList<Employee> list3 = new ArrayList<Employee>() {
			{
				add(new Employee("Bob", 55000, LocalDate.of(2014,  1, 1)));add(new Employee("Bob", 100000, LocalDate.of(2015,  1, 1)));
			}
		};
//	System.out.println(conditionalRemove(list3,new salary()));
		System.out.println(conditionalRemove(list3, (Employee e) -> e.getSalary()<60000 ));
	System.out.println(conditionalRemove(list, (String x) -> x.length()==5));
	}
	public static<T> List<T> conditionalRemove(ArrayList<T> list, Predicate<T> P) {
		
		for(T s : list) {
			if(P.test(s)) {
				list.remove(s);
			}
		}
		return list;
	}
//	
}
