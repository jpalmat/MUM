package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Employee employee1 = new Employee("ji");
		Employee employee2 = new Employee("ji");
		
		//(Employee e) -> e.getName()
//		Function<Employee, String> getName = (e) -> e.getName();  
//		System.out.println(getName.apply(employee1));
		
//		BiConsumer<Employee, String> setN = (e, x) -> e.setName(x);
//		System.out.println(employee1.getName());
//		setN.accept(employee1, "Jimmy");
//		System.out.println(employee1.getName());
		
		//(String s1,String s2) -> s1.compareTo(s2)
//		BiFunction<String, String, Integer> compa = (s1, s2) -> s1.compareTo(s2);
//		System.out.println(compa.apply("a", "a"));
//		Comparator<String> compa2 = (s1, s2) -> s1.compareTo(s2);
//		System.out.println(compa2.compare("a", "a"));
//		
//		//(Integer x,Integer y) -> Math.pow(x,y)
//		BiFunction<Integer, Integer, Double> pow = (x, y) -> Math.pow(x.doubleValue(), y.doubleValue());
//		System.out.println(pow.apply(2, 3));
//		
//		//(Apple a) -> a.getWeight()
//		Apple apple = new Apple(2.0);
//		Function<Apple, Double> getapple = a -> a.getWeight();
//		System.out.println(getapple.apply(apple));
//		
//		//(String x) -> Integer.parseInt(x);
//		Function<String, Integer> parse = x -> Integer.parseInt(x);
//		System.out.println(1 + parse.apply("5"));
//		
//		EmployeeNameComparator comp = new EmployeeNameComparator();
//		//(Employee e1, Employee e2) -> comp.compare(e1,e2)
//		BiFunction<Employee, Employee, Integer> comparator = (e1, e2) -> comp.compare(e1,e2);
//		
//		System.out.println(comparator.apply(employee1, employee2));
		
		Supplier<Stream<String>> a = ()-> Arrays.asList(new String[] {""}).stream();
		
		List<Integer> inta = Arrays.asList(new Integer[] {2, 4});
		System.out.println(inta.stream().reduce((x, y) -> getMax(x, y)).get());
		
	}

	private static Integer getMax(Integer x, Integer y) {
		// TODO Auto-generated method stub
		if(x.compareTo(y)<0) return y;
		else if(x.compareTo(y)>0) return x;
		return y;
	}

	interface Test {
		Double operation(Integer x,Integer y);
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