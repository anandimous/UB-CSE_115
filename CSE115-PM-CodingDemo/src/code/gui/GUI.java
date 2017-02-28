package code.gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import code.model.Model;

public class GUI {
	
	private Model _model;
	private JLabel _label;

	public GUI(Model m) {
		_model = m;
		_model.addObserver(this);
		JFrame window = new JFrame("Application");
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));
		_label = new JLabel();
		JButton up = new JButton("+");
		up.addActionListener(new IncrementListener(_model));
		JButton down = new JButton("-");
		down.addActionListener(new DecrementListener(_model));
		window.add(p);
		p.add(_label);
		p.add(up);
		p.add(down);
		update();
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public void update() {
		_label.setText("Value: "+_model.getNumber());
	}

}
