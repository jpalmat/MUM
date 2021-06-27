package Ex2.factory;

import Ex2.behavior.impl.CanNotFly;
import Ex2.behavior.impl.FlyWithWings;
import Ex2.behavior.impl.QuackMute;
import Ex2.behavior.impl.QuackQuack;
import Ex2.behavior.impl.QuackSqack;
import Ex2.duck.DecoyDuck;
import Ex2.duck.Duck;
import Ex2.duck.MallardDuck;
import Ex2.duck.RedheadDuck;
import Ex2.duck.RubberDuck;
import Ex2.enumDuck.DuckTypes;

public class DuckFactory {

	DuckTypes a = DuckTypes.DECOYDUCK;
	public static Duck getInstance(DuckTypes obj) {
		if(obj == DuckTypes.DECOYDUCK) {
			return new DecoyDuck(new CanNotFly(), new QuackMute());
		} else if(obj == DuckTypes.MALLARDDUCK) {
			return new MallardDuck(new FlyWithWings(), new QuackQuack());
		} else if(obj == DuckTypes.REDHEADDUCK) {
			return new RedheadDuck(new FlyWithWings(), new QuackSqack());
		} else if(obj == DuckTypes.RUBBERDUCK) {
			return new RubberDuck(new CanNotFly(), new QuackSqack());
		}
		return null;
	}
}
