package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class eventhandler implements ActionListener{

	example1.BarnYard b;
	public eventhandler(example1.BarnYard ba) {
		b=ba;
	}


	public void actionPerformed(ActionEvent e) {
		example1.Chicken c;
		c = new example1.Chicken();
		b.addChicken(c);
		
		javax.swing.JButton l;
		l = new javax.swing.JButton("Start Chicken");
		l.addActionListener(new Eventhandler1(c));
		b.addButton(l);
		
		javax.swing.JButton k;
		k= new javax.swing.JButton("Stop Chicken");
		k.addActionListener(new Eventhandler2(c));
		b.addButton(k);
		
		
	}

}

