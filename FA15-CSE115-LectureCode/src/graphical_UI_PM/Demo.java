package graphical_UI_PM;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Demo implements Runnable {
	private JFrame window;

	@Override
	public void run() {
		window = new JFrame("A sequence of characters");
//		window.setLayout(new FlowLayout());
		window.setLayout(new GridLayout(0,2));
		JButton b;
		b = new JButton("Click me!  No don't.  Only kidding :-)");
		b.addActionListener(new OurEventHandler(window));
		window.add(b);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

}
