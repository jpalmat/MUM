package labs.prob4.duck;

import labs.prob4.behavior.impl.FlyWithWings;
import labs.prob4.behavior.impl.QuackSqack;

public class RedheadDuck extends Duck implements FlyWithWings, QuackSqack{

	public RedheadDuck() {
		super();
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
