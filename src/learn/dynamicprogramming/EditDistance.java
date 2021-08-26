package learn.dynamicprogramming;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // (m+1) * (n+1) subproblems considering empty string base case
        int[][] table = new int[m+1][n+1];

        // Base case
        for (int i = 0; i <= m; i++) {
            table[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            table[0][j] = j;
        }
        // DP case
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int replace = table[i-1][j-1] + ((word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1);
                int insert = table[i][j-1] + 1;
                int delete = table[i-1][j] + 1;
                table[i][j] = Math.min(Math.min(replace, insert), delete);
            }
        }

        return table[m][n];
    }
}
