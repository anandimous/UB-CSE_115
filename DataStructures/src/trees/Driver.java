package trees;

import brstruct.BRStruct;
import brstruct.visitors.traversals.InOrderVisitor;
import brstruct.visitors.traversals.PostOrderVisitor;
import brstruct.visitors.traversals.PreOrderVisitor;
import queues.AQueue;

public class Driver {
	public static void main(String[] args) {
		clicker2();
	}
	
	public static void clicker1() {
		BST<Integer> tree = new BST<Integer>();
		tree.insert(40);
		tree.insert(38);
		tree.insert(12);
		tree.insert(42);
		tree.insert(34);
		tree.insert(43);
		System.out.println("PRE: "+tree.preOrder());
		System.out.println("IN: " +tree.inOrder());
		System.out.println("POST: "+tree.postOrder());
	}

	private static <E> BRStruct<E> array2brs(E[] array) {
		return array2brs(array, 1);
	}
	
	private static <E> BRStruct<E> array2brs(E[] array, int i) {
		BRStruct<E> root = new BRStruct<E>();
		if (i<array.length) {
			root.insertRoot(array[i]);
			BRStruct<E> left = array2brs(array, 2*i);
			BRStruct<E> right = array2brs(array, 2*i+1);
			root.setLeft(left);
			root.setRight(right);
		}
		return root;
	}

	public static void clicker2() {
		Integer[] numbers = {0, 3, 7, 2, 1, 9, 6, 4};
		BRStruct<Integer> tree = array2brs(numbers);
		System.out.println("tree: " + tree);
		AQueue<Integer> q;
		q = new AQueue<Integer>();
		tree.execute(new PreOrderVisitor<Integer>(), q);
		System.out.println("PRE: "+q);
		q = new AQueue<Integer>();
		tree.execute(new InOrderVisitor<Integer>(), q);
		System.out.println("IN: "+q);
		q = new AQueue<Integer>();
		tree.execute(new PostOrderVisitor<Integer>(), q);
		System.out.println("POST: "+q);
	}

}
