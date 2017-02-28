package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class SumVisitor implements IAlgo<Integer,Integer,Void> {
	@Override public Integer emptyCase(LRStruct<Integer> host, Void __) {
		return 0;
	}
	@Override public Integer nonEmptyCase(LRStruct<Integer> host, Void __) {
		return host.getDatum() + host.getRest().execute(this, __);
	}
	
	public static void main(String[] args) {
		LRStruct<Integer> list;
		list = new LRStruct<Integer>();
		list.insertFront(33).insertFront(17).insertFront(50);
		System.out.println(list);
		System.out.println(list.execute(new SumVisitor(), null));
	}
}
