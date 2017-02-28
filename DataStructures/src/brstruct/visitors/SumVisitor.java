package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class SumVisitor implements IAlgo<Integer,Integer,Object> {

	@Override
	public Integer emptyCase(BRStruct<Integer> host, Object arg) {
		return 0;
	}

	@Override
	public Integer nonEmptyCase(BRStruct<Integer> host, Object _) {
		return host.getDatum() + host.getLeft().execute(this,_) + host.getRight().execute(this,_);
	}

}
