package functions;

public class Compose<A,B,C>
	implements BinaryFunction<UnaryFunction<C,A>,UnaryFunction<B,A>,UnaryFunction<C,B>> {

	@Override public UnaryFunction<C, A> apply(final UnaryFunction<B, A> f, final UnaryFunction<C, B> g) {
		return new UnaryFunction<C,A>() {
			@Override public C apply(A arg) { return g.apply(f.apply(arg)); }
		};
	}

	@Override public UnaryFunction<C, B> identity() {
		return new UnaryFunction<C,B>() {
			@SuppressWarnings("unchecked")
			@Override public C apply(B arg) { return (C) arg; }
		};
	}
}