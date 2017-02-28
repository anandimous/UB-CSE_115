package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class DoubleVisitor implements IAlgo<Object,Integer,Object> {

	@Override
	public Object emptyCase(BRStruct<Integer> host, Object arg) {
		return null;
	}

	@Override
	public Object nonEmptyCase(BRStruct<Integer> host, Object _) {
		host.setDatum(host.getDatum() * 2);
		host.getLeft().execute(this,_);
		host.getRight().execute(this,_);
		return null;
	}

}
