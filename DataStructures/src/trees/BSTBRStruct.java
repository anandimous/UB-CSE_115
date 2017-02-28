package trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;
import brstruct.RemoveRootVisitor;
import brstruct.visitors.EmptyVisitor;
import brstruct.visitors.FindVisitor;
import brstruct.visitors.SizeVisitor;
import brstruct.visitors.traversals.InOrderVisitor;
import brstruct.visitors.traversals.PostOrderVisitor;
import brstruct.visitors.traversals.PreOrderVisitor;
import queues.AQueue;
import queues.QueueByCompositionWithLRStruct;
import stack.IStack;
import stack.Stack;

@SuppressWarnings("unused")
public class BSTBRStruct<E extends Comparable<E>> implements Iterable<E> {
	
	// VISITORS USED IN THIS CODE
	private final FindVisitor<E> FIND = new FindVisitor<E>();
	private final RemoveRootVisitor<E> REMOVE = new RemoveRootVisitor<E>();
	private final PreOrderVisitor<E> PRE_ORDER = new PreOrderVisitor<E>();
	private final InOrderVisitor<E> IN_ORDER = new InOrderVisitor<E>();
	private final PostOrderVisitor<E> POST_ORDER = new PostOrderVisitor<E>();
	private final EmptyVisitor<E> EMPTY = new EmptyVisitor<E>();
	private final SizeVisitor<E> SIZE = new SizeVisitor<E>();

	private BRStruct<E> _brs;

//	public BRStruct<E> getTree() { return _brs; }
	
	public BSTBRStruct() {
		_brs = new BRStruct<E>();
	}
	
	public boolean isEmpty() {
		return _brs.execute(EMPTY, null);
	}

	public int size() {
		return _brs.execute(SIZE, null);
	}

	public BSTBRStruct<E> insert(E item) {
		BRStruct<E> tree = _brs.execute(FIND, item);
		tree.execute(new IAlgo<Void,E,E>(){
			@Override public Void emptyCase(BRStruct<E> host, E item) {				
				host.insertRoot(item); // item is not in tree, so insert it
				return null;
			}
			@Override public Void nonEmptyCase(BRStruct<E> host, E item) {
				return null; // item is already in tree - do not insert again
			}
		}, item);
		return this;
	}

	public BSTBRStruct<E> remove(E item) {
		BRStruct<E> tree = _brs.execute(FIND, item);
		tree.execute(REMOVE, null);
		return this;
	}

	public boolean member(E item) {
		BRStruct<E> tree = _brs.execute(FIND, item);
		return tree.execute(new IAlgo<Boolean,E,Void>(){
			@Override public Boolean emptyCase(BRStruct<E> host, Void arg) { return false; }
			@Override public Boolean nonEmptyCase(BRStruct<E> host, Void arg) { return true; }
		}, null);
	}
	
	@Override
	public String toString() {
		return _brs.toString();
	}
	
	public AQueue<E> preOrder() {
		AQueue<E> q = new AQueue<E>();
		_brs.execute(PRE_ORDER, q);
		return q;
	}
	
	public AQueue<E> inOrder() {
		AQueue<E> q = new AQueue<E>();
		_brs.execute(IN_ORDER, q);
		return q;
	}
	
	public AQueue<E> postOrder() {
		AQueue<E> q = new AQueue<E>();
		_brs.execute(POST_ORDER, q);
		return q;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new BSTInOrderIterator();
	}

	// made private for the time being
	private Iterator<E> breadthFirstIterator() {
		return new BFIterator();
	}

	
	private class BSTInOrderIterator implements Iterator<E> {

		private final LeftPusher LEFT_PUSHER = new LeftPusher();
		private IStack<BRStruct<E>> _stack;
		
		public BSTInOrderIterator() {
			_stack = new Stack<BRStruct<E>>();
			_brs.execute(LEFT_PUSHER, _stack);
		}

		@Override public boolean hasNext() {
			return ! _stack.isEmpty();
		}

		@Override public E next() {
			if (hasNext()) {
				BRStruct<E> current = _stack.pop();
				current.getRight().execute(LEFT_PUSHER, _stack);
				return current.getDatum();
			}
			else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public String toString() {
			String answer = "[ TOP--> ";
			Stack<BRStruct<E>> s = new Stack<BRStruct<E>>();
			while (!_stack.isEmpty()) {
				BRStruct<E> tree = _stack.pop();
				s.push(tree);
				answer = answer + " " + tree.getDatum().toString();
			}
			while (!s.isEmpty()) { _stack.push(s.pop()); }
			return answer;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	private class LeftPusher implements IAlgo<Object, E, IStack<BRStruct<E>>> {
		@Override
		public Object emptyCase(BRStruct<E> host, IStack<BRStruct<E>> stack) {
			return null;
		}

		@Override
		public Object nonEmptyCase(BRStruct<E> host, IStack<BRStruct<E>> stack) {
			stack.push(host);
			return host.getLeft().execute(this, stack);
		}
	}

	private class BFIterator implements Iterator<E> {

		private QueueByCompositionWithLRStruct<BRStruct<E>> _queue;  // invariant - only contains non-empty trees!
		
		public BFIterator() {
			_queue = new QueueByCompositionWithLRStruct<BRStruct<E>>();
			_brs.execute(new NonEmptyTreeEnqueuer(), _queue);
		}

		@Override public boolean hasNext() {
			return ! _queue.isEmpty();
		}

		@Override public E next() {
			BRStruct<E> current = _queue.dequeue();
			current.getLeft().execute(new NonEmptyTreeEnqueuer(), _queue);
			current.getRight().execute(new NonEmptyTreeEnqueuer(), _queue);
			return current.getDatum();
		}

		@Override public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	private class NonEmptyTreeEnqueuer implements IAlgo<Void,E,QueueByCompositionWithLRStruct<BRStruct<E>>> {
		@Override public Void emptyCase(BRStruct<E> host, QueueByCompositionWithLRStruct<BRStruct<E>> _) {
			return null;
		}
		@Override public Void nonEmptyCase(BRStruct<E> host, QueueByCompositionWithLRStruct<BRStruct<E>> q) {
			q.enqueue(host);
			return null;
		}
	}
	
}
