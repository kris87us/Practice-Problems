package learn.dynamicprogramming;

public class PaintHouse {
    public static void main(String[] args) {
        System.out.println(minCost(new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } }));
        System.out.println(minCost_optimized(new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } }));
    }

    // Bottom-up tabulation
    // Time: O(n x 3) = O(n)
    // Space: O(n)
    public static int minCost(int[][] costs) {
        int m = costs.length;
        int[][] table = new int[m][3];
        // Base case
        // Min cost to paint all houses on level 1 is same as their individual costs
        table[0][0] = costs[0][0];
        table[0][1] = costs[0][1];
        table[0][2] = costs[0][2];

        // DP case
        for (int i = 1; i < m; i++) {
            // Red
            table[i][0] = costs[i][0] + Math.min(table[i - 1][1], table[i - 1][2]);
            // Blue
            table[i][1] = costs[i][1] + Math.min(table[i - 1][0], table[i - 1][2]);
            // Green
            table[i][2] = costs[i][2] + Math.min(table[i - 1][1], table[i - 1][0]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (table[m - 1][i] < min) {
                min = table[m - 1][i];
            }    
        }
        return min; 
    }

    // Bottom-up tabulation
    // Time: O(n)
    // Space: O(1)
    public static int minCost_optimized(int[][] costs) {
        int m = costs.length;
        int[][] table = new int[2][3];
        // Base case
        // Min cost to paint all houses on level 1 is same as their individual costs
        table[0][0] = costs[0][0];
        table[0][1] = costs[0][1];
        table[0][2] = costs[0][2];

        // DP case
        int i = 1;
        while (i < m) {
            // Red
            table[i % 2][0] = costs[i][0] + Math.min(table[(i - 1) % 2][1], table[(i - 1) % 2][2]);
            // Blue
            table[i % 2][1] = costs[i][1] + Math.min(table[(i - 1) % 2][0], table[(i - 1) % 2][2]);
            // Green
            table[i % 2][2] = costs[i][2] + Math.min(table[(i - 1) % 2][1], table[(i - 1) % 2][0]);
            i++;
        }
        int lastIndex = (i - 1) % 2;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if (table[lastIndex][j] < min) {
                min = table[lastIndex][j];
            }    
        }
        return min; 
    }
}
