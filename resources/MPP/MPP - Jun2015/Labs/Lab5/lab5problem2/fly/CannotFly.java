package lab5problem2.fly;

public class CannotFly implements FlyBehavior{

	@Override
	public void fly() {
		System.out.println("\tCannot Fly");
		
	}

}
