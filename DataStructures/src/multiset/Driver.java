package multiset;

import java.util.ArrayList;
import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		ArrayList<String> m = new ArrayList<String>();
		m.add("River");
		m.add("Mal");
		m.add("Jayne");
		m.add("Kaylee");
		m.add("Zoë");
		Iterator<String> it = m.iterator();
		System.out.println("Value is: ");
		System.out.println("Value is: "+it.next());
		System.out.println("Value is: "+it.next());
		m.remove("River");
		m.add("gljsfdkg");
		System.out.println("Value is: "+it.next());
	}
}
