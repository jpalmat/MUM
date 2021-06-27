package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparatorTest {

	
	public static void main(String[] args) {
		List<Estudent> list = Arrays.asList(new Estudent[] {null, null, null});
		Function<List<Estudent>, Stream<Estudent>> f = (l) -> l.stream(); 
		
//		Comparator<Estudent> estCompa = (e1, e2) -> e1.getNombre().compareToIgnoreCase((e2.getNombre()));
//		List<Estudent> listOrder = list.stream().sorted(estCompa).collect(Collectors.toList());
//		listOrder.forEach(n -> System.out.println(n));
		
//		System.out.println("*****************\n");
//		
		Comparator<Estudent> compa = Comparator.comparing(Estudent::getNombre, (e1, e2)-> e1.compareTo(e2))
				.thenComparing(Estudent::getAge, (e1, e2)-> e2 == e1 ? 0 : e2<e1 ? -1 : 1);
		List<Estudent> listOrder1 = Optional.ofNullable(list)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(Objects::nonNull)
				.sorted(compa)
				.collect(Collectors.toList());
		listOrder1.forEach(n -> System.out.println(n));
//		
//		List<Estudent> listOrder2 = f.apply(list)
//				.sorted(Comparator.comparing(Estudent::getNombre, (e1, e2) -> e1.compareTo(e2))
//						.thenComparing(Estudent::getAge, (e1, e2) -> e2==e1 ? 0 : e2 < e1 ? -1 : 1))
//				.collect(Collectors.toList());
//		listOrder2.forEach(n -> System.out.println(n));
		
//		List<String> listA = Arrays.asList(new String[] {"Jimmy", "Hola", "Lo"});
//		Comparator<String> comA = Comparator.comparing(String::new, (x, y) -> x.compareTo(y));
//		System.out.println(listA.stream().sorted(comA).collect(Collectors.joining(", ")));
//		
//		List<Integer> listI = Arrays.asList(new Integer[] {9, -1, -9, 3, 0, 1});
//		Comparator<Integer> conI = Comparator.comparing(Integer::new, (x, y)-> Math.abs(x)-Math.abs(y));
//		Comparator<Integer> conII = Comparator.comparing(Integer::new, (x, y) -> x-y);
//		System.out.println(listI.stream().sorted(conI.thenComparing(conII)).map(x -> x.toString()).collect(Collectors.joining(", ")));

		
	}
}

class Estudent {
	private String nombre;
	private Integer age;
	public Estudent(String nombre, Integer age) {
		super();
		this.nombre = nombre;
		this.age = age;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre + " "+ age;
	}
}