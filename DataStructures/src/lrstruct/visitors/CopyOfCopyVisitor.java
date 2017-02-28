package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class CopyOfCopyVisitor<E> implements IAlgo<LRStruct<E>, E, Object> {

	@Override
	public LRStruct<E> emptyCase(LRStruct<E> host, Object _) {
		LRStruct<E> answer = new LRStruct<E>();
		System.out.println("In the empty case, the answer is "+answer);
		return answer;
	}

	@Override
	public LRStruct<E> nonEmptyCase(LRStruct<E> host, Object _) {
		System.out.println("I am copying the list "+host);
		LRStruct<E> copyOfRest = host.getRest().execute(this,_);
		System.out.println("The rest of host is "+host.getRest()+", and a copy is "+copyOfRest);
		E datum = host.getDatum();
		System.out.println("The datum of host is "+datum);
		LRStruct<E> answer = copyOfRest.insertFront(datum);
		System.out.println("A copy of host, "+host+", is "+answer);
		return answer;
	}
	
	public static void main(String[] args) {
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Wilma").insertFront("Fred");
		list.execute(new CopyOfCopyVisitor<String>(), null);
	}
	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	public static void main(String[] args) {
//		LRStruct<String> list1 = new LRStruct<String>();
//		list1.insertFront("C").insertFront("B").insertFront("A");
//		LRStruct<String> list2 = list1.execute(new CopyVisitor<String>(), null);
//		System.out.println("BEFORE:");
//		System.out.println("list1 is "+ list1);
//		System.out.println("list2 is "+ list2);
//		
//		list1.removeFront();
//		list1.setDatum("XYZ");
//		System.out.println("AFTER:");
//		System.out.println("list1 is "+ list1);
//		System.out.println("list2 is "+ list2);
//	}

}
