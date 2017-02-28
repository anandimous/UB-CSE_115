package functions;

public interface BinaryFunction<O,I1,I2> {
	public O apply(I1 arg1, I2 arg2);
	public I2 identity();
}
