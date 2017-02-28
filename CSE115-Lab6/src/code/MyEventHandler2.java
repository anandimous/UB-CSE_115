package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import code.eventhandler.Example;
import code.eventhandler.Num;

public class MyEventHandler2 implements ActionListener {
	
public MyEventHandler2() {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		java.util.Random r = new Random();
		Example.x = r.nextInt(3);
		
		Num.h = Num.h+1;		
		}


}
