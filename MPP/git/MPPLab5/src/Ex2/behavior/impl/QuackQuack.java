package Ex2.behavior.impl;

import Ex2.behavior.QuackBehavior;

public class QuackQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("\tqueaking"); 
	}

}
