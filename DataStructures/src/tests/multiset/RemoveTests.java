package tests.multiset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import multiset.MultiSet;

public class RemoveTests {
	
	private static int LARGE = 10000;
	
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
	public void addOneRemoveOneSize() {
		_ms = new MultiSet<String>();
		_item = "";
		_ms.add(_item);
		_ms.remove(_item);
		int expected = 0;
		int actual = _ms.size();
		assertTrue("I added and removed one item from the MultiSet, expecting its size to be "+expected+", but its size was "+actual, actual == expected);
	}

	/* 
	 * Test one aspect of remove functionality: removing an item
	 * which is not in the MultiSet should not change the collection.
	 */
	@Test
	public void testRemoveNonMember() {
		setUp();
		boolean answer = _ms.remove(_item);
		assertFalse("I expected the MultiSet to not change on removal, but it did",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: after removing an 
	 * inserted item, it should not be there.
	 */
	@Test
	public void testRemoveMember() {
		_ms.add(_item);
		boolean answer = _ms.remove(_item);
		assertTrue("I expected the MultiSet to change on removal, but it didn't",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: after removing an 
	 * inserted item, the size of the MultiSet should be one smaller 
	 * than before.
	 */
	@Test
	public void testRemoveMemberUsingSize() {
		_ms.add(_item);
		int initialSize = _ms.size(); 
		_ms.remove(_item);
		int finalSize = _ms.size(); 
		assertTrue("The MultiSet should have size "+(initialSize-1)+", but its size is "+finalSize,
				   finalSize == initialSize-1);
	}

	/* 
	 * Test one aspect of remove functionality: after inserting
	 * the same item twice, and removing it once, the size of the
	 * MultiSet should be one smaller than before removal and it should
	 * still contain the item.
	 */
	@Test
	public void testRemoveOneOfTwoMembersUsingSize() {
		_ms.add(_item);
		_ms.add(_item);
		int initialSize = _ms.size();
		_ms.remove(_item);
		int finalSize = _ms.size();
		assertTrue("The MultiSet should have size "+(initialSize-1)+" and still contain one copy of the inserted item; its size is "+finalSize+" and contains(item) is "+_ms.contains(_item),
				   _ms.contains(_item) && finalSize == initialSize-1);
	}

	/* 
	 * Test adding and removing a large number of elements.
	 */
	@Test
	public void testAddingAndRemovingMany() {
		for (int i=0; i < LARGE; i++) {
			_ms.add(_item);
		}
		for (int i=0; i < LARGE; i++) {
			_ms.remove(_item);
		}
		int expectedSize = 0;
		int actualSize = _ms.size();
		assertTrue("The MultiSet should have size "+expectedSize+", but its size is "+actualSize, expectedSize == actualSize);
	}

	/* 
	 * Test one aspect of remove functionality: removing null
	 */
	@Test
	public void testRemoveNull() {
		setUp();
		_ms.add("Fred");
		_item = null;
		boolean answer = _ms.remove(_item);
		assertFalse("I expected the MultiSet to not change on removal, but it did",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: removing from a MultiSet 
	 * containing
	 */
	@Test
	public void testRemoveFromMultiSetContainingNull() {
		setUp();
		_ms.add(null);
		boolean answer = _ms.remove(_item);
		assertFalse("I expected the MultiSet to not change on removal, but it did",
				   answer);
	}

	/* 
	 * Test one aspect of remove functionality: removing null from a MultiSet 
	 * containing null
	 */
	@Test
	public void testRemoveNullFromMultiSetContainingNull() {
		setUp();
		_ms.add(null);
		_item = null;
		boolean answer = _ms.remove(_item);
		assertTrue("I expected the MultiSet to not change on removal, but it did",
				   answer);
	}
	
	@Test
	public void testAddManyRemoveMany() {
		setUp();
		int expected = _ms.size();
		for (int i=0; i<LARGE; i=i+1) {
			_ms.add(_item);
		}
		for (int i=0; i<LARGE; i=i+1) {
			_ms.remove(_item);
		}
		int actual = _ms.size();
		assertTrue("",expected == actual);
	}

}
