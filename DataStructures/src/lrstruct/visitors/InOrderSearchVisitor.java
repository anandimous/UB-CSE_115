package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class InOrderSearchVisitor<E extends Comparable<E>> implements IAlgo<LRStruct<E>,E,E> {
	@Override
	public LRStruct<E> emptyCase(LRStruct<E> host, E target) { // insert 4 into (2 3)
		return host;
	}
	@Override
	public LRStruct<E> nonEmptyCase(LRStruct<E> host, E target) {
		// insert 4 into (1 2 5)
		if (host.getDatum().compareTo(target) <= 0) { // handle insert 4 into (5...)
			return host;
		}
		else { // keep going, case is insert 4 into (1 ...)
			return host.getRest().execute(this, target);
		}
	}

	public static void main(String[] args) {
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Pebbles").insertFront("Fred").insertFront("Wilma");
		System.out.println("The list is "+list);
		LRStruct<String> temp = list.execute(new InOrderSearchVisitor<String>(),"Fred");
		System.out.println(temp);
		temp.removeFront();
		System.out.println(temp);		
		System.out.println(list);
	}

}
