package labs.prob4.main;

import labs.prob4.duck.DecoyDuck;
import labs.prob4.duck.Duck;
import labs.prob4.duck.MallardDuck;
import labs.prob4.duck.RedheadDuck;
import labs.prob4.duck.RubberDuck;

public class Main {

	public static void main(String[] args) {
		Duck [] ducks = {new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()}; 
		for(Duck duck : ducks) {
		System.out.println(duck.getClass().getSimpleName()+":");
			duck.display();
			duck.fly();
			duck.quack();
			duck.swimm();
		}
		
	}
}
