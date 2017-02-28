package stack;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

/**
 * A stack, defined by composition with an LRStruct<E>
 * @author Carl Alphonce
 */
public class Stack<E> implements IStack<E> {
	
	private LRStruct<E> _front;
	
	public Stack() {
		_front = new LRStruct<E>();
	}	
	
	public void push(E item) {
		_front.insertFront(item);
	}	
	
	public E pop() {
		return _front.execute(new IAlgo<E,E,Object>() {
			@Override public E emptyCase(LRStruct<E> host, Object arg) {
				throw new EmptyStackException("Cannot pop an empty stack.");
			}
			@Override public E nonEmptyCase(LRStruct<E> host, Object arg) {
				return host.removeFront();
			}
		}, null);
	}	
	
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException("Cannot pop an empty stack.");
		}
		else {
			return _front.getDatum();
		}
	}
	
	public boolean isEmpty() {
		return _front.execute(new IAlgo<Boolean,E,Void>() {
			@Override public Boolean emptyCase(LRStruct<E> host, Void _unused) {
				return true;
			}
			@Override public Boolean nonEmptyCase(LRStruct<E> host, Void _unused) {
				return false;
			}	
		}, null);
	}
	
	@Override public String toString() {
		return _front.toString();
	}
}
