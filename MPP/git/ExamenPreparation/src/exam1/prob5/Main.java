package exam1.prob5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Main {
/*
//	public static void main(String[] args) {
//		List<Integer> a = Arrays.asList(new Integer[] {2, 4, 6});
//		List<Integer> b = Arrays.asList(new Integer[] {3, 5, 6, 7});
//		
//		System.out.println(mergeList(a, b));
//	}
//
//	public static <T> List<T> mergeList(List<T> list1, List<T> list2) {
//		List<T> mergedList = new ArrayList<T>();
//		mergedList.addAll(list1);
//		mergedList.addAll(list2);
//		return mergedList;
//	}
	// IMPLEMENT
		public static <T> List<T> combine(Stream<List<T>> stream) {
//			Comparator<T> con = Comparator.comparing(T::new, (e1, e2) -> e)
			// return new ArrayList<T>();
			return stream.reduce(new ArrayList<T>(), (a, b) -> {
				a.addAll(b);
				return a;

			});
		}

		public static<T extends Comparable> List<T> merge(List<? extends T> list1, List<? extends T> list2)
		{
			List<T> merged = new ArrayList<T>();
			merged.addAll(list1);
			merged.addAll(list2);
			Collections.sort(merged, new MyComparator());
			return merged;
		}
//		
//		public static<T> List<T> mergeJava8(List<T> list1, List<T> list2)
//		{
//			List<T> list = list1.stream().collect(Collectors.toList());
//			list.addAll(list2);
//
//			Collections.sort(list, new MyComparator());
//			return list;
//		}
		
		
		

		public static void testCombine() {
			List<List<Integer>> mainList = new ArrayList<>();
			List<Integer> a = Arrays.asList(new Integer[] {6, 3});
			List<Integer> b = Arrays.asList(new Integer[] {4, 5});
//			System.out.println(merge(a, b));
//			System.out.println(mergeJava8(a, b));
			mainList.add(a);
			mainList.add(b);
//			System.out.println(combine(mainList.stream()));
			
			List<List<String>> mainList1 = new ArrayList<>();
			List<String> ab = Arrays.asList(new String[] {"Alice", "Tom"});
			List<String> bb = Arrays.asList(new String[] {"Bob", "Richard"});
//			System.out.println(merge(ab, bb));
//			System.out.println(mergeJava8(ab, bb));
			mainList1.add(ab);
			mainList1.add(bb);
			System.out.println(combine(mainList1.stream()));
			
			List<List<? extends Object>> mainList2 = new ArrayList<>();
			List<String> aba = Arrays.asList(new String[] {"Alice", "Tom"});
			List<Integer> bba = Arrays.asList(new Integer[] {4, 5});
//			System.out.println(merge(aba, bba));
//			System.out.println(mergeJava8(aba, bba));
			mainList2.add(aba);
			mainList2.add(bba);
//			System.out.println(combine(mainList2.stream()));
		}

		public static void main(String[] args) {
			testCombine();
		}
}
class MyComparator<T>  implements Comparator<T> {


	@Override
	public int compare(T o1, T o2) {
		if(o1 instanceof String && o2 instanceof String) {
			return ((String) o1).compareTo((String) o2);
		} else if (o1 instanceof Integer && o2 instanceof Integer) {
			return ((Integer) o1).compareTo((Integer) o2);
		} else if(o1 instanceof String && o2 instanceof Integer) {
//			return ((Integer) o2).compareTo(((String) o1).length());
			return ((Integer)((String) o1).length()).compareTo((Integer) o2);
		} else if(o2 instanceof String && o1 instanceof Integer) {
//			return ((Integer) o1).compareTo(((String) o2).length());
			return ((Integer)((String) o2).length()).compareTo((Integer) o1);
		}
		return 0;
	}*/

	public static void main(String[] args) {
		testCombine();
	}

	public static void testCombine() {
		List<String> stringList1 = new ArrayList<>(Arrays.asList("A", "AB", "XYZ", "AXTU"));
		List<Integer> integerList2 = new ArrayList<>(Arrays.asList(2, 3,4, 6));
		System.out.println(Main.combine(stringList1, integerList2, new MergeTwoTypes<String, Integer>() {
			@Override
			public Function<? super Integer, ? extends String> maps() {
				return (x) -> Integer.toString(x);
			}

			@Override
			public boolean isVal2Larger(String val, Integer val2) {
				return val.length() > val2;
			}
		}));
//		List<Double> list1 = new ArrayList<>(Arrays.asList(2.3, 4.5));
//		List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 5));
//		System.out.println(Main.combine(list1, list2, new MergeTwoTypes<Double, Integer>() {
//			@Override
//			public Function<? super Integer, ? extends Double> maps() {
//				return ((Integer x) -> new Double(x));
//			}
//
//			@Override
//			public boolean isVal2Larger(Double val, Integer val2) {
//				return val > val2;
//			}
//		}));
//		List<String> String1 = new ArrayList<>(Arrays.asList("Alice", "Tom"));
//		List<String> String2 = new ArrayList<>(Arrays.asList("Bob", "Richard"));
//		System.out.println(Main.combine(String1, String2, new MergeTwoTypes<String, String>() {
//			@Override
//			public Function<? super String, ? extends String> maps() {
//				return ((String x) -> new String(x));
//			}
//
//			@Override
//			public boolean isVal2Larger(String val, String val2) {
//				return val.compareTo(val2)>0;
//			}
//		}));
		
	}

	private static <T, U> List<T> combine(List<T> vals1, List<U> vals2, MergeTwoTypes<T, U> mergeTwoTypes) {
		List<T> list = new ArrayList<>();
		int vals2Index = 0;
		for (T val : vals1) {
			for (; vals2Index < vals2.size(); vals2Index++) {
				U val2 = vals2.get(vals2Index);
				if (mergeTwoTypes.isVal2Larger(val, val2)) {
					list.add(mergeTwoTypes.maps().apply(val2));
				} else {
					break;
				}
			}
			list.add(val);
		}
		for (; vals2Index < vals2.size(); vals2Index++) {
			U val2 = vals2.get(vals2Index);
			list.add(mergeTwoTypes.maps().apply(val2));
		}
		return list;
	}

//	private static <T extends Comparable<? super T>> List<T> combine(List<T> vals1, List<T> vals2) {
//		List<T> list = new ArrayList<>();
//		list.addAll(vals1);
//		list.addAll(vals2);
//		Collections.sort(list);
//		return list;
//	}

	interface MergeTwoTypes<T, U> {
		boolean isVal2Larger(T val, U val2);

		Function<? super U, ? extends T> maps();
	}
}