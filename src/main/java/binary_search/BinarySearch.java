/**
 * Class with BinarySearch code
 *
 * @author David Kariuki
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

		int targetNumber = 22; // Targeted number to get position
		int[] numArr = {2, 4, 8, 13, 14, 17, 19, 22, 23, 25, 30, 32, 34, 35, 36, 38, 41, 44, 45, 46, 49};

		System.out.print("The target number : " + targetNumber + " is at position (" + binarySearch(numArr,
				targetNumber) + ")");
	}

	/**
	 * Method to perform binary search
	 *
	 * @param arr    - Passed int array
	 * @param target - Target number to get position
	 */
	public static int binarySearch(int[] arr, int target) {

		int start = 0; // Start index
		int end = arr.length - 1; // Get last index

		// Loop through array
		while (start <= end) {
			int mid = start + ((end - start) / 2);

			// Check if mid equals to target and return
			if (arr[mid] == target) {
				return mid; // return numbers position
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
}