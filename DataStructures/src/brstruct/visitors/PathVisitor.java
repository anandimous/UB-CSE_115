package brstruct.visitors;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

public class PathVisitor<E> implements IAlgo<String,E,E> {
	@Override public String emptyCase(BRStruct<E> host, E value) {
		return "";
	}
	@Override public String nonEmptyCase(BRStruct<E> host, E value) {
		if (value.equals(host.getDatum())) { return "."; }
		
		String left = host.getLeft().execute(this, value);
		if (left.length() > 0) { return "L" + left; }
		
		String right = host.getRight().execute(this, value);
		if (right.length() > 0) { return "R" + right; }
		
		return "";
	}
	
//	public static void main(String[] args) {
//		BST<Integer> tree = new BST<Integer>();
//		tree.insert(5).insert(3).insert(1).insert(4).insert(7).insert(6).insert(8);
//		BRStruct<Integer> t = tree.getTree();
//		System.out.println(t.execute(new PathVisitor<Integer>(), 1));
//		System.out.println(t.execute(new PathVisitor<Integer>(), 3));
//		System.out.println(t.execute(new PathVisitor<Integer>(), 4));
//		System.out.println(t.execute(new PathVisitor<Integer>(), 5));
//		System.out.println(t.execute(new PathVisitor<Integer>(), 6));
//		System.out.println(t.execute(new PathVisitor<Integer>(), 7));
//		System.out.println(t.execute(new PathVisitor<Integer>(), 8));
//		System.out.println("--");
//		System.out.println(t.execute(new PathVisitor<Integer>(), 0));
//		System.out.println("--");
//	}
}
