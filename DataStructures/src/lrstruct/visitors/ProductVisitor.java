package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class ProductVisitor implements IAlgo<Integer,Integer,Void> {
	@Override public Integer emptyCase(LRStruct<Integer> host, Void __) {
		return 1;  // identity of the operation
	}
	@Override public Integer nonEmptyCase(LRStruct<Integer> host, Void __) {
		return host.getDatum() * host.getRest().execute(this, __);
	}
	
	public static void main(String[] args) {
		LRStruct<Integer> list;
		list = new LRStruct<Integer>();
		list.insertFront(3).insertFront(7).insertFront(5);
		System.out.println(list);
		System.out.println(list.execute(new ProductVisitor(), null));
	}
	
}
