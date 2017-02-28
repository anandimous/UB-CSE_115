package drivers;

import java.util.ArrayList;

public class Driver2 {

	public static void main(String[] args) {
		Driver2 d = new Driver2();
		System.out.println(d.question3(5, 3));
	}
	
	public ArrayList<Integer> question3(int x, int y) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("list is "+list);
		for (int i=0; i<=y; i++) {
			list.add(x+i);
			System.out.println("x: " + x+" y: "+y+" i: "+i+ " (x+i): "+(x+i)+" and list is "+list);
		}
		return list;
	}
	
}
