package Ex1.rulesets;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import Ex1.gui.BookWindow;




/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {
	private BookWindow book;

	@Override
	public void applyRules(Component ob) throws RuleException {
		book = (BookWindow)ob;
		nonempty();
		validateIsbn();
		validatePrice();
	}

	private void validatePrice() throws RuleException {
		if(!book.getPriceValue().matches("[0-9]+\\.[0-9][0-9]")) {
			throw new RuleException("Price must be a floating point number with two decimal places");
		}
		
		Float price = Float.parseFloat(book.getPriceValue());
		if(price <= 0.49) {
			throw new RuleException("Price must be a number greater than 0.49.");
		}
	}

	private void validateIsbn() throws RuleException {
		if(!book.getIsbnValue().matches("[0-9]+")) {
			throw new RuleException("Isbn must be numeric and consist of either 10 or 13 characters");
		}
		if (book.getIsbnValue().length()==10) {
			List<String> validNum = Arrays.asList(new String[] {"0", "1"});
			if(!validNum.contains((book.getIsbnValue().substring(0, 1)))) {
				throw new RuleException("the first digit must be 0 or 1");
			}
		} else if (book.getIsbnValue().length() == 13) {
			List<String> validNum = Arrays.asList(new String[] {"978", "979"});
			if(!validNum.contains((book.getIsbnValue().substring(0, 3)))) {
				throw new RuleException("the the first 3 digits must be either 978 or 979");
			}
		} else {
			throw new RuleException("Isbn must consist of either 10 or 13 characters");
		}
	}

	/*
	 * validate fields must be nonempty
	 */
	private void nonempty() throws RuleException {
		if(book.getIsbnValue().trim().isEmpty() ||
				book.getTitle().trim().isEmpty() ||
				book.getPriceValue().trim().isEmpty()) {
			throw new RuleException("Fields empty");
		}
	}

}