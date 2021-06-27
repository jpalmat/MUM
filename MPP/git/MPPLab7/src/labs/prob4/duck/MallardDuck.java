package labs.prob4.duck;

import labs.prob4.behavior.impl.FlyWithWings;
import labs.prob4.behavior.impl.QuackQuack;

public class MallardDuck extends Duck implements FlyWithWings, QuackQuack{

	public MallardDuck() {
		super();
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
