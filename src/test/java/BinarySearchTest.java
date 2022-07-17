/**
 * Class with tests for the BinarySearch class
 *
 * @author David Kariuki <a href="mailto:dkaris.k@gmail.com">David Kariuki</a>
 * @apiNote - Binary search methods test cases
 * @see BinarySearch
 * @see BinarySearch#binarySearch(int[], int)
 * @see BinarySearch#findBooleanBoundary(boolean[], boolean)
 * @see BinarySearch#findFirstElementNotSmallerThanTarget(int[], int)
 * @see BinarySearch#findFirstOccurrence(int[], int)
 * @see BinarySearch#calculateSquareRoot(int)
 * @see BinarySearch#findMinInRotatedArray(int[])
 * @see BinarySearch#findThePeakOfTheMountains(int[])
 * @since 14/7/2022
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SuppressWarnings("ExcessiveLambdaUsage")
public class BinarySearchTest {

    /**
     * Method to test successful binary search with message from Supplier<String>
     *
     * @apiNote - False positive if value not found in array (Returns -1)
     */
    @Test
    void testBinarySearchAssertNotEquals() {

        int targetNumber = 22; // Targeted number to get index
        boolean targetBoundary = false;

        // Int array
        int[] numArr = {2, 4, 8, 13, 14, 17, 19, 22, 22, 23, 25, 30, 32, 34, 35, 36, 38, 41,
                44, 45, 46, 49};

        // Boolean array
        boolean[] boolArray = new boolean[]{false, false, false, true, true};

        String message = "Binary search should return index >= 0 from integer array";

        // Binary search in array
        assertNotEquals(-1, BinarySearch.binarySearch(numArr, targetNumber),
                () -> message);

        // Find boolean boundary from boolean array
        assertNotEquals(-1, BinarySearch.findBooleanBoundary(
                boolArray, targetBoundary), () -> message
        );

        // Find first element not smaller than target
        assertNotEquals(-1, BinarySearch.findFirstElementNotSmallerThanTarget(
                numArr, targetNumber
                ), () -> message);

        // Find first target's occurrence in int array
        assertNotEquals(-1, BinarySearch.findFirstOccurrence(numArr, targetNumber),
                () -> message);

        // Calculate square root
        assertNotEquals(-1, BinarySearch.calculateSquareRoot(81), () -> message);

        // Find minimum in rotated sorted array
        assertNotEquals(-1, BinarySearch.findMinInRotatedArray(numArr));

        // Find the peak of the mountain
        assertNotEquals(-1, BinarySearch.findThePeakOfTheMountains(
                new int[]{0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0}
        ));
    }
}