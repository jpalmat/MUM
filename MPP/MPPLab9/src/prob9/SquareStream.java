package prob9;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SquareStream {

	
	public static void printSquares(int num) {
		IntStream stream = IntStream.iterate(1, n -> square(n+1));
		System.out.println(stream.limit(num).mapToObj(Integer::valueOf).collect(Collectors.toList()));
	}
	
	
	private static int square(int t) {
		Integer previousSquire = (int) Math.sqrt(t-1); 
		Integer squreValue = (int) Math.pow(previousSquire+1, 2); 
		return squreValue;
	}

	

}
