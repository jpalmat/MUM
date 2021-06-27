package prob2.duck;

import prob2.behavior.FlyBehavior;
import prob2.behavior.QuackBehavior;

public abstract class Duck {
	public FlyBehavior flyBehavoir; 
	public QuackBehavior quackBehavior; 	
	
	public Duck(FlyBehavior flyBehavoi, QuackBehavior quackBehavior) {
		super();
		this.flyBehavoir = flyBehavoi;
		this.quackBehavior = quackBehavior;
	}
	public abstract void display(); 

	public void fly() {
		flyBehavoir.fly();
	}
	
	public void quack() {
		quackBehavior.quack(); 
	}
	
	public void swimm() {
		System.out.println("\tswimming");
	}
	
}
