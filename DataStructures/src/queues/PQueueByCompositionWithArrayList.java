package queues;

import java.util.ArrayList;

/**
 * A simple time-ordered queue, defined by composition with an ArrayList<E>
 * @author Carl Alphonce
 */
public class PQueueByCompositionWithArrayList<E extends Comparable<E>> implements IQueue<E> {

	private ArrayList<E> _list;

	public PQueueByCompositionWithArrayList() {
		_list = new ArrayList<E>();
	}
	
	@Override
	public void enqueue(E item) {
		int i = 0;
		while (i < _list.size() && _list.get(i).compareTo(item)<0) {
			i = i + 1;
		}
		_list.add(i, item);
	}

	@Override
	public E dequeue() {
		if (_list.isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue.");
		}
		else {
			return _list.remove(0);
		}
	}
	
	@Override
	public E peek() {
		if (_list.isEmpty()) {
			throw new EmptyQueueException("Cannot peek an empty queue.");
		}
		else {
			return _list.get(0);
		}
	}
	
	@Override
	public boolean isEmpty() {
		return _list.isEmpty();
	}

	@Override public String toString() { return _list.toString(); }

	@Override public String name() {
		return "PQ(ArrayList)";
	}
}
