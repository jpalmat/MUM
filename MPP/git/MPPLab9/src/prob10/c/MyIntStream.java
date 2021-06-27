package prob10.c;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyIntStream {

	public static void main(String[] args) {
		IntStream myIntStream = IntStream.of(3,5,7,8,9,12,65,32,56); 
		
		IntSummaryStatistics statistics = myIntStream.mapToObj(Integer::valueOf).collect(Collectors.summarizingInt(x -> x));
		System.out.println("Maximum Value: "+statistics.getMax());
		System.out.println("Minimum Value: "+statistics.getMin());
	}
}
