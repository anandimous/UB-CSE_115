package code;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import code.eventhandler.Num;


public class Game implements Runnable{

	
	public Game(){
	
		
		
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		javax.swing.JFrame fr;
		fr = new javax.swing.JFrame("A container");
		
		javax.swing.JPanel jp;
		jp = new javax.swing.JPanel();
		fr.add(jp);
		fr.setVisible(true);
		
		javax.swing.JButton b;
		b = new javax.swing.JButton("START");
		b.addActionListener(new eventhandler(fr));
		
		javax.swing.JLabel label;
		label = new javax.swing.JLabel();
		label.setText("<HTML><body><H1>Instructions</H1><p>Click the 'start' button to start the game" + "<br>Click as many of the red buttons as you can before time runs out!<p></body></HTML>");
		
		jp.add(b);
		jp.add(label);
		jp.setVisible(true);
		
						 
		Font f = b.getFont();
		Font myFont = f.deriveFont(Font.BOLD, f.getSize()*8);
		b.setFont(myFont);
		 
	}
	
	public static void main(String [] args)
	 {

	        ActionListener actionListener = new ActionListener() {
	            public void actionPerformed(ActionEvent actionEvent) {
	            	Game ea = new code.Game();
	            	ea.run();
	            	System.exit(0);
	            	
	            }
	        };
	        Timer timer = new Timer( 10000, actionListener );
	        
	        timer.stop();
	        
	    }

}
