package queues;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

/**
 * A simple time-ordered queue, defined by composition with an LRStruct<E>
 * @author Carl Alphonce
 */
public class QueueByCompositionWithLRStruct<E> implements IQueue<E> {

	private LRStruct<E> _front;
	private LRStruct<E> _back;

	public QueueByCompositionWithLRStruct() {
		_front = new LRStruct<E>();
		_back = _front;
	}
	
	@Override
	public void enqueue(E item) {
		_back.insertFront(item);
		_back = _back.getRest();
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
		return _front.execute(new IAlgo<Boolean,E,Object>() {
			@Override public Boolean emptyCase(LRStruct<E> host, Object arg) {
				return true;
			}
			@Override public Boolean nonEmptyCase(LRStruct<E> host, Object arg) {
				return false;
			}	
		}, null);
	}
	
	@Override public String toString() { return _front.toString(); }

	@Override public String name() {
		return "Q(LRStruct)";
	}
	
	public static void main(String[] args) {
		AQueue<Integer> q = new AQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		// give structure here
		q.dequeue();
		q.enqueue(3);
	}
}
