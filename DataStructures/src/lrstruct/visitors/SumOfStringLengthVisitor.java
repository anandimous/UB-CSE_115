package lrstruct.visitors;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lrstruct.LRStruct;
import lrstruct.LRStruct.IAlgo;

public class SumOfStringLengthVisitor implements IAlgo<Integer,String,Object>{

	@Override
	public Integer emptyCase(LRStruct<String> host, Object arg) {
		return 0;
	}

	@Override
	public Integer nonEmptyCase(LRStruct<String> host, Object arg) {
		return host.getDatum().length() + host.getRest().execute(this, arg);
	}

	@Test public void testEmpty() {
		LRStruct<String> list = new LRStruct<String>();
		int expected = 0;
		int actual = list.execute(new SumOfStringLengthVisitor(), null);
		assertTrue("", expected == actual);
	}
	
	@Test public void testNonEmpty() {
		LRStruct<String> list = new LRStruct<String>();
		list.insertFront("Amy").insertFront("Sally").insertFront("Bob");
		int expected = 11;
		int actual = list.execute(new SumOfStringLengthVisitor(), null);
		assertTrue("", expected == actual);
	}

}
