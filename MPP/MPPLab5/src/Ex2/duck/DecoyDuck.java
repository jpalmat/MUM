package Ex2.duck;

import Ex2.behavior.FlyBehavior;
import Ex2.behavior.QuackBehavior;

public class DecoyDuck extends Duck {

	public DecoyDuck(FlyBehavior flyBe, QuackBehavior quackBe) {
		super(flyBe, quackBe);
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
