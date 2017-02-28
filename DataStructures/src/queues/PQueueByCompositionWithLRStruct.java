package queues;

import lrstruct.LRStruct;
import lrstruct.visitors.EmptyVisitor;
import lrstruct.visitors.FindVisitor;

/**
 * A simple time-ordered queue, defined by composition with an LRStruct<E>
 * @author Carl Alphonce
 */
public class PQueueByCompositionWithLRStruct<E extends Comparable<E>> implements IQueue<E> {
	
	private final FindVisitor<E> FV;
	private LRStruct<E> _front;

	public PQueueByCompositionWithLRStruct() {
		_front = new LRStruct<E>();
		FV = new FindVisitor<E>();
	}
	
	@Override
	public void enqueue(E item) {
		_front.execute(FV, item).insertFront(item);
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue.");
		}
		else {
			E item = _front.getDatum();
			_front = _front.getRest();
			return item;
		}
	}
	
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot peek an empty queue.");
		}
		else {
			return _front.getDatum();
		}
	}

	@Override
	public boolean isEmpty() {
		return _front.execute(new EmptyVisitor<E>(), null);
	}
	
	@Override public String toString() { return _front.toString(); }

	@Override public String name() {
		return "PQ(LRStruct)";
	}
}
