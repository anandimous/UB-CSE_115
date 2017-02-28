package lists;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class SortedList<E extends Comparable<E>> {
	private LRStruct<E> _list;
	public SortedList() { _list = new LRStruct<E>(); }
	public void add(final E item) {
		_list.execute(new IAlgo<Void,E,Void>() {
			@Override public Void emptyCase(LRStruct<E> host, Void arg) {
				host.insertFront(item);
				return null;
			}
			@Override public Void nonEmptyCase(LRStruct<E> host, Void arg) {
				if (item.compareTo(host.getDatum()) <= 0) {
					host.insertFront(item);
				}
				else {
					host.getRest().execute(this, arg);
				}
				return null;
			}
		}, null);
	}
	@Override public String toString() { return _list.toString(); }

	public static void main(String[] args) {
		String[] in = {"River","Zoë","Mal","Kaylee","Simon"};
		SortedList<String> list = new SortedList<>();
		for (String s : in) {
			list.add(s);;
			System.out.println(list);
		}
	}
}
