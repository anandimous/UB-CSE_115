package functions;

public class ID<E> implements UnaryFunction<E,E> {
	@Override public E apply(E arg) { return arg; }
}
