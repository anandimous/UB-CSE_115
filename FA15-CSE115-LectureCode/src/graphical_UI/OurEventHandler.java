package graphical_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class OurEventHandler implements ActionListener {
	
	private JFrame _win;
	
	public OurEventHandler(JFrame w) {
		_win = w;
	}

	@Override  // @Override is an 'annotation'
	public void actionPerformed(ActionEvent e) {
		System.out.println("That tickles!");
		// add another JLabel with the text "A label" to the JFrame
		_win.add(new JLabel("A label"));
		_win.pack(); 
	}

}
