/**
 * Class with BinarySearch code
 *
 * @author David Kariuki <a href="mailto:dkaris.k@gmail.com">David Kariuki</a>
 * @apiNote - Binary search example cases
 * @see #main(String[])
 * @see #binarySearch(int[], int) binarySearch
 * @see #findBooleanBoundary(boolean[], boolean)
 * @see #findFirstElementNotSmallerThanTarget(int[], int)
 * @see #findFirstOccurrence(int[], int)
 * @see #calculateSquareRoot(int)
 * @see #findMinInRotatedArray(int[])
 * @see #findThePeakOfTheMountains(int[])
 * @since 14/7/2022
 */

import utilities.SharedUtils;

public class BinarySearch {

    private static int start = 0; // Set all arrays starting point
    private static int end = 0; // Set all arrays ending point before they are recalculated

    /**
     * Main method
     *
     * @param args - Arguments array
     */
    public static void main(String[] args) {

        // Shared values
        int[] intArr = {2, 4, 8, 13, 14, 14, 17, 19, 22, 23, 25, 30};
        int targetInt = 14; // Targeted number to get index
        boolean[] boolArray = new boolean[]{false, false, false, true, true};
        boolean targetBoolean = true;
        int index;

        // Binary search with in t array
        index = BinarySearch.binarySearch(intArr, targetInt); // Get target numbers index
        if (index != -1) {
            System.out.print("The target number : " + targetInt + " is at index (" + index + ")" + "\n\n\n");
        } else {
            System.out.println("The number : " + targetInt + " was not found in the int array" + "\n\n\n");
        }


        // Binary search with boolean array
        index = BinarySearch.findBooleanBoundary(boolArray, targetBoolean);

        if (index != -1) {
            System.out.print("The boolean boundary for the start of value : " + targetBoolean
                    + " is at pos { " + index + " }" + "\n\n\n");
        } else {
            System.out.println("The boolean : " + targetBoolean + " was not found in the boolean array" + "\n\n\n");
        }


        // Get element not smaller than target
        index = BinarySearch.findFirstElementNotSmallerThanTarget(intArr, targetInt);
        if (index != -1) {
            System.out.print("The first element not smaller than the target number : " + targetInt
                    + " is at index (" + index + ") and the number is : " + intArr[index] + "\n\n\n");
        } else {
            System.out.println("The number : " + targetInt + " was not found in the int array" + "\n\n\n");
        }


        // Get the first occurrence of an in t in an int array
        index = BinarySearch.findFirstOccurrence(intArr, targetInt);
        if (index != -1) {
            System.out.print("The first occurrence of the target number : " + targetInt
                    + " is at index (" + index + ") and the number is : " + intArr[index] + "\n\n\n");
        } else {
            System.out.println("The number : " + targetInt + " was not found in the int array" + "\n\n\n");
        }


        // Get square root of a number
        int sqNum1 = 4;
        int sqNum2 = 8;
        int sqNum3 = 16;
        System.out.println("The square root of " + sqNum1 + " is : " + BinarySearch.calculateSquareRoot(sqNum1));
        System.out.println("The square root of " + sqNum2 + " is : " + BinarySearch.calculateSquareRoot(sqNum2));
        System.out.println("The square root of " + sqNum3 + " is : " + BinarySearch.calculateSquareRoot(sqNum3));


        // Get minimum in rotated sorted array
        System.out.println("Find minimum rotated :" + BinarySearch.findMinInRotatedArray(new int[]{30, 40, 50, 10, 20}));
        System.out.println("Find minimum rotated :" + BinarySearch.findMinInRotatedArray(new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println("Find minimum rotated :" + BinarySearch.findMinInRotatedArray(new int[]{0}));


        // Get the peak of the mountain
        System.out.println("The peak of the Mountain is at : "
                + BinarySearch.findThePeakOfTheMountains(new int[]{0, 1, 2, 3, 4, 3, 2, 1, 0}));
        System.out.println("The peak of the Mountain is at : "
                + BinarySearch.findThePeakOfTheMountains(new int[]{4, 5, 6, 7, 8, 7, 6, 5, 4}));

    }

    /**
     * Method to perform binary search
     *
     * @param arr    - int array
     * @param target - Target number to get index
     * @return int - Index/-1
     *
     * <p>
     * PROBLEM STATEMENT
     * Given a sorted array of integers and an integer called target, find the element that equals the
     * target and return its index.
     */
    public static int binarySearch(final int[] arr, final int target) {

        end = SharedUtils.calculateArraysEndPoint(arr); // Get the end point of the array

        // Loop through array
        while (start <= end) {
            int mid = SharedUtils.calculateArraysMidPoint(start, end); // Calculate arrays mid point

            // Check if value at mid, equals to target and return
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

        end = SharedUtils.calculateArraysEndPoint(arr); // Get arrays end point
        int boundaryIndex = -1; // Set initial boundary index

        // Loop through array
        while (start <= end) {

            int mid = SharedUtils.calculateArraysMidPoint(start, end); // Calculate arrays mid point

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
    public static int findFirstElementNotSmallerThanTarget(final int[] arr, final int target) {

        end = SharedUtils.calculateArraysEndPoint(arr); // Get arrays end point
        int boundaryIndex = -1;

        // Loop through array
        while (start <= end) {

            int mid = SharedUtils.calculateArraysMidPoint(start, end); // Calculate arrays midpoint

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

    /**
     * Method to get the first occurrence of a target in an int array
     *
     * @param arr    - int array
     * @param target - Target number to get index
     * @return int - Index/-1
     *
     * <p>
     * PROBLEM STATEMENT
     * Given a sorted array of integers and a target integer, find the first occurrence of
     * the target and return its index. Return -1 if the target is not in the array.
     */
    public static int findFirstOccurrence(final int[] arr, final int target) {

        end = SharedUtils.calculateArraysEndPoint(arr); // Get arrays end point
        int boundaryIndex = -1;

        while (start <= end) {

            // Calculate midpoint
            int mid = SharedUtils.calculateArraysMidPoint(start, end); // Calculate arrays midpoint

            // Check if midpoint is equal to target
            if (arr[mid] >= target) {
                boundaryIndex = mid;
                end = mid - 1;
            }

            // Check id value at midpoint is smaller than target
            if (arr[mid] < target) {
                start = mid + 1;
            }
        }

        return boundaryIndex;
    }

    /**
     * Method to find square root of an integer
     *
     * @param num - Integer to find square root of
     * @return -1 / Square root of integer
     *
     * <p>
     * PROBLEM STATEMENT
     * Given an integer, find its square root without using the built-in square root function.
     * Only return the integer part (truncate the decimals).
     */
    public static int calculateSquareRoot(int num) {

        // Check if the number is 0
        if (num == 0) {
            return 0;
        } // return 0 for 0 value as square root of 0 is 0

        start = 1; // Set starting point
        end = num; // Set ending point
        int squareRoot = -1; // Initialized square root

        // Loop through boundary points
        while (start <= end) {

            int mid = SharedUtils.calculateArraysMidPoint(start, end); // Calculate arrays midpoint

            // Check if mid is less than or equal to division of number and midpoint
            if (mid <= (num / mid)) {
                squareRoot = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return squareRoot;
    }

    /**
     * Method to find the minimum in rotated sorted array
     *
     * @param arr - int array
     * @return -1/index of minimum value
     *
     * <p>
     * PROBLEM STATEMENT
     * A sorted array was rotated at an unknown pivot. For example,
     * [10, 20, 30, 40, 50] becomes [30, 40, 50, 10, 20]. Find the index of the minimum element in this array.
     */
    public static int findMinInRotatedArray(int[] arr) {
        start = 0;
        end = SharedUtils.calculateArraysEndPoint(arr); // Calculate array end point
        int boundaryIndex = -1; // Initialize boundary

        // Loop through the array
        while (start <= end) {

            int mid = SharedUtils.calculateArraysMidPoint(start, end); // Calculate arrays midpoint

            if (arr[mid] <= arr[SharedUtils.calculateArraysEndPoint(arr)]) {
                boundaryIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return boundaryIndex;
    }

    /**
     * Method to get the peak of the mountain
     *
     * @param arr - int array
     * @return -1 / peak of the mountain
     *
     * <p>
     * PROBLEM STATEMENT
     * A mountain array is defined as an array that:
     * - Has at least 3 elements.
     * - Has an element with the largest value called the “peak”, at an index k. The array elements monotonically
     * increase from the first element to A[k], and then monotonically decreases from A[k + 1] to the last element
     * of the array. Thus creating a “mountain” of numbers.
     */
    public static int findThePeakOfTheMountains(int[] arr) {

        start = 0; // Set starting index
        end = SharedUtils.calculateArraysEndPoint(arr); // Get arrays end point
        int mountainPeak = -1; // Initialize peak

        // Loop through the array
        while (start <= end) {

            int mid = SharedUtils.calculateArraysMidPoint(start, end); // Calculate arrays midpoint

            if ((mid == SharedUtils.calculateArraysEndPoint(arr)) || (arr[mid] >= arr[mid + 1])) {
                mountainPeak = mid;
                end = mid - 1;  // Set new end index
            } else {
                start = mid + 1; // Set starting index
            }
        }

        return mountainPeak; // Return the peak
    }
}