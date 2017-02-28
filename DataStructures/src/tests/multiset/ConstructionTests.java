package tests.multiset;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import multiset.MultiSet;

public class ConstructionTests {

	@Test
	public void testEmptyMultiSetHasSizeZero() {
		MultiSet<String> ms = new MultiSet<String>();
		int expected = 0;
		int actual = ms.size();
		assertTrue("I created an new MultiSet<String>, expecting its size to be "+expected
				   +", but its size was "+actual, expected == actual);
	}

	@Test
	public void testEmptyMultiSetDoesNotContainANonEmptyString() {
		MultiSet<String> ms = new MultiSet<String>();
		String s = "Fred";
		boolean expected = false;
		boolean actual = ms.contains(s);
		assertTrue("I created an new MultiSet<String>, expecting \""+s+"\" to NOT be in the MultiSet, but it was",
				   expected == actual);
	}

	@Test
	public void testEmptyMultiSetDoesNotContainEmptyString() {
		MultiSet<String> ms = new MultiSet<String>();
		String s = "";
		boolean expected = false;
		boolean actual = ms.contains(s);
		assertTrue("I created an new MultiSet<String>, expecting \""+s+"\" to NOT be in the MultiSet, but it was",
				   expected == actual);
	}

	@Test
	public void testEmptyMultiSetDoesNotContainNull() {
		MultiSet<String> ms = new MultiSet<String>();
		String s = null;
		boolean expected = false;
		boolean actual = ms.contains(s);
		assertTrue("I created an new MultiSet<String>, expecting 'null' to NOT be in the MultiSet, but it was",
				   expected == actual);
	}

}
