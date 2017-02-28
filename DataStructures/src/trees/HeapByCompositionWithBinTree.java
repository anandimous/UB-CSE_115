//package trees;
//
//import queues.EmptyQueueException;
//import queues.IQueue;
//import brstruct.BRStruct;
//import brstruct.BRStruct.IAlgo;
//import brstruct.visitors.EmptyVisitor;
//
//public class HeapByCompositionWithBinTree<E extends Comparable<E>> implements queues.IQueue<E>{
//
//	private BinTree<E> _heap;
//
//	public HeapByCompositionWithBinTree() {
//		_heap = new BinTree<E>(null);
//	}
//
//	@Override public E peek() {
//		if (isEmpty()) {
//			throw new EmptyQueueException("Cannot 'peek' an empty queue.");
//		}
//		else {
//			return _heap.root();
//		}
//	}
//
//	@Override public boolean isEmpty() {
//		return _heap.isEmpty();
//	}
//
//	@Override public void enqueue(E item) {
//		_heap.execute(new IAlgo<Object,E,E>() {
//			@Override public Object emptyCase(BRStruct<E> host, E arg) {
//				return host.insertRoot(arg);
//			}
//			@Override public Object nonEmptyCase(BRStruct<E> host, E arg) {
//				if (arg.compareTo(host.getDatum()) < 0) {
//					E tempValue = host.getDatum();
//					host.setDatum(arg);
//					arg = tempValue;
//				}
//				host.getRight().execute(this, arg);  // insert recursively on right
//				swapChildren(host); // swap left and right (to restore structure/balance property)
//				return null;
//			}
//		}, item);
//	}
//
//	@Override public E dequeue() {
//		return _heap.execute(new IAlgo<E,E,E>() {
//			@Override public E emptyCase(BRStruct<E> host, E _) {
//				throw new EmptyQueueException("Cannot 'dequeue' an empty queue.");
//			}
//			@Override public E nonEmptyCase(BRStruct<E> host, E _) {
//				E valueToRemove = host.getDatum();
//				BRStruct<E> leftmostTree = host.getLeft().execute(new Leftmost(), host);
//				if (leftmostTree != host) {
//					host.setDatum(leftmostTree.getDatum());
//					leftmostTree.removeRoot();
//					host.getLeft().execute(new PercolateDown(), host);
//				}
//				else {
//					leftmostTree.removeRoot();
//				}
//				return valueToRemove;
//			}
//		}, null);
//	}
//
//	@Override public String toString() {
//		return _heap.toString();
//	}
//
//	private BRStruct<E> min(BRStruct<E> a, BRStruct<E> b) {
//		if (a.execute(new EmptyVisitor<E>(), null)) { return b; }
//		if (b.execute(new EmptyVisitor<E>(), null)) { return a; }
//		return a.getDatum().compareTo(b.getDatum()) < 0 ? a : b;
//	}
//
//	private void swapValues(BRStruct<E> a, BRStruct<E> b) {
//		E temp = a.getDatum();
//		a.setDatum(b.getDatum());
//		b.setDatum(temp);
//	}
//
//	private void swapChildren(BRStruct<E> tree) {
//		BRStruct<E> tempTree = tree.getRight();
//		tree.setRight(tree.getLeft());
//		tree.setLeft(tempTree);
//	}
//
//	private class PercolateDown implements IAlgo<Object, E, BRStruct<E>> {
//		@Override public Object emptyCase(BRStruct<E> host, BRStruct<E> _) {
//			return null;
//		}
//		@Override public Object nonEmptyCase(BRStruct<E> host, BRStruct<E> parent) {
//			BRStruct<E> minimumTree = min(parent,min(parent.getLeft(),parent.getRight()));
//			if (minimumTree != parent) {
//				swapValues(parent,minimumTree);
//				minimumTree.getLeft().execute(new PercolateDown(), minimumTree);
//			}
//			return null;
//		}
//	}
//
//	private class Leftmost implements IAlgo<BRStruct<E>, E, BRStruct<E>> {
//		@Override public BRStruct<E> emptyCase(BRStruct<E> host, BRStruct<E> parent) {
//			return parent;
//		}
//		@Override public BRStruct<E> nonEmptyCase(BRStruct<E> host, BRStruct<E> parent) {
//			BRStruct<E> tree = host.getLeft().execute(this, host);
//			swapChildren(parent);
//			return tree;
//		}
//	}
//	
//	@Override public String name() {
//		return "PQ(HEAP-BRStruct)";
//	}
//
//	public static void main(String[] args) {
//		IQueue<Integer> h = new HeapByCompositionWithBinTree<Integer>();
//		int [] values = {10,20,15,5,7,2,14,19,3,6,9,1,34};
//		for (int i=0; i<values.length; i++) {
//			h.enqueue(values[i]);
//		}
//		System.out.println("\t\tBEFORE: "+h);
//		for (int i=0; i<values.length; i++) {
//			System.out.print("DEQUEUE: "+h.dequeue());
//			System.out.println("\t AFTER: "+h);
//		}
//	}
//
//}
