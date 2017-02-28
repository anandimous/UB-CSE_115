package tests.lists;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lists.DoublyLinkedList;

public class AddTests {

	@Test public void test01() { common("( )"); }
	@Test public void test02() { common("( Fred )","Fred"); }
	@Test public void test03() { common("( Fred Wilma )", "Fred", "Wilma"); }

	private void common(String expected, String... values) {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		for (String s : values) {
			list.add(s);
		}
		String actual = list.toString();
		assertTrue("", expected.equals(actual));
	}

}
