package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class ContainsVisitor<E> implements IAlgo<LRStruct<E>,E,E> {
	@Override
	public LRStruct<E> emptyCase(LRStruct<E> host, E target) {
		return host;
	}
	@Override
	public LRStruct<E> nonEmptyCase(LRStruct<E> host, E target) {
		if (target.equals(host.getDatum())) {
			return host;
		}
		else {
			return host.getRest().execute(this, target);
		}
	}

//	<boolean expr> ? <then-expr> : <else-expr>
//	return target.equals(host.getDatum()) ? true : host.getRest().execute(this, target);
	

	public static void main(String[] args) {
//		LRStruct<String> list = new LRStruct<String>();
//		list.insertFront("Pebbles").insertFront("Fred").insertFront("Wilma");
//		ContainsVisitor<String> v = new ContainsVisitor<String>();
////		System.out.println(list.execute(v,"Bambam"));
//		LRStruct<String> temp = list.execute(v,"Fred");
//		System.out.println("                     list: " + list);
//		System.out.println("temp before removeFront(): " + temp);
//		temp.removeFront();
//		System.out.println(" temp after removeFront(): " + temp);
//		System.out.println("                     list: " + list);

		LRStruct<Integer> list = new LRStruct<Integer>();
		list.insertFront(8).insertFront(2).insertFront(7).insertFront(3).insertFront(5);
		ContainsVisitor<Integer> v = new ContainsVisitor<Integer>();
		LRStruct<Integer> temp = list.execute(v,7);
		System.out.println("                     list: " + list);
		System.out.println("temp before removeFront(): " + temp);
		temp.removeFront();
		System.out.println(" temp after removeFront(): " + temp);
		System.out.println("                     list: " + list);
		
	}
}
