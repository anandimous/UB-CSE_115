package code;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JButton;

public class Game implements Runnable{


    @Override
    public void run() {
        // TODO Auto-generated method stub


        JFrame frame = new JFrame ("Game");
         frame.setVisible(true);
         frame.setSize(500,200);
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);




          JPanel panel = new JPanel();
          frame.add(panel);
          JButton button = new JButton("Start The Game");
          panel.add(button);
          button.addActionListener(new Tile(frame));
          
    }
}