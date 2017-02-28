package queues;

import java.util.ArrayList;

/**
 * A simple time-ordered queue, defined by composition with an LRStruct<E>
 * @author Carl Alphonce
 */
public class PriorityQueue<K extends Comparable<K>,V> {

	private ArrayList<Pair<K,V>> _list;

	public PriorityQueue() {
		_list = new ArrayList<Pair<K,V>>();
	}
	
	// assume later in order ==> higher priority
	// ("high" values close to front of priority queue)
//	public void enqueue(Pair<K,V> item) {
//		int i = 0;
//		for ( ; i<_list.size(); i++) {
//			if (item.key.compareTo(_list.get(i).key) > 0) {
//				break;
//			}
//		}
//		_list.add(i, item);
//	}

	public Pair<K,V> dequeue() {
		if (_list.isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue an empty queue.");
		}
		else {
			return _list.remove(0);
		}
	}
	
	public Pair<K,V> peek() {
		if (_list.isEmpty()) {
			throw new EmptyQueueException("Cannot peek an empty queue.");
		}
		else {
			return _list.get(0);
		}
	}

	@Override public String toString() { return _list.toString(); }
	
	public void enqueue(Pair<K,V> p) {
		int index = 0;
		while (index < _list.size() && _list.get(index).key.compareTo(p.key) >= 0 ) {
			index++;
		}
		_list.add(index,p);
	}

	public static void main(String[] args) {
			PriorityQueue<Integer,String> q = new PriorityQueue<Integer,String>();
			q.enqueue(new Pair<Integer,String>(5,"Fred"));
			System.out.println(q);
			q.enqueue(new Pair<Integer,String>(7,"Wilma"));
			System.out.println(q);
			q.enqueue(new Pair<Integer,String>(3,"Pebbles"));
			System.out.println(q);
			q.enqueue(new Pair<Integer,String>(6,"Dino"));
			System.out.println(q);
			q.enqueue(new Pair<Integer,String>(7,"Betty"));
			System.out.println(q);
	}
	
}
