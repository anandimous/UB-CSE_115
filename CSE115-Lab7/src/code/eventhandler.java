package code;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JPanel;

public class eventhandler implements ActionListener {
	
	static JPanel fe;
	private JButton b1;
	
	
	
	public eventhandler(JPanel panel, JButton b) {
	
	    b1=b;
		fe=panel;
	}

	
	public void actionPerformed(ActionEvent e) {
	
	
	fe.remove(b1);
		
	}

}
