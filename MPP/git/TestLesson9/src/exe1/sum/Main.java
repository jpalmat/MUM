package exe1.sum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream<Integer> stream2 = Stream.iterate(1, n -> n + 1).limit(15).skip(8);
		stream2.filter(n -> n%2 != 0).collect(Collectors.toList()).forEach(o -> System.out.println(o));
		
		System.out.println("\n");
		Stream<Integer> stream3 = Stream.iterate(1, n -> n + 2).limit(10).skip(8);
		stream3.collect(Collectors.toList()).forEach(o -> System.out.println(o));
		
		System.out.println("\n");
		
		Stream<Integer> streamFunction = Stream.iterate(1, n -> getOdd(n + 1));
		streamFunction.limit(10).collect(Collectors.toList()).forEach(n -> System.out.println(n));
		
		
		
//		Integer a = stream2.reduce((x, y) -> x + y).orElse(null);
//		
//		System.out.println(a);
		
//		List<Student> stu = Arrays.asList(new Student[] {new Student(5), new Student(1)});
//		
//		Integer b = stu.stream().map(s -> s.getAge()).reduce((x,  y) -> x + y).orElse(0);
//		System.out.println(b);
	}

	private static Integer getOdd(Integer n) {
		if(n % 2 == 0) {
			return n + 1;
		}
		return n;
	}
}

class Student {
	private Integer age;

	public Student(Integer age) {
		super();
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}