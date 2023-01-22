package lab5problem2;
import lab5problem2.quack.QuackBehavior;
import lab5problem2.quack.Quack;
import lab5problem2.quack.MuteQuack;
import lab5problem2.quack.Squeak;
import lab5problem2.fly.FlyWithWings;
import lab5problem2.fly.CannotFly;
import lab5problem2.fly.FlyBehavior;
import java.util.HashMap;

public class DuckBehaviorFactory {
	static HashMap<Class<? extends Duck>, FlyBehavior> flyMap = new HashMap<>();
	static HashMap<Class<? extends Duck>, QuackBehavior> quackMap = new HashMap<>();
	static {
		flyMap.put(RubberDuck.class, new CannotFly());
                quackMap.put(RubberDuck.class, new Squeak());
                
		flyMap.put(DecoyDuck.class, new CannotFly());
                quackMap.put(DecoyDuck.class, new MuteQuack());
                
		flyMap.put(MallardDuck.class, new FlyWithWings());
		quackMap.put(MallardDuck.class, new Quack());
                
                flyMap.put(RedheadDuck.class, new FlyWithWings());
		quackMap.put(RedheadDuck.class, new Quack());
	}

	public static FlyBehavior getFlyBeahvior(Duck duck) {
		Class<? extends Duck> cl = duck.getClass();
		if (!flyMap.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No Fly Behavior found for this type of ducks");
		}
		return flyMap.get(cl);
	}

	public static QuackBehavior getQuackBehavior(Duck duck) {
		Class<? extends Duck> cl = duck.getClass();
		if (!quackMap.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No QuackBehavior found for this type of ducks");
		}
		return quackMap.get(cl);
	}
}
