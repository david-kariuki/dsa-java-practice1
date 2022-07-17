/**
 * Class with BinarySearch code
 *
 * @author David Kariuki <a href="mailto:dkaris.k@gmail.com">David Kariuki</a>
 * @apiNote - Binary search example cases
 * @see #factorial(int)
 * @since 17/7/2022
 */


public class DepthFirstSearch {

    public static void main(String[] args) {

        int number = 3;
        System.out.println("Factorial of " + number + " is " + factorial(number));
    }

    /**
     * Function to calculate the factorial of a number using recursion
     * @param n - int
     * @return int - factorial
     */
    public static int factorial(int n) {

        // Check if value is 1
        if (n == 1) {
            return 1;
        }

        return  n * factorial(n - 1);
    }

}
