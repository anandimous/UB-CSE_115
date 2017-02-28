package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class LengthVisitor<E> implements IAlgo<Integer,E,Void> {

	@Override public Integer emptyCase(LRStruct<E> host, Void _) {
		return 0;
	}

	@Override public Integer nonEmptyCase(LRStruct<E> host, Void _) {
		return 1 + host.getRest().execute(this, _);
	}

}
