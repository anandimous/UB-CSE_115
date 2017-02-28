package trees;

import queues.EmptyQueueException;
import queues.IQueue;

/*
 * MIN-HEAP
 */

@SuppressWarnings("unchecked")
public class HeapByCompositionWithArray<E extends Comparable<E>> implements queues.IQueue<E>{
	
	private static final int ROOT = 1;
	private E[] _store;
	private int _size;
	
	public HeapByCompositionWithArray() {
		_store = (E[]) (new Comparable[10]);
		_size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return _size == 0;
	}
	
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot peek an empty queue");
		}
		return _store[ROOT];
	}

	@Override
	public void enqueue(E item) {
		if (_size == _store.length - 1) {
			resize(2 * _store.length);
		}
		_size++;
		_store[_size] = item;
		percolateUp(_size);
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue");
		}
		_store[0] = _store[ROOT]; // use _heap[0] rather than temp variable
		_store[ROOT] = _store[_size];
		pushDown(ROOT);
		_size--;
		return _store[0];
	}

	private void resize(int newSize) {
		E[] temp = (E[]) (new Comparable[newSize]);
		for (int i=1; i<_store.length; i++) {
			temp[i] = _store[i];
		}
		_store = temp;
	}

	private void pushDown(int i) {
		if (i <= _size) {
			E left = _store[getLeft(i)];
			E right = _store[getRight(i)];
			E root = _store[i];
			if (getLeft(i)<=_size && left.compareTo(right) < 0) {
				if (left.compareTo(root) < 0) { // push root down on left
					_store[getLeft(i)] = root;
					_store[i] = left;
					pushDown(getLeft(i));
				}
			}
			else {
				if (getRight(i)<=_size && right.compareTo(root) < 0) { // push root down on right
					_store[getRight(i)] = root;
					_store[i] = right;
					pushDown(getRight(i));
				}
			}
		}
	}

	private void percolateUp(int i) {
		if (i>ROOT) {
			E parent = _store[getParent(i)];
			E root = _store[i];
			if (root.compareTo(parent) < 0) {
					_store[getParent(i)] = root;
					_store[i] = parent;
					percolateUp(getParent(i));
			}
		}
	}

	private int getParent(int i) { return i/2; }
	
	private int getRight(int i) { return 2*i+1; }
	
	private int getLeft(int i) { return 2*i; }

	@Override
	public String toString() {
//		System.out.println(" *** "+_size+" --> " + Arrays.toString(_store));
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (int i=1; i <= _size; i++) {
			sb.append(_store[i].toString());
			sb.append(", ");
		}
		if (sb.length() > 2) {
			sb.delete(sb.length()-2, sb.length());
		}
		sb.append(']');
		return sb.toString();
	}
	
	@Override public String name() {
		return "PQ(HEAP-array)";
	}

	public static void main(String[] args) {
		IQueue<Integer> h = new HeapByCompositionWithBRStruct<Integer>();
		int [] values = {10,20,15,5,7,2,14,19,3,6,9,1,34};
		for (int i=0; i<values.length; i++) {
			h.enqueue(values[i]);
		}
		System.out.println("\t\tBEFORE: "+h);
		for (int i=0; i<values.length; i++) {
			System.out.print("DEQUEUE: "+h.dequeue());
			System.out.println("\t AFTER: "+h);
		}
	}
	
	
}
