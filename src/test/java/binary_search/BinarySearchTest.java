/**
 * Class with tests for the BinarySearch class
 *
 * @author David Kariuki
 * @since 14/7/2022
 */

package binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BinarySearchTest {


	/**
	 * Method to test if binary search was successful
	 */
	@Test
	void testBinarySearchReturn() {

		int targetNumber = 22; // Targeted number to get position

		// Int array
		int[] numArr = {2, 4, 8, 13, 14, 17, 19, 22, 23, 25, 30, 32, 34, 35, 36, 38, 41, 44, 45, 46, 49};

		// False positive if value not found in array
		assertNotEquals(-1, BinarySearch.binarySearch(numArr, targetNumber), () -> "Binary search should return value");
	}
}