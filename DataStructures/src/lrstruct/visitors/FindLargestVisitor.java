package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class FindLargestVisitor implements IAlgo<Integer, Integer, Integer> {

	@Override
	public Integer emptyCase(LRStruct<Integer> host, Integer hypothesis) {
		throw new IllegalStateException("An empty list has no largest element");
	}

	@Override
	public Integer nonEmptyCase(LRStruct<Integer> host, Integer hypothesis) {
		return host.getRest().execute(new FindLargestVisitorSimple(), host.getDatum());
	}
	
	public static void main(String[] args) {
		LRStruct<Integer> list = new LRStruct<Integer>();
		list.insertFront(5).insertFront(7).insertFront(1).insertFront(3);
		list.execute(new FindLargestVisitor(), null);
	}

}
