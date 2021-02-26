package exam1.prob5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mian2 {

	static List<Integer> list = Arrays.asList(new Integer [] {1, 2, 3});
	
	public static void main(String[] args) {
		System.out.println(listC(list));
	}
	
	public static List<Pair> listC(List<Integer> l){
		List<Pair> newL = new ArrayList<Pair>();
		for (Integer pair : l) {
			for (Integer pair1 : l) {
				if (pair < pair1) {
					newL.add(new Pair(pair, pair1));
				}
			}
		}
		return newL;
	}
}

class Pair{
	private Integer a;
	private Integer b;
	public Pair(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}