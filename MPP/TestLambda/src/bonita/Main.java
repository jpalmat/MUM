package bonita;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
	
	static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Type.MEAT), new Dish("beef", false, 900, Type.MEAT));
	public static final Supplier<Stream<Dish>> streamSupplier = () -> menu.stream();
	public static void main(String[] args) {
		
		
		//1
		streamSupplier.get()
			.filter(c -> c.isVegetarian() == false)
			.filter(p -> p.getCalories() > 400)
			.map(m -> m.getName())
			.collect(Collectors.toList());
		
		//4
		System.out.println(streamSupplier.get().filter(p -> p.getName().equals("french fries")).findFirst().isPresent());
		
		//5
		
		System.out.println(streamSupplier.get().map(m -> m.getCalories()).reduce(0, Integer::max));
		
		//6
		Library.prob6(400);
		
	}
}

class Dish {
	private String name;
	private boolean vegetarian;
	private int calories;
	private Type type;
	

	
	public Dish(String name, boolean vegetarian, int calories, Type type) {
		super();
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
	
}
enum Type {
	MEAT, FISH, OTHER
}

class Library {
	public static void prob6(int calories) {
		Main.streamSupplier.get()
		.filter(c -> c.isVegetarian() == false)
		.filter(p -> p.getCalories() > calories)
		.map(m -> m.getName())
		.collect(Collectors.toList()).forEach(p -> System.out.println(p));;
	}
}