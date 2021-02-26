package exe1.partB;

import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		//Supplier<Double> ram = a -> syso;
		Supplier<Double> sup1 = () -> Math.random(); 
		
		System.out.println(sup1.get());
		
		InnerClass inner = new InnerClass();
		System.out.println(inner.get());
	}
	
}

class InnerClass implements Supplier<Double> {

	@Override
	public Double get() {
		return Math.random();
	}
	
}