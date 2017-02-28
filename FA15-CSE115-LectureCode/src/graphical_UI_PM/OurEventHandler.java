package graphical_UI_PM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OurEventHandler implements ActionListener {
	
	private JFrame _win;
	
	public OurEventHandler(JFrame w) {
		_win = w;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("That tickles!");
		_win.add(new JLabel("Oh stop that!"));
		_win.pack();
	}

}
