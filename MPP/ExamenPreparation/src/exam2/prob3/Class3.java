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

public class Class3 {

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
		return mems.stream().filter(
				mem -> handle(mem, books.next().getNextAvailableCopy(), LocalDate.now(), LocalDate.of(2015, 9, 1))
						.getCheckoutRecordEntries().size() == 10)
				.findFirst().orElse(null);
	}

	public CheckoutRecord handle(LibraryMember me, BookCopy copy, LocalDate checkoutDate, LocalDate dueDate) {
		try {
			return me.checkout(copy, checkoutDate, dueDate);
		} catch (LibrarySystemException e) {
			throw new RuntimeException();
		}

	}
}
