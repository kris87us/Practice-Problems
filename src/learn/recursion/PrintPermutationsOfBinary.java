package learn.recursion;

import java.util.Arrays;

// Time: O(2^n)
// Space: O(n) - If you use String concat, space will be O(n^2)
public class PrintPermutationsOfBinary {

    public static void main(String[] args) {
        printPermutationsOfBinary(4);
    }

    private static void printPermutationsOfBinary(int n) {
        binaryHelper(new String[4], n, 0);
    }

    private static void binaryHelper(String[] s, int n, int i) {
        if (n == 0) {
            System.out.println(Arrays.toString(s));
        } else {
            s[i] = "0";
            binaryHelper(s, n - 1, i+1);
            s[i] = "1";
            binaryHelper(s, n - 1, i+1);
        }
    }
}
