package stack;

public interface IStack<E> {

	public abstract void push(E item);

	public abstract E pop();

	public abstract E peek();

	public abstract boolean isEmpty();

}