/**
 * Class with shared reusable code
 * @author David Kariuki <a href="mailto:dkaris.k@gmail.com">David Kariuki</a>
 */

package utilities;

public class SharedUtils {

    /**
     * Method to calculate arrays end point
     *
     * @param arr - int array
     * @return int - End point
     */
    public static int calculateArraysEndPoint(final int[] arr) {
        return arr.length - 1;
    }

    /**
     * Method to calculate arrays end point
     *
     * @param arr - boolean array
     * @return int - End point
     */
    public static int calculateArraysEndPoint(final boolean[] arr) {
        return arr.length - 1;
    }

    /**
     * Method to calculate arrays midpoint
     *
     * @param start - Start point
     * @param end   - End point
     * @apiNote - Chose formula below to prevent integer overflow (In case incrementing past int_max)
     */
    public static int calculateArraysMidPoint(final int start, final int end) {
        return start + ((end - start) / 2); // return arrays midpoint
    }
}
