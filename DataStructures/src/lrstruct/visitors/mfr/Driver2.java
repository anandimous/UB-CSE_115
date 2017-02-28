package lrstruct.visitors.mfr;

import functions.UnaryFunction;
import lrstruct.LRStruct;

public class Driver2 {

	public static void main(String[] args) {
		Map<Integer, Integer> M = new Map<Integer,Integer>();
//		Filter<Integer> F = new Filter<Integer>();
//		Reduce<Integer, Integer> R = new Reduce<Integer,Integer>();
//		BinaryFunction<Integer, Integer, Integer> S = new Sum();
//		Predicate<Integer> LT100 = new Predicate<Integer>() {
//			@Override public Boolean apply(Integer arg) { return arg < 100; }
//		}; 
		UnaryFunction<Integer,Integer> SQ = new UnaryFunction<Integer, Integer>() {
//			@Override public Integer apply(Integer arg) { return arg * arg; }
			@Override public Integer apply(Integer arg) { return 2 * arg + 3; }
		};
		
		LRStruct<Integer> list_A = new LRStruct<Integer>();
//		list_A.insertFront(5).insertFront(4).insertFront(3).insertFront(2).insertFront(1);
		list_A.insertFront(-1).insertFront(3).insertFront(2).insertFront(-3).insertFront(4);
		LRStruct<Integer> list_B = list_A.execute(M, SQ);
		LRStruct<Integer> list_C = list_B.execute(M, SQ);
//		LRStruct<Integer> list_D = list_C.execute(F, LT100);
//		int value_E = list_D.execute(R,S);
		System.out.println("list_A is " + list_A);
		System.out.println("list_B is " + list_B);
		System.out.println("list_C is " + list_C);
//		System.out.println("list_D is " + list_D);
//		System.out.println("value_E is " + value_E);
	}
	
}
