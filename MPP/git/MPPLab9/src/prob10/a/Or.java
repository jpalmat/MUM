package prob10.a;

import java.util.*;

public class Or {

	public static void main(String[] args) {
		List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(true));

//		System.out.println(someSimpleIsTrue(list));
		
		List<Integer> intList = Arrays.asList(new Integer[] {3, 1, 5, 0});
		System.out.println(intList.stream().filter(Objects::nonNull).reduce(0, (x, y)-> getMax(x, y)));
	}
	
	private static Integer getMax(Integer x, Integer y) {
		return x<y ? y : x;
	}

	static public boolean someSimpleIsTrue(List<Simple> list) {
//		boolean accum = false;
//		for(Simple s: list) {
//			accum = accum || s.flag;
//		}
//		
		Boolean a = list.stream().filter(Objects::nonNull).map(x -> x.flag).reduce(false, (x, y) -> getFlag(x, y));
		return a;
//		return list.stream().filter(Objects::nonNull).map(x -> x.flag).reduce(false, (x,y) -> x||y);
	}

	private static Boolean getFlag(Boolean x, Boolean y) {
		if(x!= null && x) System.out.println(x);
		if(y != null && y) System.out.println(y);
		return x||y;
	}

}
