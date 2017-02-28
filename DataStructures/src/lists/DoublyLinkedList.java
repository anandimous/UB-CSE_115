package lists;

/*
 * Modeled after java.util.LinkedList
 *  
 * Carl Alphonce (Spring 2016)
 *  
 */
public class DoublyLinkedList<E> {

	private static class Node<E> {
		public E item;
		public Node<E> prev;
		public Node<E> next;
		public Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.prev = prev;
			this.next = next;
		}
	}

	private Node<E> first;
	private Node<E> last;
	private int size;

	public DoublyLinkedList() {
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		Node<E> l = last;
		Node<E> newNode = new Node<E>(l,e,null);
		last = newNode;
		if (l == null) {
			first = newNode;
		}
		else {
			l.next = newNode;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public boolean contains(Object obj) {
		if (obj == null) {
			for (Node<E> p = first; p != null; p = p.next) {
				if (obj == p.item) {
					return true;
				}
			}
		}
		else {
			for (Node<E> p = first; p != null; p = p.next) {
				if (obj.equals(p.item)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for (Node<E> p = first; p != null; p = p.next) {
			sb.append(" ").append(p.item);
		}
		return sb.append(" )").toString();
	}

	public void remove(String remove) {
		// TODO Auto-generated method stub
		
	}

}
