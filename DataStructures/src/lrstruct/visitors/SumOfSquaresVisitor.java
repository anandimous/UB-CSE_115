package lrstruct.visitors;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class SumOfSquaresVisitor implements IAlgo<Integer,Integer,Object> {

	@Override public Integer emptyCase(LRStruct<Integer> host, Object _) {
		return 0;
	}

	@Override public Integer nonEmptyCase(LRStruct<Integer> host, Object _) {
		return (int) Math.pow(host.getDatum(), 2) + host.getRest().execute(this, _);
	}
	
	@Test public void testEmpty() {
		LRStruct<Integer> list = new LRStruct<Integer>();
		int expected = 0;
		int actual = list.execute(new SumOfSquaresVisitor(), null);
		assertTrue("", expected == actual);
	}
	
	@Test public void testNonEmpty() {
		LRStruct<Integer> list = new LRStruct<Integer>();
		list.insertFront(6).insertFront(7).insertFront(2).insertFront(5);
		int expected = 36+49+4+25;
		int actual = list.execute(new SumOfSquaresVisitor(), null);
		assertTrue("", expected == actual);
	}

}
