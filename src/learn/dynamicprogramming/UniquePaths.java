package learn.dynamicprogramming;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    // Bottom-up tabulation
    // Time: O(m x n)
    // Space: O(m x n)
    public static int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];
        table[0][0] = 1;
        // Base case
        for (int row = 1; row < m; row++) {
            table[row][0] = 1;
        }
        for (int col = 1; col < n; col++) {
            table[0][col] = 1;
        }
        // DP case
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                table[row][col] = table[row - 1][col] + table[row][col - 1];
            }
        }
        return table[m - 1][n - 1];
    }
}
