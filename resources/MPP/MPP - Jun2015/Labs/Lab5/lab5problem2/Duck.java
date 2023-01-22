package lab5problem2;

import lab5problem2.quack.QuackBehavior;
import lab5problem2.fly.FlyBehavior;

public abstract class Duck implements FlyBehavior, QuackBehavior {
	public abstract void display();

	public void fly(){
		DuckBehaviorFactory.getFlyBeahvior(this).fly();
	}

	public void quack() {
		DuckBehaviorFactory.getQuackBehavior(this).quack();
	}
	
	public void swim(){
		System.out.println("\tSwiming");
	}
}
