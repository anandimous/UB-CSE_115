package code;

public class Example {
	
	/* 
	 * See the following page for a description of how command line arguments
	 * work in general for Java programs:
	 *   https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html
	 * 
	 * To supply command-line arguments in Eclipse, 
	 * 		Run -> Run configurations...
	 * 	    Select 'Java Application'
	 *      Click the 'new launch configuration' icon (towards upper left corner)
	 *      If the 'Main class' field is empty, click 'Search...' and Eclipse should
	 *          find a class with a main method
	 *      Click the 'Arguments' tab
	 *      Enter command line arguments in the 'Program arguments:' box
	 *      
	 * For example, if I enter the following in the 'Program arguments:' box,
	 *     Command line arguments are entered here!
	 * and click the 'Run' button (bottom right corner), the following output
	 * is produced:
	 *     args[0] is "Command".
	 *     args[1] is "line".
	 *     args[2] is "arguments".
	 *     args[3] is "are".
	 *     args[4] is "entered".
	 *     args[5] is "here!".
	 * 
	 */
	public static void main(String[] args) {
		for (int i=0; i<args.length; i++) {
			System.out.println("args["+i+"] is \""+args[i]+"\".");
		}
	}

}
