package functions;

public class Constant implements UnaryFunction<Integer,Integer> {
	private int constant;
	public Constant(int c) { constant = c; }
	@Override public Integer apply(Integer arg) { return constant; }
}
