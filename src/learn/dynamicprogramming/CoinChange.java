package learn.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        //System.out.println(coinChange(new int[] {1,2,5}, 11));
        System.out.println(coinChange(new int[] {2}, 3));
    }

    // Bottom-up tabulation
    // Time: O(a x k)
    // Space: O(a)
    public static int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        Arrays.fill(table, amount + 1);
        table[0] = 0;
        // Base case
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    table[i] = Math.min(table[i - c] + 1, table[i]);
                }
            }
        }
        return table[amount] > amount ? -1 : table[amount];
    }
}
