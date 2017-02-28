package lrstruct.visitors.mfr;

import functions.UnaryFunction;
import lrstruct.LRStruct;

class Pair<A,B> {
	public A a;
	public B b;
	public Pair(A x, B y) {
		a = x;
		b = y;
	}
	public String toString() {
		return "{"+a+","+b+"}";
	}
}

public class Driver4 {
	
	public static void main(String[] args) {
		
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Jones");
		list.insertFront("Smith");
		list.insertFront("Anderson");
		list.insertFront("Miller");
		list.insertFront("Baker");
		list.insertFront("Johnson");
		list.insertFront("Franke");
		list.insertFront("Price");
//		Filter<String> F = new Filter<String>();
//		Predicate<String> P = new Predicate<String>() {
//			@Override public Boolean apply(String arg) {
//				char firstLetter = arg.charAt(0);
//				return 'A' <= firstLetter && firstLetter <= 'M';
//			}
//		};
		Map<Pair<String,String>,String> M = new Map<Pair<String,String>,String>();
		UnaryFunction<Pair<String,String>,String> UF = new UnaryFunction<Pair<String,String>,String>() {
			@Override public Pair<String, String> apply(String arg) {
				char firstLetter = arg.charAt(0);
				if ('A' <= firstLetter && firstLetter <= 'M') { return new Pair<String,String>(arg,"Knox 110"); }
				else { return new Pair<String,String>(arg,"NSC 215"); }
			}
		};
		
		System.out.println("LIST: "+list);
		System.out.println("LISM: "+list.execute(M,UF));
		
		
	}
	
}
