package lrstruct.visitors.mfr;

import functions.Predicate;
import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class Filter<E> implements IAlgo<LRStruct<E>, E, Predicate<E>> {

	@Override public LRStruct<E> emptyCase(LRStruct<E> host, Predicate<E> _) {
		return new LRStruct<E>();
	}

	@Override public LRStruct<E> nonEmptyCase(LRStruct<E> host, Predicate<E> pred) {
		E item = host.getDatum();
		if (pred.apply(item)) {
			return host.getRest().execute(this,pred).insertFront(item);
		}
		else {
			return host.getRest().execute(this,pred);
		}
	}
	
}

//public static void main(String[] args) {
//LRStruct<String> list = new LRStruct<String>();
//list.insertFront("Wilma").insertFront("Jo").insertFront("Mary").insertFront("Pebbles");
//list.insertFront("Dino").insertFront("Fred").insertFront("Barney");
//LRStruct<String> filteredList = list.execute(new Filter<String>(), new HasLengthFour());
//System.out.println("list is: "+list);
//System.out.println("filtered list is: "+filteredList);
//}
