package exe3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		List<Double> list = new ArrayList<>(); 
		BiFunction<Double, Double, List> concat = 
		(x,y) -> {
		list.add(Math.pow(x,y));
		list.add(x * y);
		return list;
		};
		
		System.out.println(concat.apply(2.0, 3.0));
		
		Supplier<Double> f = () -> {
			return Math.random();
			};
		System.out.println(f.get());
		
		BiFunction<Integer, Integer, Integer> f1 = (x, y) -> x+y;
		System.out.println(f1.apply(1, 2));
	}
}