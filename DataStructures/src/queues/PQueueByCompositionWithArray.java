package queues;

import java.util.Arrays;

/**
 * A simple priority queue, defined by composition with E[]
 * @author Carl Alphonce
 */
public class PQueueByCompositionWithArray<E extends Comparable<E>> implements IQueue<E> {

	private E[] _store;
	private int _size;

	@SuppressWarnings("unchecked")
	public PQueueByCompositionWithArray() {
		_store = (E[]) (new Comparable[10]);
		_size = 0;
	}
	
	@Override
	public void enqueue(E item) {
		if (_size == _store.length - 1) {
			resize(2 * _store.length);
		}
		int i = 0;
		while (i < _size && _store[i].compareTo(item)<0) {
			i = i + 1;
		}
		for (int j=_size; j>i; j--) {
			_store[j] = _store[j-1];
		}
		_store[i] = item;
		_size++;
	}

	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
//		System.out.println("RESIZE");
		E[] temp = (E[]) (new Comparable[newSize]);
		for (int i=0; i<_store.length; i++) {
			temp[i] = _store[i];
		}
		_store = temp;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue.");
		}
		else {
			E temp = _store[0];
			for (int i=1; i<_size; i++) {
				_store[i-1] = _store[i];
			}
			_size--;
			_store[_size] = null;
			return temp;
		}
	}
	
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue.");
		}
		else {
			return _store[0];
		}
	}
	
	@Override
	public boolean isEmpty() {
		return _size == 0;
	}

	@Override public String toString() { return Arrays.toString(_store); }

	@Override public String name() {
		return "PQ(array)";
	}
}
