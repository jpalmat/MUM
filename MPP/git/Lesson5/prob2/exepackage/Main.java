package prob2.exepackage;

import prob2.duck.DecoyDuck;
import prob2.duck.Duck;
import prob2.duck.MallardDuck;
import prob2.duck.RedheadDuck;
import prob2.duck.RubberDuck;

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
