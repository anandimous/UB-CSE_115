package functions;

public class Sum implements BinaryFunction<Integer,Integer,Integer> {
	@Override public Integer apply(Integer arg1, Integer arg2) {
		return arg1+arg2;
	}
	@Override public Integer identity()                        { 
		return 0;
	}
}
