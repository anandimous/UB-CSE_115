package brstruct;

import java.util.Arrays;

public class BRStructFromArray {
	
	public static void main(String[] args) {
		int[] array = {-1, 15,43,27,82,94,78,36};  // first value is a dummy value
		BRStruct<Integer> tree = array2brs(array, 1);
		System.out.println(Arrays.toString(array) + " to brs --> " + tree);
	}

	private static BRStruct<Integer> array2brs(int[] array, int i) {
		BRStruct<Integer> root = new BRStruct<Integer>();
		if (i<array.length) {
			root.insertRoot(array[i]);
			BRStruct<Integer> left = array2brs(array, 2*i);
			BRStruct<Integer> right = array2brs(array, 2*i+1);
			root.setLeft(left);
			root.setRight(right);
		}
		return root;
	}

}
