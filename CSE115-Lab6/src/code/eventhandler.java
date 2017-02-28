package code;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import code.eventhandler.Num;


public class eventhandler implements ActionListener{
	
	static javax.swing.JFrame fe;
	protected static ActionEvent e;
	public eventhandler(javax.swing.JFrame fo) {
		fe=fo;
	}

	public static class Example{
		    public static int x;
		    
		}
	
	public static class Num{
		public static int h;
	}
	
	public void actionPerformed(ActionEvent e) {
		
				
		javax.swing.JFrame k;
		k = new javax.swing.JFrame("Game");
		
		javax.swing.JPanel jp1;
		jp1 = new javax.swing.JPanel();
		k.add(jp1);
		k.setVisible(true);
			
		java.util.Random r = new Random();
		Example.x = r.nextInt(3);
		
		
				
		javax.swing.JButton n;
		n = new javax.swing.JButton("A");
		n.addActionListener(new Myeventhandler());
		
		javax.swing.JButton n1;
		n1 = new javax.swing.JButton("B");
		n1.addActionListener(new MyEventHandler1());
		
		javax.swing.JButton n2;
		n2 = new javax.swing.JButton("C");
		n2.addActionListener(new MyEventHandler2());
		
		for(int i=0;i<=1000;i++){
			
		if(Example.x == 0){
			
			n.setOpaque(false);
			n.setContentAreaFilled(false);
			
		}
		
		else if(Example.x == 1){
			
			n1.setOpaque(false);
			n1.setContentAreaFilled(false);
			
		}
		
		else if(Example.x == 2){
			
			n2.setOpaque(false);
			n2.setContentAreaFilled(false);
			
		}
		
		}
		
		
		jp1.add(n);
		jp1.add(n1);
		jp1.add(n2);
		jp1.setVisible(true);
		
		
		
		Font f1 = n.getFont();
		Font myFont1 = f1.deriveFont(Font.BOLD, f1.getSize()*8);
		n.setFont(myFont1);
		
		Font f2 = n1.getFont();
		Font myFont2 = f2.deriveFont(Font.BOLD, f2.getSize()*8);
		n1.setFont(myFont2);
		
		Font f3 = n2.getFont();
		Font myFont3 = f3.deriveFont(Font.BOLD, f3.getSize()*8);
		n2.setFont(myFont3);
		System.out.print(Num.h+1);	 		
	}
	
	public static void main(String [] args)
	 {

	        ActionListener actionListener = new ActionListener() {
	            public void actionPerformed(ActionEvent actionEvent) {
	            	Game ea = new code.Game();
	            	ea.run();
	            	eventhandler eaa = new code.eventhandler(fe);
	            	eaa.actionPerformed(e);
	            	System.exit(0);
	        		
	        		
	            }
	        };
	        Timer timer = new Timer( 10000, actionListener );
	        
	        timer.stop();
	        
	    }

			
}