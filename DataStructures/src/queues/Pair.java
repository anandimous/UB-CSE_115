package queues;

public class Pair<K, V> {
	public K key;
	public V val;
	public Pair(K k, V v) { 
		key = k;
		val = v;
	}
	@Override public String toString() {
		return "(" + key.toString() + ":" + val.toString() + ")";
	}
}
