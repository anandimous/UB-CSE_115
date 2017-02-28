package functions;

public class Identity<I> implements UnaryFunction<I, I>{

	@Override
	public I apply(I arg) {
		return arg;
	}

}
