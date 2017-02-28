package code;


public class Application implements Runnable {

	public Application() {
		// do nothing here
	}
	
	@Override
	public void run() {
		// do your initialization here
		
		
		example1.BarnYard by;
		by = new example1.BarnYard();
		
		javax.swing.JButton b;
		b = new javax.swing.JButton("Add Chicken");
		b.addActionListener(new eventhandler(by));
		by.addButton(b);
		
		
		
		
	}	
	}

	

