package lists;

/*
 * Textbook code:
 * 	Data Structures and the Java Collections Framework (3rd ed)
 *  William J. Collins
 *  Chapter 7, through end of 7.2.1
 *  
 *  With slight modifications by Carl Alphonce (Spring 2016)
 *  
 */
public class SinglyLinkedList<E> {

	private static class Entry<E> {
		public E element;
		public Entry<E> next;
		public Entry(E element, Entry<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	private Entry<E> head;
	private int size;

	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToFront(E element) {
		head = new Entry<E>(element, head);
	}

	public int size() {
		return size;
	}

	public boolean contains(Object obj) {
		if (obj == null) {
			for (Entry<E> p = head; p != null; p = p.next) {
				if (obj == p.element) {
					return true;
				}
			}
		}
		else {
			for (Entry<E> p = head; p != null; p = p.next) {
				if (obj.equals(p.element)) {
					return true;
				}
			}
		}
		return false;
	}

}
