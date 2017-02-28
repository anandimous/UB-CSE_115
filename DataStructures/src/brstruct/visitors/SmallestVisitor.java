package brstruct.visitors;

import java.util.NoSuchElementException;

import brstruct.BRStruct;
import brstruct.BRStruct.IAlgo;

/**
 * @author alphonce
 * 
 * This visitor traverses a BRStruct looking for the smallest value.
 * If the tree is empty, a NoSuchElementException is thrown.
 */
public class SmallestVisitor<E extends Comparable<E>> implements IAlgo<E,E,Object> {
	@Override
	public E emptyCase(BRStruct<E> host, Object _) {
		throw new NoSuchElementException("An empty BRStruct has no smallest value.");
	}
	@Override
	public E nonEmptyCase(BRStruct<E> host, Object _) {
		return host.execute(new IAlgo<E,E,E>() {
			@Override public E emptyCase(BRStruct<E> host, E candidate) {
				return candidate;
			}
			@Override public E nonEmptyCase(BRStruct<E> host, E candidate) {
				return host.getRight().execute(this,host.getLeft().execute(this,host.getDatum().compareTo(candidate)<0 ? host.getDatum() : candidate));
			}
		}, host.getDatum());
	}
//	public static void main(String[] args) {
//		BRStruct<Integer> tree = new BST<Integer>().insert(5).insert(7).insert(3).insert(4).getTree();
//		System.out.println("Smallest in "+tree+" is "+tree.execute(new SmallestVisitor<Integer>(), null));
//		tree = new BRStruct<Integer>();
//		System.out.println("Smallest in "+tree+" is "+tree.execute(new SmallestVisitor<Integer>(), null));
//	}
}
