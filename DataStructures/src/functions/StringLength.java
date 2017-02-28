package functions;

public class StringLength implements UnaryFunction<Integer, String>{

	@Override
	public Integer apply(String arg) {
		return arg.length();
	}

}
