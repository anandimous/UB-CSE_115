package tests.multiset;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import multiset.MultiSet;

public class SizeTests{

	private MultiSet<String> _ms;
	private String _item;

	@Before
	public void setUp() {
		_ms = new MultiSet<String>();
		_item = new String();
	}
	
	@After
	public void tearDown() throws Exception {
		_ms = null;
		_item = null;
	}

	@Test
	public void testFlexibleSize() {
		int totalItems = 12;
		for (int i=0; i< totalItems; i++) {
			_ms.add(_item);
		}
		assertTrue("MultiSet should contain "+totalItems + ", but size is "+_ms.size(),
				totalItems == _ms.size());
	}

	@Test
	public void testFlexibleReSize() {
		int totalItems = 12;
		for (int i=0; i< totalItems; i++) {
			_ms.add(_item);
		}
		for (int i=0; i< totalItems; i++) {
			_ms.remove(_item);
		}
		for (int i=0; i< totalItems; i++) {
			_ms.add(_item);
		}
		assertTrue("MultiSet should contain "+totalItems + ", but size is "+_ms.size(),
				totalItems == _ms.size());
	}

	@Test
	public void testSizeOfFourOfSame() {
		_ms.add(_item);
		_ms.add(_item);
		_ms.add(_item);
		_ms.add(_item);
		int expectedSize = 4;
		int finalSize = _ms.size();
		assertTrue("I expected the final size to be " + expectedSize + " but it was " + finalSize,
				   finalSize == expectedSize);
	}

	@Test
	public void testSizeOfEmpty() {
		int expectedSize = 0;
		int finalSize = _ms.size();
		assertTrue("I expected the final size to be " + expectedSize + " but it was " + finalSize,
				   finalSize == expectedSize);
	}
}
