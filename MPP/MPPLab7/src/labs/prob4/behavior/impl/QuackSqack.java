package labs.prob4.behavior.impl;

import labs.prob4.behavior.QuackBehavior;

public interface QuackSqack extends QuackBehavior {

	default void quack() {
		System.out.println("\tsqueaking");
	}

}
