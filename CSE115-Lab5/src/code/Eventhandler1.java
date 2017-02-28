package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import example1.Chicken;

public class Eventhandler1 implements ActionListener{
	
	example1.Chicken ch;
	public Eventhandler1(Chicken chk){
		ch=chk;
	}
	
	public void actionPerformed(ActionEvent e) {
		ch.start();
		}
}
