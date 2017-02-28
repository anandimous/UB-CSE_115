package tests.visitors;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lrstruct.LRStruct;
import lrstruct.visitors.SumVisitor;

public class SumVisitorTests {

	@Test public void test() {
		LRStruct<Integer> list;
		list = new LRStruct<Integer>();
		list.insertFront(3).insertFront(7).insertFront(5);
		int expected = 15;
		int actual = list.execute(new SumVisitor(), null);
		assertTrue("I expected the sum to be "+expected+" but it was "+actual,
				expected == actual);
	}

}
