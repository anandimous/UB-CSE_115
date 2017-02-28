package tests.multiset;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import multiset.MultiSet;

public class ContainsTests{

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
	public void testEmptyContainsNone() {
		boolean expected = false;
		boolean actual = _ms.contains(_item);
		assertTrue("I checked whether an empty MultiSet<String> contained \""+_item+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testAddThenContains() {
		_ms.add(_item);
		boolean expected = true;
		boolean actual = _ms.contains(_item);
		assertTrue("I added \""+_item+"\" to an empty MultiSet<String>, and then check whether it contained \""+_item+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testContainsNonNullNo() {
		String varNull = null;
		_ms.add(_item);
		_ms.add(varNull);
		_ms.add(_item);
		_ms.add(varNull);
		_ms.add(_item);
		_ms.add(varNull);
		String other = _item + "!@#";
		boolean expected = false;
		boolean actual = _ms.contains(other);
		assertTrue("I added \""+_item+"\" and "+varNull+" to an empty MultiSet<String>, and then check whether it contained \""+other+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testContainsNullYes() {
		_ms.add(_item);
		String varNull = null;
		_ms.add(varNull);
		boolean expected = true;
		boolean actual = _ms.contains(varNull);
		assertTrue("I added \""+_item+"\" and "+varNull+" to an empty MultiSet<String>, and then check whether it contained \""+varNull+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test
	public void testContainsNullNo() {
		_ms.add(_item);
		String _item2 = null;
		boolean expected = false;
		boolean actual = _ms.contains(_item2);
		assertTrue("I added \""+_item+"\" to an empty MultiSet<String>, and then check whether it contained \""+_item2+"\", expecting the answer to be '"+expected+"', but it was '"+actual+"'.",
				   expected == actual);
	}

	@Test public void testRemoveUsingSize() {
		MultiSet<String> ms = new MultiSet<String>();
		String s1 = "Fred1";
		String s2 = "Fred2";
		String s3 = "Fred3";
		ms.add(s1); ms.add(s2); ms.add(s3);
		ms.remove(s2);
		boolean expected = true;
		boolean actual = ms.contains(s3);
		assertTrue("", expected == actual);
	} 

}
