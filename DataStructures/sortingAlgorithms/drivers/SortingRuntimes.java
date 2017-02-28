package drivers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import sorters.ISorter;
import sorters.MergeSort;
import sorters.SelectionSort;
import utility.Pair;

public class SortingRuntimes {

	// In run configuration:
	// add VM args: -Xmx12G -Xms12G -Xoss512M
	public static void main(String[] args) {
		// nSquared is a list of slow sorters
		ArrayList<ISorter<Integer>> nSquared = new ArrayList<ISorter<Integer>>();
//		nSquared.add(new SelectionSort<Integer>());
		// nLogn is a list of fast sorters
		ArrayList<ISorter<Integer>> nLogn = new ArrayList<ISorter<Integer>>();
		nLogn.add(new MergeSort<Integer>());
//		nLogn.add(new HeapSort<Integer>());
//		nLogn.add(new ArraySort<Integer>());
		// gather data
		runGatherData(nSquared,nLogn);
 	}

	public static void runGatherData(ArrayList<ISorter<Integer>> slow,
                                     ArrayList<ISorter<Integer>> fast) {
	
		// A list of all the sorters, first the slow ones, then the fast ones
		ArrayList<ISorter<Integer>> all = new ArrayList<ISorter<Integer>>();
		all.addAll(slow);
		all.addAll(fast);

		int numSlow = slow.size();
		int numFast = fast.size();

		// A place to hold the data that we gather for the sorts we're running
		ArrayList<ArrayList<Pair<Integer,Long>>> data = new ArrayList<ArrayList<Pair<Integer,Long>>>();
		for (int i=0; i<(numSlow+numFast); i++) {
			data.add(new ArrayList<Pair<Integer,Long>>());
		}

		int start  = 131072000;
		int cutoff = 131072000;  // problem size cutoff for slow sorts
//		int end    =  cutoff;  // problem size cutoff for fast sorts
//		int end    =    128000;  // problem size cutoff for fast sorts
//		int end    =  65536000;  // problem size cutoff for fast sorts
		int end    = 131072000;  // problem size cutoff for fast sorts
//		int end    =  32000000;  // problem size cutoff for fast sorts

		//		int dataSetSize = 8000000;  // 1000 * 2^16, or approx 2^26
		int dataSetSize = end;
		System.out.println("Generating random base dataset of size "+dataSetSize);
		Integer[] baseArray = randomIntegerArray(dataSetSize);

		for (int size = start; size <= end; size *= 2) {
//			System.out.print("\nSIZE is "+size+"...");
			System.out.print("Selecting a random subset of base dataset, of size "+size);
			Integer[] array = Arrays.copyOfRange(baseArray, 0, size);
			int lowIndex = (size <= cutoff) ? 0 : slow.size();
			for (int i=lowIndex; i<all.size(); i++) {
				ISorter<Integer> sorter = all.get(i);
				System.out.println("...performing "+sorter.name() + "...");
				timeSorter(sorter, array.clone(), data.get(i));
			}
		}
		for (int i=0; i<data.size(); i++) {
			ArrayList<Pair<Integer,Long>> datum = data.get(i);
			printData(datum,  all.get(i).name()+" data summary");
		}
	}

	private static void printData(ArrayList<Pair<Integer,Long>> data, String titleString) {
		System.out.println("\n"+titleString);
		for (Pair<Integer,Long> p : data) {
//			System.out.format("SIZE: %10d TIME: %8d ms, %8.7f ms/item, %8.1f items/ms\n", p.a, p.b, (p.b/(double)p.a), (p.a/(double)p.b));
			System.out.format("SIZE: %10d TIME: %8d ms\n", p.a, p.b);
		}
	}

	private static void timeSorter(ISorter<Integer> s, Integer[] array, ArrayList<Pair<Integer,Long>> td) {
		long start = System.currentTimeMillis();
		s.sort(array);
		long end = System.currentTimeMillis();
		td.add(new Pair<Integer,Long>(array.length,end-start));
	}
	
	static Integer[] randomIntegerArray(int howMany) {
		return randomIntegerArray(howMany, Integer.MAX_VALUE);
	}
	
	static Integer[] randomIntegerArray(int howMany, int max) {
		Integer[] array = new Integer[howMany];
		Random r = new Random();
		for (int i=0; i<howMany; i++) {
			if (i%4000000 == 0 && i>0) { System.out.println(i); }
			array[i] = r.nextInt(max);
		}
		return array;
	}

//	private static void printArray(Integer[] array) {
//		StringBuffer sb = new StringBuffer();
//		sb.append("[");
//		for (int i=0; i<array.length; i++) {
//			sb.append(" ");
//			sb.append(array[i]);
//		}
//		sb.append(" ]");
//		System.out.println(sb.toString());
//	}
	
//	public static void runSort(ISorter<Integer> sorter, int size, int maxValue) {
//		System.out.print("Running "+sorter.name()+"...");
//		ArrayList<Pair<Integer,Long>> ssData = new ArrayList<Pair<Integer,Long>>();
//		System.out.print("generating random data...");
//		Integer[] array = randomIntegerArray(size, maxValue);
//		System.out.print("sorting...\n");
//		timeSorter(sorter, array.clone(), ssData);
//		System.out.println("done.");
//		printData(ssData, sorter.name()+" data");
//	}
}


