package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class ProductOfDoublesVisitor implements IAlgo<Integer,Integer,Object> {

	@Override public Integer emptyCase(LRStruct<Integer> host, Object _) {
		return 1;
	}

	@Override public Integer nonEmptyCase(LRStruct<Integer> host, Object _) {
		return 2 * host.getDatum() * host.getRest().execute(this, _);
	}
	
	public static void main(String[] args) {
		LRStruct<Integer> list = new LRStruct<Integer>();
		IAlgo<Integer,Integer,Object> v = new ProductOfDoublesVisitor();
		System.out.println("Answer for "+list+" is "+list.execute(v,null));
		list.insertFront(3).insertFront(2).insertFront(1);
		System.out.println("Answer for "+list+" is "+list.execute(v,null));
		list.removeFront(); list.removeFront(); list.removeFront();
		list.insertFront(-4).insertFront(3).insertFront(2);
		System.out.println("Answer for "+list+" is "+list.execute(v,null));
	}
}
