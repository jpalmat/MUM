package labs.prob4.behavior.impl;

import labs.prob4.behavior.FlyBehavior;

public interface CanNotFly extends FlyBehavior {

	default void fly() {
		System.out.println("\tCan not fly");
	}

}
