package bank.observers;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	
	protected List<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
}
