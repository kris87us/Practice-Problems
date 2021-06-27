package learn.recursion;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciDP(8));
        System.out.println(fibonacciRecursionEnhanced(8, 0, 1));
    }

    // O(2^n)
    private static int fibonacciRecursion(int n) {
        if (n <= 1) return n;

        int res = fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);

        return res;
    }

    // O(n)
    private static int fibonacciDP(int n) {
        if (n <= 1) return n;
        int[] f = new int[n];

        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        System.out.println(Arrays.toString(f));

        return f[n - 1];
    }

    // O(n)
    private static int fibonacciRecursionEnhanced(int n, int b1, int b2) {
        if (n == 1) return b1;

        return fibonacciRecursionEnhanced(n - 1, b2, b1 + b2);
    }
}
