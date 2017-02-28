package tests.multiset;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import multiset.MultiSet;


public class AddTests {

	private static int LARGE = 1000000;

	private MultiSet<String> _ds;
	private String _dsName = "MultiSet";

	@Before
	public void setup() {
		_ds = new MultiSet<String>();
	}

	@Test public void testAddUsingSize() {
		String s = "Fred";
		_ds.add(s);
		int expected = 1;
		int actual = _ds.size();
		assertTrue("I added \""+s+
			"\" to an initially empty "+_dsName+"<String>, "+
			"expecting its size to be "+expected+
			", but it was "+actual,
		expected == actual);
	}

	@Test public void testAddNullUsingSize() {
		String s = null;
		_ds.add(s);
		int expected = 1;
		int actual = _ds.size();
		assertTrue("I added \""+s+
			"\" to an initially empty "+_dsName+"<String>, "+
			"expecting its size to be "+expected+
			", but it was "+actual,
		expected == actual);
	}

	@Test public void testAddDuplicateUsingSize() {
		String s = "Fred";
		_ds.add(s);
		_ds.add(s);
		int expected = 2;
		int actual = _ds.size();
		assertTrue("I added \""+s+
			"\" twice to an initially empty "+_dsName+"<String>, "+
			"expecting its size to be "+expected+
			", but it was "+actual,
		expected == actual);
	}

	@Test public void testAddDuplicateUsingReturnValue() {
		String s = "Fred";
		boolean expected = true;
		_ds.add(s);
		boolean actual = _ds.add(s);
		assertTrue("I added \""+s+
			"\" twice to an initially empty "+_dsName+"<String>, "+
			"expecting add to return "+expected+
			" on the second insertion, but it returned "+actual,
		expected == actual);
	}

	@Test public void testAddDuplicateNullUsingSize() {
		MultiSet<String> ms = new MultiSet<String>();
		String s = "River";
		ms.add(s);
		ms.add(s);
		int expected = 2;
		int actual = ms.size();
		assertTrue("...",expected == actual);
	}

	@Test public void testAddUsingContains() {
		String s = "Fred";
		_ds.add(s);
		boolean expected = true;
		boolean actual = _ds.contains(s);
		assertTrue("I added \""+s+
			"\" to an initially empty "+_dsName+"<String>, "+
			"expecting it to be there, but it wasn't.",
		expected == actual);
	}

	@Test
	public void addOneStringSize() {
		String s = "";
		_ds.add(s);
		int expected = 1;
		int actual = _ds.size();
		assertTrue("I added one item to the "+_dsName+", expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	@Test
	public void addOneStringTwiceSize() {
		String s = "";
		_ds.add(s);
		_ds.add(s);
		int expected = 2;
		int actual = _ds.size();
		assertTrue("I added one item to the "+_dsName+" twice, expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	@Test
	public void addTwoStringsSize() {
		String s = "one";
		String t = "two";
		_ds.add(s);
		_ds.add(t);
		int expected = 2;
		int actual = _ds.size();
		assertTrue("I added two items to the "+_dsName+", expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	@Test
	public void addManyStringsSize() {
		String s = "one";
		int expected = LARGE;
		for (int i=0; i<expected; i++) {
			_ds.add(s);
		}
		int actual = _ds.size();
		assertTrue("I added "+expected+" items to the "+_dsName+", expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}
	
	// Tests written in lecture Spring 2014, originally in class MultiSetAddTests
	@Test public void test_01() {
		MultiSet<String> b;
		b = new MultiSet<String>();
		String s = "Fred";
		b.add(s);
		int expected = 1;
		int actual = b.size();
		assertTrue("I added the String \""+s+"\" to an initially empty MultiSet<String>, expecting its size to be "+expected+", but it turned out to be "+actual+".",
				expected == actual);
	}

	@Test public void test_02() {
		MultiSet<String> b;
		b = new MultiSet<String>();
		String s = "";
		b.add(s);
		int expected = 1;
		int actual = b.size();
		assertTrue("I added the String \""+s+"\" to an initially empty MultiSet<String>, expecting its size to be "+expected+", but it turned out to be "+actual+".",
				expected == actual);
	}

	@Test public void test_03() {
		MultiSet<String> b;
		b = new MultiSet<String>();
		int expected = 0;
		int actual = b.size();
		assertTrue("I created an empty MultiSet<String>, expecting its size to be "+expected+", but it turned out to be "+actual+".",
				expected == actual);
	}

	
}
