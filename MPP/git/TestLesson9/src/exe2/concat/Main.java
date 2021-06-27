package exe2.concat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] {"a", "b", "c"});
		
		System.out.println(list.stream().collect(Collectors.joining(""))); //my solution
		System.out.println(list.stream().reduce("", (s, t) -> s + t + ""  )); //reduce solution, not good
		System.out.println(list.stream().reduce("", (s, t) -> new StringBuilder(s).append(t).toString()));
	}
}