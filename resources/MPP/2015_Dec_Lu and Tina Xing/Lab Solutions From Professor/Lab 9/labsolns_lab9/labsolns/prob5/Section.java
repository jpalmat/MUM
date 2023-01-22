package lesson9.labsolns.prob5;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Section {
	public static Stream<String> streamSection(Stream<String> stream, int m, int n) {
		return stream.limit(n+1).skip(Math.max((long)m, 0L));
	}
	
	public static void main(String[] args) {
		System.out.println(streamSection(nextStream(), 0, 3).collect(Collectors.joining(", ")));
		System.out.println(streamSection(nextStream(), 2, 5).collect(Collectors.joining(", ")));
		System.out.println(streamSection(nextStream(), 7, 8).collect(Collectors.joining(", ")));	
	}
	
	
	
	
	
	
	
	
	
	
	
	//support method for the main method -- for testing
	private static Stream<String> nextStream() {
		return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
	}
}
