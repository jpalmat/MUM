package exam2.prob6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test {

	public static void main(String[] args) {
		List<String> a = Arrays.asList(new String[] {"Jimmy", "Palma", "Jimmy", "Jimmy", "Palma", "Jimmy"});
		System.out.println(a);
		System.out.println(remove2(a));
		
		List<Integer> intList = Arrays.asList(new Integer[] {1, 2,3,4,5,6,7,8,9});
		System.out.println(count(intList, (x) -> x%2!=0));
		
		System.out.println(exchangeArray(new String[] {"2", "3"}));
	}
	
	private static <T> List<T> remove2(List<T> list) {
		List<T> newList = new ArrayList<T>();
		for (T t : list) {
			if(newList.contains(t)) {
				continue;
			}
			newList.add(t);
		}
		return newList;
	}
	
	///Write a generic method to count the number of elements in a collection that have a 
	//specific property (for example, odd integers, prime numbers, palindromes).
	private static <T> Integer count(List<T> list, Function<T, Boolean> pred) {
		Integer count = 0;
		for (T t : list) {
			if(pred.apply(t)) {
				count++;
			}
		}
		return count;
	}
	
	//Write a generic method to exchange the positions of two different elements in an array.
	private static <T> T[] exchangeArray(T[] t) {
		if(t.length<2) {
			throw new RuntimeException("Size wrong");
		}
		T aux;
		aux = t[0];
		t[0] = t[1];
		t[1] = aux;
		return t;
	}
	
}
