/**
 * 
 */
package net.sourceforge.jFuzzyLogic.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Test Cases By jesus Ojeda
 */
public class FuzzyLogicTest {
	FuzzyLogic fuzz;
	/**
	 * uses the constructor method
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fuzz = new FuzzyLogic();
	}

	/**
	 * Test's the negation method
	 */
	@Test
	public void testNegation() {
		float testFloat = 0.7f;
		float expected = 0.3f;
		assertEquals("Negation should return 1-value",expected, fuzz.negation(testFloat),0.001);
		System.out.println(fuzz.negation(testFloat));
		
	}

	/**
	 * Test's the union method.
	 */
	@Test
	public void testUnion() {
		
		float x = 0.6f;
		float y = 0.8f;
		float expected = Math.max(x, y);
		assertEquals("expected return is  the max of x and y:",expected,fuzz.union(x,y),0.001);
		
	}

	/**
	 * Test's the intersection method
	 */
	@Test
	public void testIntersection() {
		float x = 0.6f;
		float y = 0.8f;
		float expected = 1 - ((1-x) * (1-y));
		
		assertEquals("Intersection should return 1 - ((1-x)*(1-y))",expected, fuzz.intersection(x, y),0.001);
		assertEquals("Intersection with 0 should be the complement of the other value's complement",
				0.0f, fuzz.intersection(0, 0), 0.001);
		assertEquals("Intersection with 1 should be 1 ", 1.0f, fuzz.intersection(1, 0.5f),0.001);
	}

}