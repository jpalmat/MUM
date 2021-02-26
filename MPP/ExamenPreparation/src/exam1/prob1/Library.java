package exam1.prob1;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Library {

	public static final Function<List<CheckoutRecord>, Boolean> testA = (l) -> {
		return l.stream()
				.flatMap(p -> p.getCheckoutRecordEntries().stream())
				.filter(p -> p.getDueDate().isBefore(LocalDate.now()))
				.map(p -> p.getCopy())
				.filter(b -> !b.isAvailable())
				.findAny().isPresent();
	};
	
	public static final Function<List<LibraryMember>, List<String>> testC = (l) -> {
		Comparator<String> con = Comparator.comparing(String::new, (e1, e2) -> e1.compareTo(e2));
		return l.stream().filter(p -> p.getRecord().getCheckoutRecordEntries().size()==0)
		.map(p -> p.getFirstName() + " " + p.getLastName())
		.sorted(con.reversed())
		.collect(Collectors.toList());
	};
}
