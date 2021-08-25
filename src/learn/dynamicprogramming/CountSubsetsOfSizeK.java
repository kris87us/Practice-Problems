package learn.dynamicprogramming;

public class CountSubsetsOfSizeK {
    public static void main(String[] args) {
       System.out.println(combine(4, 2)); 
    }

    // Bottom up tabulation
    // Time: O(n x k)
    // Space: O(n x k)
    public static int combine(int n, int k) {
        if (k == 0) return 1;
        if (k == n) return 1;

        int[][] table = new int[n+1][k+1];
        // Base case
        for (int row = 0; row <= n; row++) {
            table[row][0] = 1;
        }
        // Diagonal
        for (int col = 0; col <= k; col++) {
            table[col][col] = 1;
        }
        // DP case
        for (int row = 1; row <= n; row++) {
            // Can avoid redundant computations by not computing till k, and making it MIN(row, k) since k > n doesn't make sense.
            for (int col = 1; col <= Math.min(row, k); col++) {
                table[row][col] = table[row - 1][col] + table[row - 1][col - 1];
            }
        }

        return table[n][k];
    }
}
