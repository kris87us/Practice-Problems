package learn.dynamicprogramming;

public class CutTheRope {
    public static void main(String[] args) {
        System.out.println(max_product_from_cut_pieces(5));
    }

    // Time: O(n^2)
    // Space: O(n)
    static long max_product_from_cut_pieces(int n) {
        if (n == 2) {
            return 1;
        }

        long[] table = new long[n + 1];
        // Base case
        table[1] = 1;
        table[2] = 2; // Subproblems don't have to cut the rope. So for 2, the value should be 2

        // DP Case
        long best = 0;
        for (int i = 3; i <= n; i++) {
            if (i == n) {
                // The rope has to be cut atleast once, so when i == n it means there are no
                // cuts. So just initialize it to a best value with any valid cut index.
                best = n - 1;
            } else {
                // If the rod was not cut at all, set default
                best = i;
            }
            for (int j = 1; j < i; j++) {
                if (table[j] * table[i - j] > best) {
                    best = table[j] * table[i - j];
                }
            }
            table[i] = best;
        }
        return table[n];
    }
}
