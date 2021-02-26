package exam1.prob1;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Main t = new Main();
		t.testA();
		System.out.println(t.testC());
//		t.testB(TestData.INSTANCE.getMembers().get(0).getRecord().getCheckoutRecordEntries().get(0).getCopy(), t.getMembers().get(0));
	}
	
	/**
	 * Query A: Given a member's checkout record, determine whether some BookCopy in the record is overdue. NOTE: A BookCopy is overdue if 
		(a) it is not available, and
		(b) its due date is before now
	 * @param args
	 */
	public void testA() {
		List<LibraryMember> mems = TestData.INSTANCE.getMembers();
		System.out.println("some BookCopy in the record is overdue: "+mems.stream()
		.flatMap(p -> p.getRecord().getCheckoutRecordEntries().stream())
		.filter(p -> p.getDueDate().isBefore(LocalDate.now()))
		.map(p -> p.getCopy())
		.filter(b -> !b.isAvailable())
		.findAny().isPresent());
//		System.out.println("some BookCopy in the record is overdue: "+ Library.testA.apply(getAllRecords()));
	}
	
	/**
	 * Query B: Given a BookCopy copy and a LibraryMember mem, return true if mem has ever checked out this copy
	 */
	public boolean testB(BookCopy copy, LibraryMember men) {
		return men.getRecord().getCheckoutRecordEntries().stream().filter(b -> b.getCopy().equals(copy)).findAny().isPresent();
	}
	
	/**
	 * Query C: Given a list of all library members, return a list, in reverse sorted order (by first name), of the full names (first name + <space> + last name) 
	 * of those library members who have never checked out a book
	 */
	public List<String> testC() {
//		Comparator<String> con = Comparator.comparing(String::new, (e1, e2) -> e1.compareTo(e2));
//		return members.stream().filter(p -> p.getRecord().getCheckoutRecordEntries().size()==0)
//		.map(p -> p.getFirstName() + " " + p.getLastName())
//		.sorted(con.reversed())
//		.collect(Collectors.toList());
		return Library.testC.apply(TestData.INSTANCE.getMembers());
	}
}
