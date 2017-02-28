package example1;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import code.Properties;
import code.barnyard.Background;
import engine.Game;

public class BarnYard {
	private Game _game;
	private JFrame FRAME = null;
	private JPanel PANEL = null;

	private int _ents;
	
	private static int _numOfTerrariums = 0;

	public BarnYard() {
		if(_numOfTerrariums + 1 > Properties.TERRARIUM_LIMIT){
			throw new Error("YOU OPENED THE MAX NUMBER OF BARNYARDS");
		}
		
		// create the game
		// System.setProperties(System.getProperties().getProperty("sun.java2d.opengl=True"));

		_game = new Game(Properties.SCREEN_WIDTH, Properties.SCREEN_HEIGHT,
				Properties.FRAMES_PER_SECOND, false);

		// set up the background
		_game.addEntity(new Background(), Properties.BACKGROUND_LAYER);

		_ents = 0;
		
		_numOfTerrariums++;
	}
	
	public void addButton(JButton b) {
		if (FRAME == null) {
			FRAME = new JFrame("Chicken controller");
			FRAME.getContentPane().setLayout(new BoxLayout(FRAME.getContentPane(),BoxLayout.Y_AXIS));
			FRAME.getContentPane().add(b);
			b.setAlignmentX(Component.CENTER_ALIGNMENT);
			PANEL = new JPanel();
			PANEL.setLayout(new GridLayout(0,2));
			FRAME.getContentPane().add(PANEL);
			FRAME.setVisible(true);
			FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		else {
			PANEL.add(b);
		}
		FRAME.pack();
	}

	private void addCritter(Critter c) {
		if (_ents < Properties.CRITTER_LIMIT) {
			_game.addEntity(c, Properties.CRITTER_LAYER);
			_ents++;
		}else{
			System.err.println("You have added the maximum number of objects!");
		}
	}

	public void addButterfly(Butterfly b) {
		addCritter(b);
	}

	public void addPig(Pig p) {
		addCritter(p);
	}

	public void addChicken(Chicken c) {
		addCritter(c);
	}
}
