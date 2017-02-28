package brstruct.visitors.traversals;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;
import queues.AQueue;

public class InOrderVisitor<E extends Comparable<E>> implements IAlgo<Void,E,AQueue<E>> {

	@Override public Void emptyCase(BRStruct<E> host, AQueue<E> q) {
		return null;
	}

	@Override public Void nonEmptyCase(BRStruct<E> host, AQueue<E> q) {
		host.getLeft().execute(this, q);
		q.enqueue(host.getDatum());
		host.getRight().execute(this, q);
		return null;
	}
}
