package sorters;
/**
 * 
 */

/**
 * @author alphonce
 *
 */
public class SelectionSort<E extends Comparable<E>> implements ISorter<E> {

	@Override
	public void sort(E[] array) {
		for (int i=0; i<array.length; i++) {
			int indexOfSmallest = indexOfSmallest(array,i);
			E tmp = array[i];
			array[i] = array[indexOfSmallest];
			array[indexOfSmallest] = tmp;
			// the value at i is in the correct location
		}
	}
	
	private int indexOfSmallest(E[] array, int startingIndex) {
		int indexOfSmallestSoFar = startingIndex;
		for (int i=startingIndex+1; i<array.length; i++) {
			if (array[i].compareTo(array[indexOfSmallestSoFar]) < 0) {
				indexOfSmallestSoFar = i;
			}
		}
		return indexOfSmallestSoFar;
	}
	
	public void printArray(E[] array, int x) {
		System.out.print("[");
		for (int i=0; i< array.length; i++) {
			if (i == x) {
				System.out.print(" | ");
			}
			else {
				System.out.print("   ");
			}
			System.out.print(array[i]);
		}
		if (array.length == x) {
			System.out.print(" | ]");
		}
		else {
			System.out.print("   ]");
		}
		System.out.println();
	}

	@Override public String name() {
		return "selection sort";
	}
	
}
