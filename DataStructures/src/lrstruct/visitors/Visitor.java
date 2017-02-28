package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class Visitor implements IAlgo<Integer,Integer,Object> {

	@Override public Integer emptyCase(LRStruct<Integer> host, Object _) {
	// DEFINE WHAT HAPPENS WHEN THE LIST IS EMPTY HERE

		return 0;

	}

	@Override public Integer nonEmptyCase(LRStruct<Integer> host, Object _) {
	// DEFINE WHAT HAPPENS WHEN THE LIST IS NOT EMPTY HERE

		return (host.getDatum()%2==0? 1 : 0) + host.getRest().execute(this,_);

	}
	
	public static void main(String[] args) {
		LRStruct<Integer> list;
		list = new LRStruct<Integer>();
		list.insertFront(3).insertFront(2).insertFront(1);
		System.out.println(list);
		System.out.println(list.execute(new Visitor(),null));
		list = new LRStruct<Integer>();
		list.insertFront(-4).insertFront(3).insertFront(-2);
		System.out.println(list);
		System.out.println(list.execute(new Visitor(),null));
	}
}
