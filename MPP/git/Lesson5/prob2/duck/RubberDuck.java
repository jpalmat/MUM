package prob2.duck;

import prob2.behavior.impl.CanNotFly;
import prob2.behavior.impl.QuackSqack;

public class RubberDuck extends Duck {

	public RubberDuck() {
		super(new CanNotFly(), new QuackSqack());
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
