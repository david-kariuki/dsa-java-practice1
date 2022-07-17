/**
 * Class with tests for the BinarySearch class
 *
 * @author David Kariuki
 * @see #testBinarySearchReturn()
 * @see BinarySearch#binarySearch(Type, Type)
 * @see BinarySearch#findBooleanBoundary(Type, Type)
 * @see BinarySearch#getFirstElementNotSmallerThanTarget(Type, Type)
 * @since 14/7/2022
 */

package binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SuppressWarnings("ExcessiveLambdaUsage")
public class BinarySearchTest {

	/**
	 * Method to test successful binary search with message from Supplier<String>
	 * @apiNote - False positive if value not found in array (Returns -1)
	 */
	@Test
	void testBinarySearchReturnNotEquals() {

		int targetNumber = 22; // Targeted number to get index
		boolean targetBoundary = false;

		// Int array
		int[] numArr = {2, 4, 8, 13, 14, 17, 19, 22, 22, 23, 25, 30, 32, 34, 35, 36, 38, 41, 44, 45, 46, 49};

		// Boolean array
		boolean[] boolArray = new boolean[]{false, false, false, true, true};

		String message = "Binary search should return index >= 0 from integer array";

		assertNotEquals(-1, BinarySearch.binarySearch(numArr, targetNumber), () -> message);

		assertNotEquals(-1, BinarySearch.findBooleanBoundary(boolArray, targetBoundary), () -> message);

		assertNotEquals(-1, BinarySearch.findFirstOccurrence(numArr, targetNumber), () -> message);
	}
}