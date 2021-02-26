package prob2.duck;

import prob2.behavior.impl.CanNotFly;
import prob2.behavior.impl.QuackMute;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		super(new CanNotFly(), new QuackMute());
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
