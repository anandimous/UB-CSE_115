package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class SizeVisitor<E> implements IAlgo<Integer,E,Object> {

	@Override
	public Integer emptyCase(BRStruct<E> host, Object arg) {
		return 0;
	}

	@Override
	public Integer nonEmptyCase(BRStruct<E> host, Object _) {
		return 1 + host.getLeft().execute(this,_) + host.getRight().execute(this,_);
	}

}
