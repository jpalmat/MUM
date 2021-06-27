package prob1;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ints = new ArrayList<Integer>(); 
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints; 
//		nums.add(3.14);
	}

}
