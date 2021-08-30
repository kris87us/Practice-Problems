package learn.dynamicprogramming;

public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
        System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0 } }));
        System.out.println(uniquePathsWithObstacles(new int[][] { { 0 }, {0} }));
    }

    // Bottom-up tabulation
    // Time: O(m x n)
    // Space: O(m x n)
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] table = new int[m][n];
        // Base case
        if (obstacleGrid[0][0] == 1) { // If there is obstacle at start position
            return 0;
        }
        for (int row = 0; row < m; row++) {
            if (obstacleGrid[row][0] == 1) {
                break;
            } else {
                table[row][0] = 1;
            }
        }
        for (int col = 0; col < n; col++) {
            if (obstacleGrid[0][col] == 1) {
                break;
            } else {
                table[0][col] = 1;
            }
        }
        // DP case
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                int curr = obstacleGrid[row][col];
                if (curr == 1) { // Check if there is obstacle, skip it
                    continue;
                } else {
                    table[row][col] = (table[row - 1][col] + table[row][col - 1]) % ( (int) Math.pow(10, 9) + 7);
                }
            }
        }

        return (table[m - 1][n - 1] % ( (int) Math.pow(10, 9) + 7));
    }
}
