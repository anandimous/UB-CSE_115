package trees;

public class BinTree<E> {
	
	private E _datum;
	private BinTree<E> _left;
	private BinTree<E> _right;
	private int _size;
	
	public BinTree() {
		_datum = null;
		_left = null;
		_right = null;
		_size = 0;
	}
	
	public boolean isEmpty() {
		return _size == 0;
	}

	public E getDatum() {
		return _datum;
	}

	public void setDatum(E datum) {
		_datum = datum;
	}

	public BinTree<E> getLeft() {
		return _left;
	}

	public void setLeft(BinTree<E> left) {
		_left = left;
	}

	public BinTree<E> getRight() {
		return _right;
	}

	public void setRight(BinTree<E> right) {
		_right = right;
	}
}
