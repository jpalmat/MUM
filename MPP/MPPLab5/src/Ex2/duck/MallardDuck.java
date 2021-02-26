package Ex2.duck;

import Ex2.behavior.FlyBehavior;
import Ex2.behavior.QuackBehavior;
import Ex2.behavior.impl.FlyWithWings;
import Ex2.behavior.impl.QuackQuack;

public class MallardDuck extends Duck {

	public MallardDuck(FlyBehavior flyBe, QuackBehavior quackBe) {
		super(flyBe, quackBe);
	}

	@Override
	public void display() {
		System.out.println("\tdisplaying");
	}

}
