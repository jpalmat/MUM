package lab5problem2.quack;
public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("\tCanot quack");

	}
}
