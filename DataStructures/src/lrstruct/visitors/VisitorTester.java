package lrstruct.visitors;

import lrstruct.LRStruct;

public class VisitorTester {

	public static void main(String[] args) {
	}
	
	public static void ex1() {
		LRStruct<String> names = new LRStruct<String>();
//		names.insertFront("Fred").insertFront("Wilma").insertFront("Pebbles");
//		names.insertFront("Betty").insertFront("Barney").insertFront("BamBam");
		LengthVisitor<String> visitor = new LengthVisitor<String>();
		System.out.print("The length of the list: "+names);
		System.out.println(" is "+names.execute(visitor, null));
	}

	public static void ex2() {
		LRStruct<Integer> list = new LRStruct<Integer>();
		list.insertFront(13).insertFront(7).insertFront(2);
		SumVisitor visitor = new SumVisitor();
		System.out.print("The sum of the items is in the list: "+list);
		System.out.println(" is "+list.execute(visitor, null));
	}
}
