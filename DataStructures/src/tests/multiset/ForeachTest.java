package tests.multiset;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import multiset.MultiSet;


public class ForeachTest {

	@Test
	public void foreach() {
		MultiSet<String> ms = new MultiSet<String>();
		ms.add("Fred");
		ms.add("Wilma");
		for (String s : ms) {
			if (s != null) {
				s.length();
			}
		}
		assertTrue(true);
	}

}
