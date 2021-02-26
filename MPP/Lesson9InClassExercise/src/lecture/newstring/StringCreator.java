package lecture.newstring;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
public class StringCreator {
	public static void main(String[] args) {
	  char[] charArray = 
              {'s','p','e','a','k','i','n','g','c','s'};
	  //can create a string from a char array
	  System.out.println(new String(charArray));
	  
	  //do the same using constructor method reference
	  Function<char[], String> myFunc = String::new;
	  System.out.println(myFunc.apply(charArray));
	  
	  Function<char[], String> myFunc1 = x -> new String(x);
	  System.out.println(myFunc1.apply(charArray));
	  
	  Function<char[], String> myFunct3 = new Function<char[], String>() {
		
		@Override
		public String apply(char[] t) {
			return new String(t);
		}
	};
	System.out.println(myFunct3.apply(charArray));
	
	BiFunction<Integer, Integer, String> test = new BiFunction<Integer, Integer, String>() {
		
		@Override
		public String apply(Integer t, Integer u) {
			Integer a = t + u;
			return new String(a.toString());
		}
	};
	System.out.println(test.apply(2, 3));
	
	Consumer<String> con = new Consumer<String>() {
		
		@Override
		public void accept(String t) {
			System.out.println(t);
		}
	};
	
	con.accept(test.apply(4, 3));
	
	List<String> arr = Arrays.asList(new String[] {"a", "a","a"});
	arr.forEach(z-> con.accept(z));
	
    }

}