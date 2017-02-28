package graphical_UI;

import javax.swing.SwingUtilities;

public class Driver {

	// This is a one-line comment
	
	/* This is a block comment
	 * 
	 * The main method is the standard entry point for a Java program.
	 * 
	 * String is a class defined in the package java.lang but it does
	 * not need to be fully qualified, because all classes in java.lang
	 * are by default imported.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Demo());
	}
}
