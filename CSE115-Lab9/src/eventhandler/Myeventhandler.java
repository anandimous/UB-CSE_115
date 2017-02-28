package eventhandler;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.fileIO.FileIO;

import code.model.KeyBricksModel;
import code.model.Observer;

public class Myeventhandler extends FileIO implements ActionListener, Observer{

	private JPanel boardPanel;
	private JFrame window;
	private KeyBricksModel _model;
	
	public Myeventhandler(KeyBricksModel m, JPanel _boardPanel, JFrame _window) {
		boardPanel=_boardPanel;
		window=_window;
		_model=m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Scanner scan = null;
		String contents = "";
		try {
			scan = new Scanner(new File("anandi.kbr"));
			while (scan.hasNextLine()) {
				contents = contents + scan.nextLine();
			}
 		} catch (FileNotFoundException e1) {
			System.err.println("File not found: "+"anandi.kbr");
		}
		finally {
			scan.close();
		}
		
		 Character ch = null;
		 String s="R";
		 String s1="G";
		 String s2="B";
		 String s3="Y";
		 String s4="K";
		 char[] ch1 = new char[50];
		 contents.getChars(0, 50, ch1, 0);
		 
		 for (int c=0; c<KeyBricksModel.COLS; c++) {
				for (int r=0; r<KeyBricksModel.ROWS; r++) {
					JButton b = new JButton();
					b.setOpaque(true);
					b.setFocusable(false);
					b.setPreferredSize(new Dimension(100, 100));  // so board stays same size regardless of letters
					b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*4));
					boardPanel.add(b);
				}
			}
			update();
		
		
		 for(int z=0; z<50; z++){
			ch=ch1[z];
			
			System.out.print(ch);
		 
		
		for (int c=0; c<KeyBricksModel.COLS; c++) {
			for (int r=0; r<KeyBricksModel.ROWS; r++) {
				
				
				JButton b = (JButton) boardPanel.getComponent(r*KeyBricksModel.COLS+c);
				
				if(ch.equals(s)){
					b.setBackground(Color.RED);	
				}
				else if(ch.equals(s1)){
					b.setBackground(Color.GREEN);	
				}
				else if(ch.equals(s2)){
					b.setBackground(Color.BLUE);	
				}
				else if(ch.equals(s3)){
					b.setBackground(Color.YELLOW);	
				}
				else if(ch.equals(s4)){
					b.setBackground(Color.BLACK);	
				}
				
				
				b.setText(ch.toString());
			}
		}
		 }
		
		window.repaint(); 
	}
	@Override public void update() {
		for (int c=0; c<KeyBricksModel.COLS; c++) {
			for (int r=0; r<KeyBricksModel.ROWS; r++) {
				JButton b = (JButton) boardPanel.getComponent(r*KeyBricksModel.COLS+c);
				Character ch = _model.get(c,r).getCharacter();
				b.setBackground(_model.get(c,r).getColor());
				b.setText(ch.toString());
			}
		}
		window.repaint();  // make sure board is updated visually
	}
	

}
