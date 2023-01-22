package lesson9.labsolns.prob1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prob1B {
	public static void main(String[] args) {
		System.out.println(Arrays.asList("Bill", "Thomas", "Mary")
				                 .stream()
				                 .collect(Collectors.joining(", ")));
	}
}
