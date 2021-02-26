package prob2.behavior.impl;

import prob2.behavior.QuackBehavior;

public class QuackMute implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("\tcan not quack");
	}

}
