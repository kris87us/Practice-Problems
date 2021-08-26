package learn.dynamicprogramming;

public class CoinChangeII {
    public static void main(String[] args) {
        System.out.println(change(5, new int[] { 1, 2, 5 }));
    }

    // Bottom-up tabulation
    // Time: O(m x n)
    // Space: O(m x n)
    public static int change(int amount, int[] coins) {
        int m = amount;
        int n = coins.length;
        int[][] table = new int[n + 1][m + 1];

        // Base case
        // No. of ways to make up zero using zero coins
        table[0][0] = 1;

        // DP case
        for (int i = 1; i <= n; i++) {
            // No. of ways to make up zero while using any no. of coins (zero or more)
            table[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                table[i][j] = table[i - 1][j] + ((j - coins[i - 1] >= 0) ? table[i][j - coins[i - 1]] : 0);
            }
        }
        return table[n][m];
    }
}
