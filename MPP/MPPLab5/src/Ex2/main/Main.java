package Ex2.main;

import Ex2.duck.Duck;
import Ex2.enumDuck.DuckTypes;
import Ex2.factory.DuckFactory;

public class Main {

	public static void main(String[] args) {
		Duck [] ducks = {DuckFactory.getInstance(DuckTypes.MALLARDDUCK), DuckFactory.getInstance(DuckTypes.DECOYDUCK), 
				DuckFactory.getInstance(DuckTypes.REDHEADDUCK), DuckFactory.getInstance(DuckTypes.RUBBERDUCK)}; 
		for(Duck duck : ducks) {
		System.out.println(duck.getClass().getSimpleName()+":");
			duck.display();
			duck.fly();
			duck.quack();
			duck.swimm();
		}
		
	}
}
