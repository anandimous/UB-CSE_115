package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class SearchVisitor<E> implements IAlgo<Boolean,E,E> {
	@Override
	public Boolean emptyCase(LRStruct<E> host, E arg) {
		return false;
	}
	@Override
	public Boolean nonEmptyCase(LRStruct<E> host, E arg) {
		return host.getDatum().equals(arg) || host.getRest().execute(this,arg);
		
//		if (host.getDatum().equals(arg)) {
//			return true;
//		}
//		else {
//			return host.getRest().execute(this,arg);
//		}
	}
}
