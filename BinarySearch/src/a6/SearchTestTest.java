package a6;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTestTest {

	@Test
	public void testRandomSortedFill() {
		int[] test_data = new int[3];
		SearchTest.randomSortedFill(test_data);
		assertEquals("length changed", 3, test_data.length);		
	}

	@Test
	public void testNRepetitions() {
		double[] results = SearchTest.testNRepetitions(1, 1);
		// 1 item in the array always takes 1 check to find.
		assertEquals("failed simple check for binary", 1.0, results[0], 1e-9);		
		assertEquals("failed simple check for sequential", 1.0, results[1], 1e-9);		
	}

}
