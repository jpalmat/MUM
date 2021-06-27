package exam2.prob2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exam2.helperclasses.CheckoutRecordEntry;
import exam2.helperclasses.TestData;

/*
 * Print to the console the list of book Title � in sorted order -- 
 * in which the book has been checked out on June 27, 2015. 
 * The ordering of the book title is as follows: First sort by the length 
 * of the title (number of characters), then by alphabetical order.  
 */
public class Problem2 {

	public static void main(String[] args) {
		// use this list
		Comparator<String> con = Comparator.comparing(String::new, (e1, e2) -> e1.length()==e2.length() ? 0 : e1.length()<e2.length() ? -1 : 1);
		Comparator<String> con1 = Comparator.comparing(String::new, (e1, e2) -> e1.compareTo(e2));
		List<CheckoutRecordEntry> list = TestData.INSTANCE.getAllEntries();
		list.stream()
		.filter(c -> c.getCheckoutDate().isEqual(LocalDate.of(2015, 6, 27)))
		.map(c -> c.getCopy())
		.map(b -> b.getBook())
		.map(t -> t.getTitle())
		.sorted(con.thenComparing(con1))
		.collect(Collectors.toList()).forEach(x -> System.out.println(x));
	}

}
