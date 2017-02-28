package functions;

public class Negate implements UnaryFunction<Integer, Integer>{

	@Override
	public Integer apply(Integer arg) {
		return -arg;
	}
	
}
