package labs.prob4.duck;

import labs.prob4.behavior.FlyBehavior;
import labs.prob4.behavior.QuackBehavior;

public abstract class Duck implements QuackBehavior, FlyBehavior{	
	
	public Duck() {
		super();
	}
	public abstract void display(); 
	
	public void swimm() {
		System.out.println("\tswimming");
	}
	
}
