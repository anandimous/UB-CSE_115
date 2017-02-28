package tests;
import java.util.Random;

import junit.framework.TestCase;
import sorters.ISorter;
import sorters.MergeSort;
import sorters.SelectionSort;

/**
 * 
 */

/**
 * @author alphonce
 *
 */
public class SortingTest extends TestCase {
	
	public void notestSelectionSort() {
		Integer[] array = randomIntegerArray(10);
		printArray(array);
		ISorter<Integer> sorter = new SelectionSort<Integer>();
		sorter.sort(array);
		printArray(array);
		assertTrue("",sorted(array));
	}

	public void testMergeSort() {
		Integer[] array = randomIntegerArray(10);
		printArray(array);
		ISorter<Integer> sorter = new MergeSort<Integer>();
		sorter.sort(array);
		printArray(array);
		assertTrue("",sorted(array));
	}

	/**
	 * @param array
	 */
	private void printArray(Integer[] array) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i=0; i<array.length; i++) {
			sb.append(" ");
			sb.append(array[i]);
		}
		sb.append(" ]");
		System.out.println(sb.toString());
	}

	public void notestRandomArray() {
		Integer[] array = randomIntegerArray(10);
		printArray(array);
		assertFalse("",sorted(array));
	}

	/**
	 * @param array
	 * @return
	 */
	private boolean sorted(Integer[] array) {
		for (int i=0; i<array.length-1; i++) {
			if (array[i].compareTo(array[i+1]) > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param i
	 * @return
	 */
	private Integer[] randomIntegerArray(int howMany) {
		Integer[] array = new Integer[howMany];
		Random r = new Random();
		for (int i=0; i<howMany; i++) {
			array[i] = r.nextInt(1000);
		}
		return array;
	}

}
