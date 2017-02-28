package code;

import javax.swing.SwingUtilities;

import code.gui.KeyBricksGUI;
import code.model.KeyBricksModel;

public class Driver {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new KeyBricksGUI(new KeyBricksModel()));
	}
}
