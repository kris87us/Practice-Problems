package learn.recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.print(factorial(10));
    }

    private static int factorial(int n) {
        if (n == 0) return 1;

        return n * factorial(n - 1);
    }
}
