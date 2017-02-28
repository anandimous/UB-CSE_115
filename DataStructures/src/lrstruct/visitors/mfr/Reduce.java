package lrstruct.visitors.mfr;

import functions.BinaryFunction;
import functions.Product;
import functions.Sum;
import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class Reduce<O,E> implements IAlgo<O, E, BinaryFunction<O,E,O>> {

	@Override public O emptyCase(LRStruct<E> host, BinaryFunction<O,E,O> f) {
		return f.identity();
	}

	@Override public O nonEmptyCase(LRStruct<E> host, BinaryFunction<O,E,O> f) {
		return f.apply(host.getDatum(),host.getRest().execute(this,f));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		LRStruct<Integer> list = new LRStruct<Integer>();
		list.insertFront(2).insertFront(5).insertFront(3).insertFront(4);
		Reduce<Integer,Integer> r = new Reduce<Integer,Integer>();
		Sum s = new Sum();
		Product p = new Product();
		System.out.println("Reducing "+list+" by addition yields "+list.execute(r, s));
		System.out.println("Reducing "+list+" by multiplication yields "+list.execute(r, p));
		LRStruct<Integer> list2 = new LRStruct<Integer>();
		list2.insertFront(14).insertFront(-2).insertFront(54).insertFront(375).insertFront(154);
		System.out.println("Reducing "+list2+" by addition yields "+list2.execute(r, s));
		System.out.println("Reducing "+list2+" by multiplication yields "+list2.execute(r, p));
	}
	
}
