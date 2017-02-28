package lrstruct.visitors.mfr;

import functions.Predicate;
import lrstruct.LRStruct;

public class Driver3 {
	
	private static class NotDivisibleBy implements Predicate<Integer> {

		private int divBy;
		
		public NotDivisibleBy(int n) {
			divBy = n;
		}
		
		@Override public Boolean apply(Integer arg) {
			return arg == divBy || arg % divBy != 0;
		}
		
	}
	
	public static void main(String[] args) {
		LRStruct<Integer> listNo1  = seq(2,1000,1); 
		LRStruct<Integer> listNo2 = listNo1.execute(new Filter<Integer>(), new NotDivisibleBy(2));
		LRStruct<Integer> listNo3 = listNo2.execute(new Filter<Integer>(), new NotDivisibleBy(3));
		LRStruct<Integer> listNo5 = listNo3.execute(new Filter<Integer>(), new NotDivisibleBy(5));
		LRStruct<Integer> listNo7 = listNo5.execute(new Filter<Integer>(), new NotDivisibleBy(7));
		LRStruct<Integer> listNo11 = listNo7.execute(new Filter<Integer>(), new NotDivisibleBy(11));
		LRStruct<Integer> listNo13 = listNo11.execute(new Filter<Integer>(), new NotDivisibleBy(13));
		
		System.out.println(listNo1);
		System.out.println(listNo2);
		System.out.println(listNo3);
		System.out.println(listNo5);
		System.out.println(listNo7);
		System.out.println(listNo11);
		System.out.println(listNo13);
	}

//	private static LRStruct<Integer> seq(int n) {
//		return seq(1,n,1);
//	}
	
	private static LRStruct<Integer> seq(int start, int stop, int step) {
		if (start>stop) {
			return new LRStruct<Integer>(); 
		}
		else {
			return seq(start+step,stop,step).insertFront(start);
		}
	}

}
