package Ex2.behavior.impl;

import Ex2.behavior.QuackBehavior;

public class QuackMute implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("\tcan not quack");
	}

}
