package functions;

public class Square implements UnaryFunction<Integer, Integer>{

	@Override
	public Integer apply(Integer arg) {
		return arg*arg;
	}

}
