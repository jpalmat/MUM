package exe6;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Evaluator {

	public static void main(String[] args) {
		Employee employee1 = new Employee("ji");
		Employee employee2 = new Employee("ji");
		
		//(Employee e) -> e.getName()
//		System.out.println("\n (Employee e) -> e.getName()");
//		Function<Employee, String> getName = (e) -> e.getName();  
//		Function<Employee, String> getName1 =  Employee::getName;  
//		System.out.println(getName.apply(employee1));
//		System.out.println(getName1.apply(employee1));
		
		//(String s1,String s2) -> s1.compareTo(s2)
		System.out.println("\n (String s1,String s2) -> s1.compareTo(s2)");
		Comparator<String> compa = (s1, s2) -> s1.compareTo(s2);/////CORRECT
		BiFunction<String, String, Integer> compa1 = String::compareTo;
//		System.out.println(compa.apply("a", "a"));
		System.out.println(compa1.apply("a", "a"));
		
		//(Integer x,Integer y) -> Math.pow(x,y)
//		System.out.println("\n (Integer x,Integer y) -> Math.pow(x,y)");
//		BiFunction<Integer, Integer, Double> pow = (x, y) -> Math.pow(x.doubleValue(), y.doubleValue());
//		BiFunction<Integer, Integer, Double> pow1 =  Math::pow;
//		System.out.println(pow.apply(2, 3));
//		System.out.println(pow1.apply(2, 3));
//		
//		
//		//(Apple a) -> a.getWeight()
//		System.out.println("\n ((Apple a) -> a.getWeight()");
//		Apple apple = new Apple(2.0);
//		Function<Apple, Double> getapple = a -> a.getWeight();
//		Function<Apple, Double> getapple1 = Apple::getWeight;
//		System.out.println(getapple.apply(apple));
//		System.out.println(getapple1.apply(apple));
//		
//		//(String x) -> Integer.parseInt(x);
//		System.out.println("\n (String x) -> Integer.parseInt(x);");
//		Function<String, Integer> parse = x -> Integer.parseInt(x);
//		Function<String, Integer> parse1 = Integer::parseInt;
//		System.out.println(1 + parse.apply("5"));
//		System.out.println(1 + parse1.apply("5"));
//		
//		System.out.println("\n (Employee e1, Employee e2) -> comp.compare(e1,e2)");
//		EmployeeNameComparator comp = new EmployeeNameComparator();
//		//(Employee e1, Employee e2) -> comp.compare(e1,e2)
//		BiFunction<Employee, Employee, Integer> comparator = (e1, e2) -> comp.compare(e1,e2);
//		BiFunction<Employee, Employee, Integer> comparator1 = comp::compare;
//		System.out.println(comparator.apply(employee1, employee2));
//		System.out.println(comparator1.apply(employee1, employee2));
		
//		Comparator<Employee> comp1 = (e1, e2) -> comp.compare(e1, e2); //CORRECT
		
		
	}

}

class EmployeeNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}

class Employee {
	public Employee(String name) {
		this.name = name;
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Apple {
	private Double weight;

	public Apple(Double weight) {
		this.weight = weight;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
}