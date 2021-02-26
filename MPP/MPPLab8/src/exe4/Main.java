package exe4;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] {"asd", "wsrdt", "wse", "rst"});
		Main m = new Main();
		System.out.println(m.countWords(list, "s", "t", 3));
		
	}
	
	public int countWords(List<String> words, CharSequence c, CharSequence d, int len) {
		int count = 0;
		count = (int) words.stream()
		.filter(w -> w.length() == len && w.contains(c) && !w.contains(d))
		.count();
		return count;
	}
}
