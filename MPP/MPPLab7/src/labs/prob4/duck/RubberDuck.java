package labs.prob4.duck;

import labs.prob4.behavior.impl.CanNotFly;
import labs.prob4.behavior.impl.QuackSqack;

public class RubberDuck extends Duck implements CanNotFly, QuackSqack{

	public RubberDuck() {
		super();
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
