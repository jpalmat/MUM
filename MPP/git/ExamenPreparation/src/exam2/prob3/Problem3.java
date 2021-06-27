package exam2.prob3;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import exam2.helperclasses.Book;
import exam2.helperclasses.BookCopy;
import exam2.helperclasses.CheckoutRecord;
import exam2.helperclasses.LibraryMember;
import exam2.helperclasses.LibrarySystemException;
import exam2.helperclasses.TestData;

public class Problem3 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Problem3 p = new Problem3();
		List<LibraryMember> members = TestData.INSTANCE.getMembers();
		p.books = TestData.INSTANCE.getAllBooks().iterator();

	}

	Iterator<Book> books;

	public LibraryMember detectIfWinnerDuringCheckout(List<LibraryMember> mems) {
		// return null;
		// fix this
		 return mems.stream()
				 .filter(mem -> f(mem, books.next().getNextAvailableCopy(), LocalDate.now(),LocalDate.of(2015, 9, 1)))
		 .findFirst().orElse(null);

	}
	
	private Boolean f(LibraryMember mem, BookCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		CheckoutRecord record = checkoutHelper(mem, copy, checkoutDate, dueDate);
		return record.getCheckoutRecordEntries().size() == 10;
	}
	
	public CheckoutRecord checkoutHelper(LibraryMember mem, BookCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		try {
			return mem.checkout(copy, checkoutDate, dueDate);
		} catch (LibrarySystemException e) {
			throw new RuntimeException(e);
		}
	}

}