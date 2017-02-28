package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class LargestComparableVisitor<E extends Comparable<E>> implements IAlgo<E,E,Object> {
	@Override
	public E emptyCase(LRStruct<E> host, Object _) {
		// empty list does not have a largest element
		throw new IllegalStateException("Empty list does not have a largest element");
	}

	@Override
	public E nonEmptyCase(LRStruct<E> host, Object _) {
		return host.getRest().execute(new IAlgo<E,E,E>() {

			@Override
			public E emptyCase(LRStruct<E> host, E largest) {
				return largest;
			}

			@Override
			public E nonEmptyCase(LRStruct<E> host, E largest) {
				E newLargest = (largest.compareTo(host.getDatum())>0 ? largest : host.getDatum());
				return host.getRest().execute(this, newLargest);
			}
			
		},host.getDatum());
	}
}
