package sorters;
/**
 * @author alphonce
 *
 * Interface for sorting algorithms:
 * they have a sort method (!)
 */
public interface ISorter<E extends Comparable<E>> {
	public void sort(E[] array);
	public String name();
}
