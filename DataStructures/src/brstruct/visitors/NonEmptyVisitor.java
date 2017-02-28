package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class NonEmptyVisitor<E> implements IAlgo<Boolean,E,Object> {
	@Override public Boolean emptyCase(BRStruct<E> host, Object _) { return false; }
	@Override public Boolean nonEmptyCase(BRStruct<E> host, Object _) { return true; }
}
