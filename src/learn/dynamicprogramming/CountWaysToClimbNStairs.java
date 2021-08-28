package learn.dynamicprogramming;

public class CountWaysToClimbNStairs {
    public static void main(String[] args) {
        System.out.println(countWaysToClimb(new int[] { 1, 2, 3 }, 6));
    }

    // Time: O(n * steps)
    // Space: O(n)
    static long countWaysToClimb(int[] steps, int n) {
        long[] table = new long[n + 1];
        // Base case
        // Step 0 can be reached from 0, so 1 way
        table[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int step : steps) {
                if (i - step >= 0) {
                    table[i] += table[i - step];
                }
            }
        }
        return table[n];
    }
}
