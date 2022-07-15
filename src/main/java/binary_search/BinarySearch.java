/**
 * Class with BinarySearch code
 *
 * @author David Kariuki
 * @see #binarySearch(Type, Type)
 * @see #findBooleanBoundary(Type, Type)
 * @see #getFirstElementNotSmallerThanTarget(Type, Type)
 * @since 14/7/2022
 */

package binary_search;

public class BinarySearch {

	/**
	 * Main method
	 *
	 * @param args - Arguments array
	 */
	public static void main(String[] args) {

		// Shared values
		int[] intArr = {2, 4, 8, 13, 14, 17, 19, 22, 23, 25, 30};
		int targetInt = 14; // Targeted number to get index
		boolean[] boolArray = new boolean[]{false, false, false, true, true};
		boolean targetBoolean = true;
		int index;

		// Binary search with in t array
		index = binarySearch(intArr, targetInt); // Get target numbers index
		if (index != -1) {
			System.out.print("The target number : " + targetInt + " is at index (" + index + ")" + "\n\n\n");
		} else {
			System.out.println("The number : " + targetInt + " was not found in the int array" + "\n\n\n");
		}

		// Binary search with boolean array
		index = findBooleanBoundary(boolArray, targetBoolean);

		if (index != -1) {
			System.out.print("The boolean boundary for the start of value : " + targetBoolean
					+ " is at pos { " + index + " }" + "\n\n\n");
		} else {
			System.out.println("The boolean : " + targetBoolean + " was not found in the boolean array" + "\n\n\n");
		}

		// Get element not smaller than target
		index = getFirstElementNotSmallerThanTarget(intArr, targetInt);
		if (index != -1) {
			System.out.print("The first element not smaller than the target number : " + targetInt
					+ " is at index (" + index + ") and the number is : " + intArr[index] + "\n\n\n");
		} else {
			System.out.println("The number : " + targetInt + " was not found in the int array" + "\n\n\n");
		}
	}

	/**
	 * Method to perform binary search
	 *
	 * @param arr    - Passed int array
	 * @param target - Target number to get index
	 * @return int - Index/-1
	 *
	 * <p>
	 * PROBLEM STATEMENT
	 * Given a sorted array of integers and an integer called target, find the element that equals the
	 * target and return its index.
	 */
	public static int binarySearch(int[] arr, int target) {

		int start = 0; // Start index
		int end = arr.length - 1; // Get last index

		// Loop through array
		while (start <= end) {
			int mid = start + ((end - start) / 2);

			// Check if mid equals to target and return
			if (arr[mid] == target) {
				return mid; // return numbers index
			}

			// Check if mid is less than target
			if (arr[mid] < target) {
				// Middle is less than the target, so discard left half by increasing start of search boundary
				start = mid + 1;
			}

			// Check if mid is greater that target
			if (arr[mid] > target) {
				// Middle is greater than the target, so discard right half by decreasing end of search boundary
				end = mid - 1;
			}
		}

		return -1;
	}

	/**
	 * Method to find array boundary
	 *
	 * @param arr    - Boolean array
	 * @param target - Target boolean to get start index (Boundary)
	 * @return int - Index(Boundary) / -1
	 *
	 * <p>
	 * PROBLEM STATEMENT
	 * An array of boolean values is divided into two sections: the left section consists of all false,
	 * and the right section consists of all true. Find the boundary of the right section,
	 * i.e. the index of the first true element. If there is no true element, return -1.
	 */
	public static int findBooleanBoundary(final boolean[] arr, final boolean target) {

		int start = 0; // Get array starting point
		int end = arr.length - 1; // get arrays end point
		int boundaryIndex = -1; // Set initial boundary index

		// Loop through array
		while (start <= end) {

			int mid = (start + end) / 2; // Calculate arrays midpoint

			// Check if the target value is at the current midpoint in loop
			if (arr[mid] == target) {
				boundaryIndex = mid;
				end = mid - 1;
			} else {
				start = mid + 1; // Move boundary forward
			}
		}

		return boundaryIndex;
	}

	/**
	 * Method to get the index of the first element not smaller than target from an int array
	 *
	 * @param arr    - int array
	 * @param target - Targeted int
	 * @return int - Index(Boundary) / -1
	 *
	 * <p>
	 * PROBLEM STATEMENT
	 * Given an array of integers sorted in increasing order and a target, find the index of the first
	 * element in the array that is larger or equal to the target. Assume that it is guaranteed to find
	 * a satisfying number.
	 */
	public static int getFirstElementNotSmallerThanTarget(int[] arr, int target) {

		int start = 0; // Get array starting point
		int end = arr.length - 1; // get arrays end point
		int boundaryIndex = -1;

		// Loop through array
		while (start <= end) {

			int mid = start + (end - start) / 2; // Calculate arrays midpoint

			// Check if element at midpoint is greater or equal to target
			if (arr[mid] >= target) {
				boundaryIndex = mid;
				end = mid - 1;
			}

			// Check if element at midpoint is less than target
			if (arr[mid] < target) {
				start = mid + 1;
			}
		}

		return boundaryIndex;
	}
}