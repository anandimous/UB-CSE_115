package functions;

public class True<E> implements Predicate<E> {

	@Override
	public Boolean apply(E arg) {
		return true;
	}

}
