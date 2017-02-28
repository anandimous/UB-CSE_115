package simulations;

import sorters.ISorter;

/**
 * @author alphonce
 *
 */
public class MergeSortRunTimeSimulation<E extends Comparable<E>> implements ISorter<E> {

	private E[] _tmpArray;
	private RunTimeStackSimulator<E> _runtimeStack;

	@SuppressWarnings("unchecked")
	@Override
	public void sort(E[] array) {
		_runtimeStack = new RunTimeStackSimulator<E>();
		_tmpArray = (E[]) (new Comparable[array.length]);
		_runtimeStack.push(new InvocationRecord("[sort]      array: ",array," On return, finished."));
		_runtimeStack.push(new InvocationRecord("[mergesort] array: ",array," left: "+0+" right: "+array.length+" on return, continue with statement: G"));
/*F*/	mergesort(array, 0, array.length);
/*G*/	/* return from sort */
		_runtimeStack.pop();
	}

	/**
	 * @param array
	 * @param i
	 * @param length
	 */
	private void mergesort(E[] array, int left, int right) {
		if ( (right-left) <= 1 ) {
				// BASE CASE: subarray is already sorted
		}
		else {	// RECURSIVE CASE: need to decompose array
/*A*/		int midPoint = (left+right)/2;
			_runtimeStack.push(new InvocationRecord("[mergesort] array: ",array," left: "+left+" right: "+midPoint+" on return, continue with statement: C"));
/*B*/		mergesort(array,left,midPoint);	// sort left half
			_runtimeStack.push(new InvocationRecord("[mergesort] array: ",array," left: "+midPoint+" right: "+right+" on return, continue with statement: D"));
/*C*/		mergesort(array,midPoint,right);	// sort right half
			_runtimeStack.push(new InvocationRecord("[merge]     array: ",array," left: "+left+" right: "+right+" midPoint: "+midPoint+" on return, continue with statement: D"));
/*D*/		merge(array, left, right, midPoint);
		}
		_runtimeStack.pop();
/*E*/		/* return from mergesort */
	}

	private void merge(E[] array, int left, int right, int midPoint) {
		// merge
		int lp = left;
		int rp = midPoint;
		int i=left;
		while (lp < midPoint && rp < right) {
			_tmpArray[i++] = array[lp].compareTo(array[rp]) < 0 ? array[lp++] : array[rp++];
		}
		while (lp < midPoint) {
			_tmpArray[i++] = array[lp++];
		}
		while (rp < right) {
			_tmpArray[i++] = array[rp++];
		}
		// copy back relevant portion of array
		for (int k=left; k<right; k++) {
			array[k] = _tmpArray[k];
		}
		_runtimeStack.pop();
	}

	private String array2String(E[] array) { return array2String(array,0,array.length); }
	
	private String array2String(E[] array, int start, int end) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i=start; i<end; i++) {
			sb.append(" ");
			sb.append(array[i]);
		}
		sb.append(" ]");
		return sb.toString();
	}

	public class InvocationRecord {
		private String _preArray;
		private E[] _array;
		private String _postArray;
		public InvocationRecord(String pre, E[] a, String post) {
			_preArray = pre;
			_array = a;
			_postArray = post;
		}
		@Override public String toString() {
			return _preArray + array2String(_array) + _postArray;
		}
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

}
