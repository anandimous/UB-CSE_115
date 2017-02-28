package tests.multiset;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import multiset.MultiSet;


public class IteratorTests {

	private Iterator<String> _itE;
	private Iterator<String> _itNE;
	
	@Before
	public void setup() {
		MultiSet<String> ms1 = new MultiSet<String>();
		_itE = ms1.iterator();
		MultiSet<String> ms2 = new MultiSet<String>();
		ms2.add("Fred");
		ms2.add("Wilma");
		ms2.add("Pebbles");
		_itNE = ms2.iterator();
	}
	
	
	
	
	@Test
	public void callingNextOnEmptyLongWay() {
		try {
			while (_itE.hasNext()) {
				_itE.next();
			}
			// _itE.hasNext() must return false at this point
			_itE.next();
			fail("I called next on an iterator when hasNext() returns false, expecting an exception to be thrown, but none was.");
		}
		catch(NoSuchElementException e) {
			assertTrue(true); // test passes
		}
		catch(Exception e) {
			fail("I called next on an iterator when hasNext() returns false, expecting a NoSuchElementException to be thrown, but this kind of exception was thrown: "+e.getClass().getCanonicalName());
		}
	}
	
	
	
	
	@Test(expected=NoSuchElementException.class)
	public void callingNextOnEmpty() {
		while (_itE.hasNext()) {
			_itE.next();
		}
		_itE.next();
	}

	@Test(expected=NoSuchElementException.class)
	public void callingNextAtEnd() {
		while (_itNE.hasNext()) {
			_itNE.next();
		}
		_itNE.next();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void callingRemove() {
		_itNE.remove();
	}
}
