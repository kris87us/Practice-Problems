package learn.recursion;

// Time: O(n)
// Space: Overall - O(n) Aux - O(1)
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(10, 1));
    }

    private static int factorial(int n, int counter) {
        System.out.println("Execution no. " + counter);
        if (n == 0) return 1;

        return n * factorial(n - 1, counter + 1);
    }
}
