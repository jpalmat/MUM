package prob2.behavior.impl;

import prob2.behavior.FlyBehavior;

public class CanNotFly implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("\tCan not fly");
		//return "Can not fly";
	}

}
