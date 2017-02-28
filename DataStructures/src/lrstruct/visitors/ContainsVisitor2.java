package lrstruct.visitors;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class ContainsVisitor2<E> implements IAlgo<Boolean,E,Object> {
	@Override
	public Boolean emptyCase(LRStruct<E> host, Object target) {
		return false;
	}
	@Override
	public Boolean nonEmptyCase(LRStruct<E> host, Object target) {
		if (target.equals(host.getDatum())) {
			return true;
		}
		else {
			return host.getRest().execute(this, target);
		}
	}
	
	public static void main(String[] args) {
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Pebbles").insertFront("Fred").insertFront("Wilma");
		System.out.println(list.execute(new ContainsVisitor2<String>(),"Bambam"));
	}
}
