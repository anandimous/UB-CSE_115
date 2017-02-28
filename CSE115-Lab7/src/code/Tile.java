package code;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

public class Tile implements ActionListener {

private JFrame _j;
public Tile(JFrame frame){
    _j = frame;
}
public void actionPerformed (ActionEvent e) {     

    JFrame frame2 = new JFrame("Keybricks");


    frame2.setVisible(true);
    frame2.setSize(600,600);
    frame2.setLocationRelativeTo(null);
    
    JPanel panel = new JPanel();
    frame2.add(panel);
           
    _j.setVisible(false); //This creates a new game frame

    GridLayout experimentLayout = new GridLayout(4,1);

            panel.setLayout(experimentLayout);

            JButton b;
    		b = new JButton("a");
    		b.addActionListener(new eventhandler(panel,b));
            
    		JButton ba;
    		ba = new JButton("b");
    		ba.addActionListener(new eventhandler(panel,ba));
    		
    		JButton bs;
    		bs = new JButton("c");
    		bs.addActionListener(new eventhandler(panel,bs));
    		
    		JButton bd;
    		bd = new JButton("d");
    		bd.addActionListener(new eventhandler(panel,bd));
    		
            panel.add(b);
            panel.add(ba);
            panel.add(bs);
            panel.add(bd);
}
}