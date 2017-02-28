package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class Visitor implements IAlgo<Integer,Integer,Object> {

	@Override public Integer emptyCase(BRStruct<Integer> host, Object _) {
	// DEFINE WHAT HAPPENS WHEN THE TREE IS EMPTY HERE

		return 0;

	}

	@Override public Integer nonEmptyCase(BRStruct<Integer> host, Object _) {
	// DEFINE WHAT HAPPENS WHEN THE TREE IS NOT EMPTY HERE

		return (host.getDatum()>0 ? host.getDatum() : 0) + host.getLeft().execute(this, _) + host.getRight().execute(this,_);

	}
	
	public static void main(String[] args) {
		BRStruct<Integer> t = new BRStruct<Integer>();
		t.insertRoot(2);
		t.setLeft(new BRStruct<Integer>().insertRoot(1));
		t.setRight(new BRStruct<Integer>().insertRoot(3));
		System.out.println(t);
		System.out.println(t.execute(new Visitor(), null));

		t = new BRStruct<Integer>();
		t.insertRoot(2);
		t.setLeft(new BRStruct<Integer>().insertRoot(-4));
		t.setRight(new BRStruct<Integer>().insertRoot(6));
		System.out.println(t);
		System.out.println(t.execute(new Visitor(), null));

	}
}
