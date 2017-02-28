/**
 * 
 */
package utility;

/**
 * @author alphonce
 *
 */
public class Pair<A,B> {
	public A a;
	public B b;
	public Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		int[] x = {2,3,6,3,6,3,4,5,6,7,8,5,7,7};
		foo(x);
		return a.toString() + "\t" + b.toString();		
	}
	
	public void foo(int[] numbers)
	{
	}
	
	public static void main(String... args) {
		
	}
	
}
