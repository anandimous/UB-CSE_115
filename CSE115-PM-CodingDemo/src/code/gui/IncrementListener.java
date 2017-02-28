package code.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.model.Model;

public class IncrementListener implements ActionListener {

	private Model _model;
	
	public IncrementListener(Model m) {
		_model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_model.increment();
	}

}
