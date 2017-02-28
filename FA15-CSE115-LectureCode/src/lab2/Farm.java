package lab2;

public class Farm {

	public Farm() {
		example1.BarnYard by;
		by = new example1.BarnYard();
		example1.Chicken c;
		c = new example1.Chicken();
		c.start();
		by.addChicken(c);
	}

}
