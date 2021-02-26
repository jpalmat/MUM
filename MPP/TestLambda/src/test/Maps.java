package test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Maps {

	public static void main(String[] args) {
		Map<Integer, String> m = new HashMap<Integer, String>();
		m.put(1, "Jimmy");
		m.put(2, "bla");
		m.put(3, "ble");
		m.put(4, "blo");
		
//		System.out.println(m);
//		
//		System.out.println(m.keySet().stream().collect(Collectors.toList()));
//		System.out.println(m.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList()));
//		List<Entry<Integer, String>> p = m.entrySet().stream().collect(Collectors.toList());
		
		/*
		 * 1.- Print to the console the list of book Title � in sorted order -- 
		 * in which the book has been checked out on June 27, 2015. 
		 * The ordering of the book title is as follows: First sort by the length 
		 * of the title (number of characters), then by alphabetical order.  
		 * 2.- Then find the more expensive book
		 * 3.- eliminate books price less than 6
		 */
//		List<Book> book = Arrays.asList(new Book[] {new Book("Ala", 3), new Book("Jimmy", 100), new Book("Jimm", 1), new Book("BBB", 5), });
//		Supplier<Stream<Book>> sb = () -> book.stream();
//		Comparator<Book> con1 = Comparator.comparing(Book::getName, (e1, e2) -> e1.length() == e2.length() ? 0 : e1.length() < e2.length() ? -1 : 1);
//		Comparator<Book> con2 = Comparator.comparing(Book::getName, (e1, e2) -> e1.compareTo(e2));
//		System.out.println(sb.get().sorted(con1.thenComparing(con2)).map(bo -> bo.getName()).collect(Collectors.joining(", ")));
//		System.out.println(sb.get().filter(bu -> bu.getPrice()==sb.get().map(buu-> buu.getPrice()).reduce(Integer::max).orElse(0)).collect(Collectors.toList())); //sol1
//		System.out.println(sb.get().reduce((x,y)->{
//			Book max;
//			if(x.getPrice()>y.getPrice())
//				max=x;
//			else
//				max=y;
//			return max;
//		}).get());
//		System.out.println(sb.get().map(b -> getBook(b)).filter(Objects::nonNull).collect(Collectors.toList()));
//		System.out.println(sb.get().filter(b -> b.getPrice()>6).filter(Objects::nonNull).collect(Collectors.toList()));
//		
		testCombine();
		
		//write a functions that print the n first evennumber
//		Function<Integer, List<Integer>> f = x -> {
//			Stream<Integer> a = Stream.iterate(0, n -> n+2);
//			return a.limit(x).collect(Collectors.toList());
//		};
//		
//		System.out.println(f.apply(5));
	}
	
	private static Object getBook(Book b) {
		if(b.getPrice()>6) {
			return b;
		}
		return null;
	}

		// IMPLEMENT
//		public static <T> ArrayList<T> combine(Stream<ArrayList<T>> stream) {
//			return stream.reduce(new ArrayList<T>(), (a,b)->{
//				a.addAll(b);
//				return a;
//			});
//		}
	
	public static <T> List<T> combine(List<? extends T> list1, List<? extends T> list2){
		List<T> newList = new ArrayList<T>();
		newList.addAll(list1);
		newList.addAll(list2);
		
		Collections.sort(newList, new MyComparator());
		return newList;
	}

		public static void testCombine() {
			ArrayList<ArrayList<String>> mainList = new ArrayList<>();
			ArrayList<String> list1 = new ArrayList<String>() {
				{
					add("hello");
					add("there");
				}
			};
			ArrayList<Integer> list2 = new ArrayList<Integer>() {
				{
					add(3);
					add(1);
				}
			};
			
			ArrayList<Double> list3 = new ArrayList<Double>() {
				{
					add(3.0);
					add(1.0);
				}
			};
//			mainList.add(list1);
//			mainList.add(list2);
			System.out.println(mainList.stream().flatMap(a -> a.stream()).collect(Collectors.toList()));
			System.out.println(mainList);
//			System.out.println(combine(mainList.stream()));
			System.out.println(combine(list1, list2));
			System.out.println(combine(list1, list3));
		}
}

class MyComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		
		return ((Comparable) o1).compareTo(2);
	}
	
}
class Book {
	private String name;
	private Integer price;

	public Book(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " "+price;
	}
}