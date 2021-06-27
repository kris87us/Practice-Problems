package learn.recursion;

import java.util.Arrays;

// Time: O(2^n)
// Space: O(n) - IF you use String concat, space will be O(n^2)
public class PrintPermutationsOfDecimal {

    public static void main(String[] args) {
        printPermutationsOfDecimal(2);
    }

    private static void printPermutationsOfDecimal(int n) {
        decimalHelper(new String[2], n, 0);
    }

    private static void decimalHelper(String[] s, int n, int i) {
        if (n == 0) {
            System.out.println(Arrays.toString(s));
        } else {
            for (int id = 0; id < 10; id++) {
                s[i] = String.valueOf(id);
                decimalHelper(s, n - 1, i+1);
            }
        }
    }
}
