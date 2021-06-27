package exe5;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ForEachExample {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//print each element of the list in upper case format
		System.out.println("*********** A ************\n");
		list.forEach(string -> System.out.println(string.toUpperCase()));
		
		System.out.println("\n*********** B ************\n");
		Consumer<String> consumer = c -> System.out.println(c.toUpperCase());
		list.forEach(consumer);
		
		
	}
	
	//implement a Consumer
	
	
}
