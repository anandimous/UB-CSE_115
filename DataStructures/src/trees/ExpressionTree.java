package trees;

public class ExpressionTree<A> {
	private ExpressionTree<A> L, R;
	private Operation<A,A,A> op;
	public ExpressionTree(ExpressionTree<A> L, ExpressionTree<A> R, Operation<A,A,A> op) {
		this.L = L; this.R = R;
		this.op = op;
	}
	public A evaluate() {
		return op.apply(L.evaluate(), R.evaluate());	
	}
	@Override public String toString() {
		return "(" + L.toString() + " " + op.toString() + " " + R.toString() + ")";
	}
}
