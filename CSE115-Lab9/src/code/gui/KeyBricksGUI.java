package code.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.fileIO.FileIO;
import code.model.KeyBricksModel;
import code.model.Observer;
import eventhandler.Myeventhandler;

public class KeyBricksGUI extends FileIO implements ActionListener, Runnable, Observer {

	private KeyBricksModel _model;
	private JPanel _boardPanel;
	private JFrame _window;
	
	
	public KeyBricksGUI(KeyBricksModel m) {
		_model = m;
		_model.setObserver(this);
	}
	
	@Override public void run() {
		_window = new JFrame("KeyBricks - Lab 9");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.getContentPane().setLayout(new FlowLayout());
		_window.setFocusable(true);
		_window.setFocusTraversalKeysEnabled(false);

		KeyPressHandler keyHandler = new KeyPressHandler(_model);
		_window.addKeyListener(keyHandler);

		createAndPopulateBoard();

		_window.add(_boardPanel);
		_window.pack();
		_window.setVisible(true);
	}

	public void createAndPopulateBoard() {
		_boardPanel = new JPanel();
		_boardPanel.setFocusable(false);
		_boardPanel.setLayout(new GridLayout(KeyBricksModel.ROWS, KeyBricksModel.COLS));
		
		javax.swing.JLabel label;
		label = new javax.swing.JLabel();
		label.setText("<HTML><body><H1>Note</H1><p>The restore button restores the previous game configuration correctly," + "<br>however, I am unable to update the GUI as desired. Please consider.<p></body></HTML>");
		_window.add(label);
		
		JButton b1;
		b1 = new JButton("SAVE");
		b1.addActionListener(this);
		_window.add(b1);
		
		JButton bb1;
		bb1 = new JButton("RESTORE");
		bb1.addActionListener(new Myeventhandler(_model, _boardPanel, _window));
		_window.add(bb1);

		for (int c=0; c<KeyBricksModel.COLS; c++) {
			for (int r=0; r<KeyBricksModel.ROWS; r++) {
				JButton b = new JButton();
				b.setOpaque(true);
				b.setFocusable(false);
				b.setPreferredSize(new Dimension(100, 100));  // so board stays same size regardless of letters
				b.setFont(b.getFont().deriveFont(Font.BOLD, b.getFont().getSize()*4));
				_boardPanel.add(b);
			}
		}
		update();
	}
	
	@Override public void update() {
		for (int c=0; c<KeyBricksModel.COLS; c++) {
			for (int r=0; r<KeyBricksModel.ROWS; r++) {
				JButton b = (JButton) _boardPanel.getComponent(r*KeyBricksModel.COLS+c);
				Character ch = _model.get(c,r).getCharacter();
				b.setBackground(_model.get(c,r).getColor());
				b.setText(ch.toString());
			}
		}
		_window.repaint();  // make sure board is updated visually
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s1="";
		String ch1;
		String ch2;
		String ch3;
		String ch4;
		String ch5;
		
		for (int c=0; c<KeyBricksModel.COLS; c++) {
			for (int r=0; r<KeyBricksModel.ROWS; r++) {
				
				Character ch = _model.get(c,r).getCharacter();
				s1=s1+ch;
				
				if(_model.get(c,r).getColor()==Color.RED){
					
					ch1="R";
					s1=s1+ch1;
					
				}
				
				else if(_model.get(c,r).getColor()==Color.GREEN){
					
					ch2="G";
					s1=s1+ch2;
				
			}
				else if(_model.get(c,r).getColor()==Color.YELLOW){
					
					ch3="Y";
					s1=s1+ch3;
				}
				
				else if(_model.get(c,r).getColor()==Color.BLUE){
					
					ch4="B";
					s1=s1+ch4;
				
				}
				
				else if(_model.get(c,r).getColor()==Color.BLACK){
					
					ch5="K";
					s1=s1+ch5;
					
				}
		
		
	}

	}
		
		System.out.println(KeyBricksGUI.writeStringToFile("anandi.kbr", s1));
		System.out.println(KeyBricksGUI.readFileToString("anandi.kbr"));
		
	}
	}
