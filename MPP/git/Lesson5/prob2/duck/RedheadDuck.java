package prob2.duck;

import prob2.behavior.impl.FlyWithWings;
import prob2.behavior.impl.QuackSqack;

public class RedheadDuck extends Duck {

	public RedheadDuck() {
		super(new FlyWithWings(), new QuackSqack());
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
