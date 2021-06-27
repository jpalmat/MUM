package prob2.behavior.impl;

import prob2.behavior.QuackBehavior;

public class QuackQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("\tqueaking"); 
	}

}
