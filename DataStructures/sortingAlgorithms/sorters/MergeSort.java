package sorters;

public class MergeSort<E extends Comparable<E>> implements ISorter<E> {

	private E[] _tmpArray;

	@SuppressWarnings("unchecked")
	@Override
	public void sort(E[] array) {
		_tmpArray = (E[]) (new Comparable[array.length]);
		mergesort(array, 0, array.length);
	}

	private void mergesort(E[] array, int left, int right) {
		if ( (right-left) > 1 ) {	// RECURSIVE CASE: need to decompose array
			int midPoint = (left+right)/2;
/* A */		mergesort(array,left,midPoint);	// sort left half
/* B */		mergesort(array,midPoint,right);	// sort right half
/* C */		merge(array, left, right, midPoint);
	}	}

	private void merge(E[] array, int left, int right, int midPoint) {
		int lp = left;
		int rp = midPoint;
		int i=left;
		while (lp < midPoint && rp < right) {
			_tmpArray[i++] = array[lp].compareTo(array[rp]) < 0 ? array[lp++] : array[rp++];
		}
		while (lp < midPoint) { _tmpArray[i++] = array[lp++]; }
		while (rp < right)    { _tmpArray[i++] = array[rp++]; }
		for (int k=left; k<right; k++) { array[k] = _tmpArray[k]; }
	}

	@Override public String name() {
		return "merge sort";
	}
}
