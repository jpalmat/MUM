package exam1.prob2.partB;

import java.util.List;
import java.util.function.Function;

//(CheckoutRecord record) -> record.getCheckoutEntries()
public class PartB {

	//	a. Assign an appropriate type (some functional interface) 
	Function<CheckoutRecord, List<CheckoutRecordEntry>> f = record -> record.getCheckoutEntries(); 
	//	b. Express it as a method expression 
	Function<CheckoutRecord, List<CheckoutRecordEntry>> f1 = CheckoutRecord::getCheckoutEntries;
	//	c. State the type of method expression you have used 
	//class::instanceMethod
	//	d. Express it as an inner class 
	class Test implements Function<CheckoutRecord, List<CheckoutRecordEntry>> {

		@Override
		public List<CheckoutRecordEntry> apply(CheckoutRecord t) {
			return t.getCheckoutEntries();
		}
		
	}
	//	e. Evaluate the lambda, the method expression and the inner class inside an evaluator() method. 
	public void evaluator() {
		System.out.println(f.apply(new CheckoutRecord()));
		System.out.println(f1.apply(new CheckoutRecord()));
		System.out.println(new Test().apply(new CheckoutRecord()));
	}

	public static void main(String[] args) {
		PartB pa = new PartB();
		
		pa.evaluator();
	}
}
