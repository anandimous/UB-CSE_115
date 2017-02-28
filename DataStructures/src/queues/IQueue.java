package queues;

public interface IQueue<E> {

	public void enqueue(E item);

	public E dequeue();

	public E peek();

	public boolean isEmpty();

	public String name();

}