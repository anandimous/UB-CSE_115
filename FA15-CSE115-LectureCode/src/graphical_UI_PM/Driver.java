package graphical_UI_PM;

import javax.swing.SwingUtilities;

public class Driver {
	// This is an in-line comment
	
	/* This is a block comment
	 * 
	 *  String is a class, defined in the package java.lang but we did 
	 *  not fully qualify the name when we used it because the java.lang
	 *  package is by default always imported.
	 *  
	 *  [ ] denote an array type (we'll talk more about this later)
	 *  
	 *  "A sequence of characters enclosed in double quotes" is a String.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Demo());
	}
}
