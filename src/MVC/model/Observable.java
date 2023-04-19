package MVC.model;

import MVC.view.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private final List<Observer> observers = new ArrayList<>();

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

	public List<Observer> getObservers() {
		return observers;
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
}
