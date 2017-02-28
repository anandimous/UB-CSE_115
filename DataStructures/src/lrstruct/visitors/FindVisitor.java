package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class FindVisitor<E extends Comparable<E>> implements IAlgo<LRStruct<E>,E,E> {
	@Override
	public LRStruct<E> emptyCase(LRStruct<E> host, E arg) {
		return host;
	}
	@Override
	public LRStruct<E> nonEmptyCase(LRStruct<E> host, E arg) {
		if (arg.compareTo(host.getDatum()) < 0) {
			return host;
		}
		else {
			return host.getRest().execute(this, arg);
		}
	}
}
