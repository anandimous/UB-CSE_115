package brstruct.visitors.traversals;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;
import queues.AQueue;

public class PreOrderVisitor<E extends Comparable<E>> implements IAlgo<Void,E,AQueue<E>> {

	@Override public Void emptyCase(BRStruct<E> host, AQueue<E> arg) {
		return null;
	}

	@Override public Void nonEmptyCase(BRStruct<E> host, AQueue<E> q) {
		q.enqueue(host.getDatum());
		host.getLeft().execute(this, q);
		host.getRight().execute(this, q);
		return null;
	}

}
