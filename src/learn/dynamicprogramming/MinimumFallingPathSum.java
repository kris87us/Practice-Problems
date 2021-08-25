package learn.dynamicprogramming;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }));
    }

    // Bottom-up tabulation
    // Time: O(m x n)
    // Space: O(m x n)
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] table = new int[m][n];
        // Base case
        for (int col = 0; col < n; col++) {
            table[0][col] = matrix[0][col];
        }
        // DP case
        for (int row = 1; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (col - 1 >= 0 && col + 1 <= n - 1) {
                    int tempMin = Math.min(table[row - 1][col - 1], table[row - 1][col]);
                    table[row][col] = Math.min(tempMin, table[row - 1][col + 1]) + matrix[row][col];  
                } else if (col - 1 < 0) {
                    int tempMin = Math.min(table[row - 1][col + 1], table[row - 1][col]);
                    table[row][col] = tempMin + matrix[row][col];
                } else if (col + 1 > n - 1) {
                    int tempMin = Math.min(table[row - 1][col - 1], table[row - 1][col]);
                    table[row][col] = tempMin + matrix[row][col];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (table[m - 1][i] < min) {
                min = table[m - 1][i];
            }    
        }
        return min;
    }
}
