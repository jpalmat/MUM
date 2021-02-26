package labs.prob4.duck;

import labs.prob4.behavior.impl.CanNotFly;
import labs.prob4.behavior.impl.QuackMute;

public class DecoyDuck extends Duck implements CanNotFly, QuackMute{

	public DecoyDuck() {
		super();
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
