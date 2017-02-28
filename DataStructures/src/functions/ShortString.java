package functions;

public class ShortString implements Predicate<String> {
	@Override public Boolean apply(String arg) {
		return arg.length() < 5;
	}
}
