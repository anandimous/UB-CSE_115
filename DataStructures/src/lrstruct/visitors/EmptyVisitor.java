package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class EmptyVisitor<E> implements IAlgo<Boolean,E,Void> {
	@Override
	public Boolean emptyCase(LRStruct<E> host, Void _) {
		return true;
	}
	@Override
	public Boolean nonEmptyCase(LRStruct<E> host, Void _) {
		return false;
	}
}
