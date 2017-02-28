package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import example1.Chicken;

public class Eventhandler2 implements ActionListener{
	
	example1.Chicken ch;
	public Eventhandler2(Chicken chk){
		ch=chk;
	}
	
	public void actionPerformed(ActionEvent e) {
		ch.stop();
		}
}
	
