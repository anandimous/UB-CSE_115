package sorters;

public class Heap {
	
	private int[] _array;
	private int _size;
	
	public Heap() {
		_array = new int[10];
		_size = 1;
	}

	public void enqueue(int x) {
		_array[_size++] = x;
		percolateUp(_size-1);
	}

	private void percolateUp(int i) {
		// TODO Auto-generated method stub
		
	}

	public int dequeue() {
		int x = _array[1];
		_array[1] = _array[_size--];
		siftDown(1);
		return x;
	}

	private void siftDown(int i) {
		// TODO Auto-generated method stub
		
	}
}

