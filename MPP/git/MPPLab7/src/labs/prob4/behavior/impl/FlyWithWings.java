package labs.prob4.behavior.impl;

import labs.prob4.behavior.FlyBehavior;

public interface FlyWithWings extends FlyBehavior {

	default void fly() {
		System.out.println("\tFly With wings");
	}

}
