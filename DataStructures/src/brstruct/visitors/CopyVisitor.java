package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

/**
 * @author alphonce
 * 
 * This visitor creates a copy of an existing BRStruct<E>
 */
public class CopyVisitor<E> implements IAlgo<BRStruct<E>,E,Object> {
	@Override public BRStruct<E> emptyCase(BRStruct<E> host, Object _) {
		return new BRStruct<E>();
	}
	@Override public BRStruct<E> nonEmptyCase(BRStruct<E> host, Object _) {
		BRStruct<E> copy = new BRStruct<E>();
		copy.insertRoot(host.getDatum());
		copy.setLeft(host.getLeft().execute(this, _));
		copy.setRight(host.getRight().execute(this, _));
		return copy;
	}
//	public static void main(String[] args) {
//		BRStruct<Integer> tree = new BST<Integer>().insert(5).insert(7).insert(3).insert(4).getTree();
//		BRStruct<Integer> copy = tree.execute(new CopyVisitor<Integer>(), null);
//		System.out.println("Original: "+tree);
//		System.out.println("Copy: "+copy);
//		// Show the two trees are independent
//		tree.setDatum(100);
//		copy.setDatum(-123);
//		System.out.println("Original: "+tree);
//		System.out.println("Copy: "+copy);
//		tree = new BRStruct<Integer>();
//		copy = tree.execute(new CopyVisitor<Integer>(), null);
//		System.out.println("Original: "+tree);
//		System.out.println("Copy: "+copy);
//		// Again, show copy is distinct from tree
//		copy.insertRoot(2);
//		System.out.println("Original: "+tree);
//		System.out.println("Copy: "+copy);
//	}
}
