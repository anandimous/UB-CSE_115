package graphical_UI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo implements Runnable{

	@Override
	public void run() {
		JFrame window;
		window = new JFrame("A title for our window!");
		JButton b = new JButton("Click me!  No, don't.  OK, just kidding!");
//		window.getContentPane().setLayout(new FlowLayout());
		window.getContentPane().setLayout(new GridLayout(0,2));
		window.add(b);
		b.addActionListener(new OurEventHandler(window));
		window.pack();
		window.setVisible(true);
	}

}
