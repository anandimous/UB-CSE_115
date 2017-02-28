package queues;
import java.util.ArrayList;
import java.util.Random;

//import trees.HeapByCompositionWithArray;
//import trees.HeapByCompositionWithBRStruct;
//import utility.Pair;

public class DriverTimings {

	// In run configuration:
	// add VM args: -Xmx2G -Xoss64M
	public static void main(String[] args) {

		int startSize =     1000;
		int slowLimit =    16000;
		int   endSize =  65536000;
		System.out.println("Generating random data of size "+endSize);
		Integer[] baseArray = randomIntegerArray(endSize);

		ArrayList<IQueue<Integer>> slow = new ArrayList<IQueue<Integer>>();
		ArrayList<IQueue<Integer>> fast = new ArrayList<IQueue<Integer>>();
		slow.add(new PQueueByCompositionWithArray<Integer>());
		slow.add(new PQueueByCompositionWithArrayList<Integer>());
		//		slow.add(new PQueueByCompositionWithLRStruct<Integer>());
//		fast.add(new HeapByCompositionWithArray<Integer>());
//		fast.add(new HeapByCompositionWithBRStruct<Integer>());

		// A list of all the sorters, first the slow ones, then the fast ones
		ArrayList<IQueue<Integer>> all = new ArrayList<IQueue<Integer>>();
		all.addAll(slow);
		all.addAll(fast);

//		int numSlow = slow.size();
//		int numFast = fast.size();

		// A place to hold the data that we gather for the queues we're running
		ArrayList<ArrayList<Pair<Integer,Long>>> data = new ArrayList<ArrayList<Pair<Integer,Long>>>();

		for (int dataSetSize = startSize; dataSetSize <= endSize; dataSetSize = dataSetSize*2) {
			ArrayList<Pair<Integer,Long>> times = new ArrayList<Pair<Integer,Long>>();
			if (dataSetSize < slowLimit) {
				for (IQueue<Integer> q : all) {
					long start = System.currentTimeMillis();
					for (int i = 0; i < dataSetSize ; i++) {
						q.enqueue(baseArray[i]);
					}
					long end = System.currentTimeMillis();
					//				times.add(new Pair<Integer,Long>(dataSetSize,end-start));
					//				printData(times, q.name());
					System.out.println(q.name()+ " data set size: " + dataSetSize+", elapsed time: "+ (end-start));
				}
				data.add(times);
				System.out.println();
			}
			else {
					for (IQueue<Integer> q : fast) {
						long start = System.currentTimeMillis();
						for (int i = 0; i < dataSetSize ; i++) {
							q.enqueue(baseArray[i]);
						}
						long end = System.currentTimeMillis();
						//				times.add(new Pair<Integer,Long>(dataSetSize,end-start));
						//				printData(times, q.name());
						System.out.println(q.name()+ " data set size: " + dataSetSize+", elapsed time: "+ (end-start));
					}
					data.add(times);
					System.out.println();
			}
		}
		System.out.println("Done");
	}

	@SuppressWarnings("unused")
	private static void printData(ArrayList<Pair<Integer,Long>> data, String titleString) {
		System.out.println(titleString);
		for (Pair<Integer,Long> p : data) {
//			System.out.format("SIZE: %10d TIME: %8d ms, %8.7f ms/item, %8.1f items/ms\n", p.a, p.b, (p.b/(double)p.a), (p.a/(double)p.b));
		}
	}

	static Integer[] randomIntegerArray(int howMany) {
		return randomIntegerArray(howMany, Integer.MAX_VALUE);
	}

	static Integer[] randomIntegerArray(int howMany, int max) {
		Integer[] array = new Integer[howMany];
		Random r = new Random();
		for (int i=0; i<howMany; i++) {
			array[i] = r.nextInt(max);
		}
		return array;
	}
}


