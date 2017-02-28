package code.gui;

import code.model.Model;

public class Application implements Runnable {

	@Override
	public void run() {
		Model m = new Model();
		GUI g1 = new GUI(m);
		GUI g2 = new GUI(m);
	}

}
