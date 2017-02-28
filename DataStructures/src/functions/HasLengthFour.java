package functions;

public class HasLengthFour implements Predicate<String> {

	@Override
	public Boolean apply(String arg) {
		return arg.length() == 4;
	}

}
