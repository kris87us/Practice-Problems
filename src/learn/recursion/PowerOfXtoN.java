package learn.recursion;

public class PowerOfXtoN {
    public static void main(String[] args) {
        System.out.println(myPow(3.89707, 2));
    }

    // Time : O(n) since recursion will run n times
    // Space : O(n) since each computation is stored in slate
    // private static int power(int x, int n) {
    //     if (x <= 1) return x;
    //     int[] result = new int[1];
    //     helper(x, 0, 1, result, n);
    //     return result[0];
    // }

    // Time : O(n) since recursion will run n/2 times
    // Space : O(n) since each computation is stored in slate
    public static double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        double[] result = new double[1];
        double half;
        if (x % 1 == 0) {
            half = helper(x, 0, 1, result, n/2);
        } else {
            half = helper(x, 0, 1, result, n);
        }
        if (half % 2 == 0) {
            result[0] = half * half;
        } else {
            result[0] = half * half * x;
        }
        return n < 0 ? 1/result[0] : result[0];
    }

    private static double helper(double x, int i, double slate, double[] result, int n) {
        // Base case
        if (i == Math.abs(n)) {
            result[0] = slate;
            return result[0];
        }
        // Recursive case
        slate *= x;
        return helper(x, i + 1, slate, result, n);
    }
}
