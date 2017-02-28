package code.model;

import java.util.ArrayList;

import code.gui.GUI;

public class Model {

	private int _number;
	private ArrayList<GUI> _observers;
	
	public Model() {
		_number = 0;
		_observers = new ArrayList<GUI>();
	}
	
	public void addObserver(GUI gui) {
		_observers.add(gui);
	}

	public void increment() {
		_number = _number + 1;
		updateObservers();
	}
	
	public void updateObservers() {
		for (GUI g : _observers) {
			g.update();
		}
	}
	
	public int getNumber() {
		return _number;
	}

	public void decrement() {
		_number = _number - 1;
		updateObservers();
	}

	
}
