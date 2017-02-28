package tests.multiset;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import multiset.MultiSet;


public class IsEmptyTests{

	private MultiSet<String> _ms;
	private String _item;

	@Before
	public void setUp() {
		_ms = new MultiSet<String>();
		_item = "Fred";
	}
	
	@After
	public void tearDown() throws Exception {
		_ms = null;
		_item = null;
	}

	@Test
	public void testIsEmptyWithEmpty() {
		boolean expected = true;
		boolean actual = _ms.isEmpty();
		assertTrue("I called isEmpty() on an empty MultiSet<String> expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testIsEmptyWithNonEmpty() {
		boolean expected = false;
		_ms.add(_item);
		boolean actual = _ms.isEmpty();
		assertTrue("I called isEmpty() on a non-empty MultiSet<String> expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}
}
