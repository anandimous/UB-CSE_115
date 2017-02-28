package trees;

public interface Operation<T1, T2, T3> {
	public T3 apply(T1 a1, T2 a2);
}
