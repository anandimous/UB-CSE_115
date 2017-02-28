package brstruct.visitors.traversals;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;
import queues.AQueue;

public class PostOrderVisitor<E extends Comparable<E>> implements IAlgo<Void,E,AQueue<E>> {

	@Override public Void emptyCase(BRStruct<E> host, AQueue<E> q) {
		return null;
	}

	@Override public Void nonEmptyCase(BRStruct<E> host, AQueue<E> jfahfjasdhfkjhdsajhsd) {
		host.getLeft().execute(this, jfahfjasdhfkjhdsajhsd);
		host.getRight().execute(this, jfahfjasdhfkjhdsajhsd);
		jfahfjasdhfkjhdsajhsd.enqueue(host.getDatum());
		return null;
	}
}
