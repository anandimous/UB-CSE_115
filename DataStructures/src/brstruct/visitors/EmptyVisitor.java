package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class EmptyVisitor<E> implements IAlgo<Boolean,E,Object> {
	@Override public Boolean emptyCase(BRStruct<E> host, Object _) { return true; }
	@Override public Boolean nonEmptyCase(BRStruct<E> host, Object _) { return false; }
}
