package sorters;

import trees.HeapByCompositionWithBRStruct;


/*
 * MIN-HEAP
 */

//@SuppressWarnings("unchecked")
public class HeapSort<E extends Comparable<E>> implements ISorter<E>{
	
	@Override public void sort(E[] array) {
		HeapByCompositionWithBRStruct<E> heap = new HeapByCompositionWithBRStruct<E>();
//		HeapByCompositionWithArray<E> heap = new HeapByCompositionWithArray//<E>();
		for (E e : array) {
			heap.enqueue(e);
		}
		for (int i=0; i<array.length; i++) {
			array[i] = heap.dequeue();
		}
	}

	@Override public String name() {
		return "HeapSort";
	}
}
