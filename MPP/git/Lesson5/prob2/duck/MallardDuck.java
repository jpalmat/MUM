package prob2.duck;

import prob2.behavior.impl.FlyWithWings;
import prob2.behavior.impl.QuackQuack;

public class MallardDuck extends Duck {

	public MallardDuck() {
		super(new FlyWithWings(), new QuackQuack());
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
