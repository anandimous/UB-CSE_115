package lrstruct.visitors.mfr;

import functions.BinaryFunction;
import functions.Constant;
import functions.FProduct;
import functions.FSum;
import functions.ID;
import functions.Predicate;
import functions.UnaryFunction;
import lrstruct.LRStruct;

public class Driver {
	public static void main(String[] args) {
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Fred").insertFront("Wilma").insertFront("Pebbles").insertFront("Barney").insertFront("Betty");

		Predicate<String> p = new Predicate<String>() {
			@Override public Boolean apply(String arg) { return arg.length() <= 5; }
		};
		LRStruct<String> listA = list.execute(new Filter<String>(), p);
		System.out.println(listA);

		UnaryFunction<Integer,String> f = new UnaryFunction<Integer,String>() {
			@Override public Integer apply(String arg) { return arg.length(); }
		};
		LRStruct<Integer> listB = list.execute(new Map<Integer,String>(), f);
		System.out.println(listB);

		BinaryFunction<Integer,Integer,Integer> plus = new BinaryFunction<Integer,Integer,Integer>() {
			@Override public Integer apply(Integer arg1, Integer arg2) { return arg1 + arg2; }
			@Override public Integer identity() { return 0; }
		};
		Integer sum = listB.execute(new Reduce<Integer,Integer>(), plus);
		System.out.println(sum);

		BinaryFunction<Integer,Integer,Integer> times = new BinaryFunction<Integer,Integer,Integer>() {
			@Override public Integer apply(Integer arg1, Integer arg2) { return arg1 * arg2; }
			@Override public Integer identity() { return 1; }
		};
		Integer product = listB.execute(new Reduce<Integer,Integer>(), times);
		System.out.println(product);
		
		UnaryFunction<Integer,Integer> TWO = new Constant(2);
		UnaryFunction<Integer,Integer> FIVE = new Constant(5);
		UnaryFunction<Integer,Integer> TwoXPlusFive = new FSum(new FProduct(TWO,new ID<Integer>()),FIVE);
		UnaryFunction<Integer,Integer> FiveXPlusTwo = new FSum(new FProduct(FIVE,new ID<Integer>()),TWO);
		UnaryFunction<Integer,Integer> TwoPlusXTimesFive = new FProduct(new FSum(TWO,new ID<Integer>()),FIVE);
		
		System.out.println("When x is 3, 2x+5 is "+TwoXPlusFive.apply(3));
		System.out.println("When x is 3, 5x+2 is "+FiveXPlusTwo.apply(3));
		System.out.println("When x is 3, (2+x)*5 is "+TwoPlusXTimesFive.apply(3));
	}
}
