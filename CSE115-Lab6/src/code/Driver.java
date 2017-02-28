package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Driver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
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
