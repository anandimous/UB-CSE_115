package sorters;

import java.util.Arrays;

/**
 * @author alphonce
 *
 */
public class ArraySort<E extends Comparable<E>> implements ISorter<E> {

	@Override
	public void sort(E[] array) {
		Arrays.sort(array);
	}

	@Override public String name() {
		return "Array.sort";
	}
	
}
