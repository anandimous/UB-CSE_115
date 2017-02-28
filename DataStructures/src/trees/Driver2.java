package trees;

public class Driver2 {
	public static void main(String[] args) {
		BSTArray<Integer> t1 = new BSTArray<Integer>();
		t1.insert(8).insert(4).insert(2).insert(6).insert(1).insert(3).insert(5).insert(7);
		System.out.println(t1);
		t1.remove(8);
		System.out.println(t1);
		t1.remove(4);
		System.out.println(t1);
	}
}
