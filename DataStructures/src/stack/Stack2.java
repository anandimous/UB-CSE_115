package stack;

import java.util.ArrayList;

/**
 * A stack, defined by composition with an ArrayList<E>
 * @author Carl Alphonce
 */
public class Stack2<E> implements IStack<E> {
	
	private ArrayList<E> _front;
	
	public Stack2() {
		_front = new ArrayList<E>();
	}	
	
	/* (non-Javadoc)
	 * @see stack.IStack#push(E)
	 */
	@Override
	public void push(E item) {
		_front.add(_front.size(), item);
	}	
	
	/* (non-Javadoc)
	 * @see stack.IStack#pop()
	 */
	@Override
	public E pop() {
		if (_front.isEmpty()) {
			throw new EmptyStackException("Cannot pop an empty stack.");
		}
		else { 
			return _front.remove(_front.size()-1);
		}
	}	
	
	/* (non-Javadoc)
	 * @see stack.IStack#peek()
	 */
	@Override
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException("Cannot peek an empty stack.");
		}
		else { 
			return _front.get(_front.size()-1);
		}
	}
	
	/* (non-Javadoc)
	 * @see stack.IStack#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return _front.isEmpty();
	}
	
	@Override public String toString() {
		return _front.toString();
	}
}
