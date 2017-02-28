package trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

import queues.AQueue;
import stack.IStack;
import stack.Stack;
import stack.Stack2;

@SuppressWarnings("unchecked")
public class BSTArray<E extends Comparable<E>> implements Iterable<E> {
	
	private static final int ROOT = 1;

	private Entry<E>[] _store;
	private int _height;
	private int _size;

	public BSTArray() {
		_height = -1;
		_size = 0;
		_store = (Entry<E>[]) (new Entry[requiredLength()]);
	}
	
	public int size() {
		return _size;
	}

	public BSTArray<E> insert(E item) {
		int tree = find(item,ROOT);
		if (isEmpty(tree)) { // at empty tree
			_store[tree] = new Entry<E>(item); 
			_size++;
		}
		if (inBottomLayer(tree)) {  // new item added on bottom layer - increase _height
			_height++;
			int reqArrayLength = requiredLength();
			if ( reqArrayLength > _store.length) {
				resize(reqArrayLength);
			}
		}
		return this;
	}
	
	public boolean remove(E item) {
		int mainTree = find(item,ROOT);
		if (isEmpty(mainTree)) {
			return false;
		}
		int rightSubTreeOfMainTree = getRight(mainTree); 
		if (isEmpty(rightSubTreeOfMainTree)) {
			pullUpLeft(mainTree,getLeft(mainTree));			
		}
		else {
			int smallestTree = leftmost(rightSubTreeOfMainTree, rightSubTreeOfMainTree);
			_store[mainTree] = _store[smallestTree];
			pullUpRight(smallestTree, getRight(smallestTree));
		}
		return true;
	}
	
	private int leftmost(int tree, int parent) {
		if (isEmpty(tree)) {
			return parent;
		}
		else {
			return leftmost(getLeft(tree), tree);
		}
	}

	private void pullUpLeft(int mainTree, int childToRaise) {
//		System.out.println(this);
		if (! inBottomLayer(mainTree)) {
			_store[mainTree] = _store[childToRaise];
			pullUpLeft(getRight(mainTree),getRight(childToRaise));
			pullUpLeft(getLeft(mainTree),getLeft(childToRaise));
		}
 	}

	private void pullUpRight(int mainTree, int childToRaise) {
		if (! inBottomLayer(mainTree)) {
			_store[mainTree] = _store[childToRaise];
			pullUpRight(getLeft(mainTree),getLeft(childToRaise));
			pullUpRight(getRight(mainTree),getRight(childToRaise));
		}
 	}

	public boolean isEmpty() {
		return isEmpty(ROOT);
	}

	public boolean member(E item) {
		int tree = find(item,ROOT);
		return !isEmpty(tree);
	}
	
	@Override public Iterator<E> iterator() {
		return new BSTInOrderIterator();
	}

	public AQueue<E> preOrder() {
		AQueue<E> q = new AQueue<E>();
		preVisit(ROOT, q);
		return q;
	}
	
	public AQueue<E> inOrder() {
		AQueue<E> q = new AQueue<E>();
		inVisit(ROOT, q);
		return q;
	}
	
	public AQueue<E> postOrder() {
		AQueue<E> q = new AQueue<E>();
		postVisit(ROOT, q);
		return q;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		toString(ROOT,sb);
		return sb.toString();
	}
	
	/*
	 * PRIVATE METHODS
	 */
	
	private boolean isEmpty(int i) {
		return _store[i] == null;
	}

	private void toString(int index, StringBuffer sb) {
		if (_store[index] == null) {
			sb.append("[]");
		}
		else {
			sb.append("[");
			toString(2*index,sb);
			sb.append(" ");
			sb.append(getDatum(index));
			sb.append(" ");
			toString(2*index+1,sb);
			sb.append("]");
		}
	}

	private void preVisit(int tree, AQueue<E> q) {
		if (!isEmpty(tree)) {
			q.enqueue(getDatum(tree));
			preVisit(getLeft(tree),q);
			preVisit(getRight(tree),q);
		}
	}
	
	private void inVisit(int tree, AQueue<E> q) {
		if (!isEmpty(tree)) {
			inVisit(getLeft(tree),q);
			q.enqueue(getDatum(tree));
			inVisit(getRight(tree),q);
		}
	}



	private void postVisit(int tree, AQueue<E> q) {
		if (!isEmpty(tree)) {
			postVisit(getLeft(tree),q);
			postVisit(getRight(tree),q);
			q.enqueue(getDatum(tree));
		}
	}

	private boolean inBottomLayer(int index) {
		return index >= Math.pow(2,_height+1);
	}
	
	private int requiredLength() {
		return (int) Math.round(Math.pow(2,_height+2));
	}
	
	private int find(E item, int i) {
		if (isEmpty(i)) { // at empty, not found!
			return i;
		}
		if (item.compareTo(getDatum(i)) < 0) { // in left?
			return find(item, getLeft(i));
		}
		else if (item.compareTo(getDatum(i)) > 0) { // in right?
			return find(item, getRight(i));
		}
		else { // found - a duplicate!
			return i;
		}
	}

	private int getRight(int i) { return 2*i+1; }
	private int getLeft(int i) { return 2*i; }
	private E getDatum(int i) { return _store[i].key; }	

	private void resize(int newSize) {
		Entry<E>[] temp = (Entry<E>[]) (new Entry[newSize]);
		for (int i=1; i<_store.length; i++) {
			temp[i] = _store[i];
		}
		_store = temp;
	}

	private class Entry<T> {
		public T key;
		public Entry(T k) {
			key = k;
		}
		@Override
		public String toString() {
			return key.toString();
		}
	}

	private class BSTInOrderIterator implements Iterator<E> {
		
		private IStack<Integer> _stack;
		
		public BSTInOrderIterator() {
			_stack = new Stack<Integer>();
			leftPusher(ROOT, _stack);
		}
		@Override public boolean hasNext() {
			return !_stack.isEmpty();
		}
		
		@Override public E next() {
			if (hasNext()) {
				int current = _stack.pop();
				leftPusher(getRight(current), _stack);
				return getDatum(current);
			}
			else {
				throw new NoSuchElementException();
			}
		}
		@Override
		public String toString() {
			String answer = "[ TOP--> ";
			Stack2<Integer> s = new Stack2<Integer>();
			while (!_stack.isEmpty()) {
				Integer tree = _stack.pop();
				s.push(tree);
				answer = answer + " " + getDatum(tree);
			}
			while (!s.isEmpty()) { _stack.push(s.pop()); }
			return answer + "]";
		}
		@Override public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private void leftPusher(int tree, IStack<Integer> stack) {
		if (isEmpty(tree)) {
		}
		else {
			stack.push(tree);
			leftPusher(getLeft(tree), stack);
		}
	}


}















