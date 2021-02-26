package exam1.prob2.partA;

import java.util.Comparator;
import java.util.function.Supplier;

//() -> Math.random()
public class PartA {

	// Assign an appropriate type (some functional interface)
	Supplier<Double> randon = () -> Math.random();

		// Express it as a method expression
	Supplier<Double> randonME = Math::random;
		// State the type of method expression you have used
		//class:StaticMethod
	
	//Express it as an inner class 
		class Test implements Supplier<Double>{

			@Override
			public Double get() {
				return Math.random();
			}
			
		}

		public void evaluator() {
			System.out.println(randon.get());//lambda
			System.out.println(randonME.get());//method expression
			System.out.println(new Test().get());//inner class
		}

		public static void main(String[] args) {
			PartA pa = new PartA();
			
			pa.evaluator();
		}
}