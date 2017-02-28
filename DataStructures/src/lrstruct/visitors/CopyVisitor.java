package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class CopyVisitor<E> implements IAlgo<LRStruct<E>, E, Object> {

	@Override
	public LRStruct<E> emptyCase(LRStruct<E> host, Object _) {
		LRStruct<E> answer = new LRStruct<E>();
		System.out.println("A copy of "+host+" is "+answer);
		return answer;
	}

	@Override
	public LRStruct<E> nonEmptyCase(LRStruct<E> host, Object _) {
		System.out.println("A copy of "+host+" is constructed by first copying its rest...");
		LRStruct<E> copyOfRest = host.getRest().execute(this,_);
		System.out.println("A copy of "+host+"'s rest is "+copyOfRest);
		LRStruct<E> answer = copyOfRest.insertFront(host.getDatum());
		System.out.println("Therefore a copy of "+host+" is "+answer);				
		return answer;
	}
	
	public static void main(String[] args) {
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Wilma").insertFront("Fred");
		list.execute(new CopyVisitor<String>(), null);
	}
	
}

