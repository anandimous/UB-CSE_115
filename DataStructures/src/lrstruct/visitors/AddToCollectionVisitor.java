package lrstruct.visitors;

import java.util.HashSet;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class AddToCollectionVisitor implements IAlgo<HashSet<String>,String,Integer> {

	@Override public HashSet<String> emptyCase(LRStruct<String> host, Integer maxLength) {
		return new HashSet<String>();
	}

	@Override public HashSet<String> nonEmptyCase(LRStruct<String> host, Integer maxLength) {
		HashSet<String> answer = host.getRest().execute(this, maxLength);
		if (host.getDatum().length() <= maxLength) {
			answer.add(host.getDatum());
		}
		return answer;
	}
	
	public static void main(String[] args) {
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Fred");
		list.insertFront("Wilma");
		list.insertFront("Betty");
		list.insertFront("Wilma");
		list.insertFront("Pebbles");
		HashSet<String> answer = list.execute(new AddToCollectionVisitor(), 5);
		System.out.println(answer);
	}

}
