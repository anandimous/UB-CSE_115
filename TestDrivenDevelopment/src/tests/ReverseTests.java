package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.StringUtilities;

public class ReverseTests {

	/*
	 * Private helper method
	 * This method is called by test 'test' methods below.  Each test method supplies
	 * the values for input and expected. 
	 */
	private void commonTestCode(String input, String expected) {
		StringUtilities su = new StringUtilities();
		String actual = su.reverse(input);
		assertTrue("I expected the reverse of "+format(input)+" to be "+format(expected)+", but is was "+format(actual)+".", expected.equals(actual));
	}
	
	/*
	 * Private helper method
	 * This method formats a String value for printing so that we can see the start and
	 * end of the String, and also distinguish between the value null and the String 
	 * "null".
	 * 
	 * System.out.println("Fred") prints Fred
	 * System.out.println(format("Fred")) prints "Fred" 
	 * 
	 * System.out.println(null) prints null
	 * System.out.println(format(null)) prints null 
	 * 
	 * System.out.println("null") prints null
	 * System.out.println(format("null")) prints "null" 
	 */
	private String format(String s) {
		if (s == null) { return "null"; }
		else { return "\"" + s + "\""; }
	}
	
	@Test public void test01() {
		String input = null;
		String expected = null;
		StringUtilities su = new StringUtilities();
		String actual = su.reverse(input);
		assertTrue("I expected the reverse of "+format(input)+" to be "+format(expected)+", but is was "+format(actual)+".", expected == actual);
	}
	@Test public void test02() { commonTestCode("null","llun"); }
	@Test public void test03() { commonTestCode("",""); }
	@Test public void test04() { commonTestCode("mom","mom"); }
	@Test public void test05() { commonTestCode("mother","rehtom"); }
	@Test public void test06() { commonTestCode("Dad","daD"); }
	@Test public void test07() { commonTestCode("I am","ma I"); }
	@Test public void test08() { commonTestCode("42","24"); }
	@Test public void test09() { commonTestCode("3124","4213"); }
	@Test public void test10() { commonTestCode("abc","cba"); }
	@Test public void test11() { commonTestCode("abcd","dcba"); }
	@Test public void test12() { commonTestCode("she is a girl","lrig a si ehs"); }
	@Test public void test13() { commonTestCode("manam","manam"); }
	@Test public void test14() { commonTestCode("n\\hello","olleh\\n"); }

}
