package learn.dynamicprogramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs1(10));
    }
    
    // Bottom-up tabulation
    // Time: O(n)
    // Space: O(n)
    public static int climbStairs1(int n) {
        if (n <= 2) return n;
        int[] table = new int[n + 1];
        // Base case
        table[1] = 1;
        table[2] = 2;
        for (int i = 3; i <= n; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }
        return table[n];
    }

    // Bottom-up tabulation
    // Time: O(n)
    // Space: O(1)
    public static int climbStairs2(int n) {
        if (n <= 2) return n;
        int[] table = new int[3];
        // Base case
        table[1] = 1;
        table[2] = 2;
        for (int i = 3; i <= n; i++) {
            table[i % 3] = table[(i - 1) % 3] + table[(i - 2) % 3];
        }
        return table[n % 3];
    }
}
