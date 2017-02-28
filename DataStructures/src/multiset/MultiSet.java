package multiset;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MultiSet<E> implements Collection<E> {

	private E[] _store;
	private int _size;
	private long _modCount;

	public MultiSet() {
		_modCount = 0;
		clear();
	}

	@SuppressWarnings("unchecked")
	@Override public void clear() {
		_store = (E[]) (new Object[10]);
		_size = 0;
		// establishes the invariants properties
		_modCount++;
	}

	@Override public boolean add(E e) {
		// invariants hold
		_store[_size] = e;
		// invariants are broken
		_size = _size + 1;
		// if _size is 10, then the invariants are still broken!
		if (_size == _store.length) {
			E[] temp = (E[]) (new Object[_store.length * 2]);
//			System.out.println("Resized from "+_store.length+" to "+temp.length);
			for (int i=0; i<_store.length; i=i+1) {
				temp[i] = _store[i];
			}
			_store = temp;
		}
		// invariants are restored
		_modCount++;
		return true;
	}

	@Override public boolean contains(Object obj) {
		if (obj == null) {
			for (int i=0; i<_size; i=i+1) {
				if (obj == _store[i]) {
					return true;
				}
			}
		}
		else {
			for (int i=0; i<_size; i=i+1) {
				if (obj.equals(_store[i])) {
					return true;
				}
			}
		}
		return false;
	}

	@Override public int size() {
		return _size;
	}

	@Override public boolean remove(Object obj) {
		if (obj == null) {
			for (int i=0; i<_size; i=i+1) {
				if (obj == _store[i]) {
					_store[i] = _store[_size-1];
					_store[_size-1] = null;
					_size--;
					_modCount++;
					return true;
				}
			}
		}
		else {
			for (int i=0; i<_size; i=i+1) {
				if (obj.equals(_store[i])) {
					_store[i] = _store[_size-1];
					_store[_size-1] = null;
					_size--;
					_modCount++;
					return true;
				}
			}
		}
		return false;
	}

	@Override public boolean isEmpty() {
		return _size == 0;
	}

	@Override public Iterator<E> iterator() {
		return new MultiSetIterator();
	}
	
	private class MultiSetIterator implements Iterator<E> {

		private int _index;  // _index refers to the first
							 // UNvisited member of the MultiSet
		private long _modCountOfMultiSetAtIteratorCreation;
		
		public MultiSetIterator() {
			_index = 0;
			_modCountOfMultiSetAtIteratorCreation = _modCount;
		}
		
		@Override public boolean hasNext() {
			if (_modCountOfMultiSetAtIteratorCreation != _modCount) {
				throw new ConcurrentModificationException();
			}
			return _index < _size;
		}

		@Override public E next() {
			if (_modCountOfMultiSetAtIteratorCreation != _modCount) {
				throw new ConcurrentModificationException();
			}
			if (hasNext()) {
				E temp = _store[_index];
				_index++;
				return temp;
			}
			throw new NoSuchElementException();
		}

	}


	/*
	 * The implementation of the remaining methods are left as
	 * an exercise for the reader :-)
	 * 
	 */

	@Override public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
}
