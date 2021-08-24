package learn.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static Map<Integer, Integer> map;
    public static void main(String[] args) {
        map = new HashMap<>();
        System.out.println(fib1(10));
        System.out.println(fib2(10));
    }
    // Time: O(n)
    // Space: O(1)
    // Bottom-up tabulation
    public static int fib1(int n) {
        if (n <= 1) return n;
        int[] table = new int[3];
        table[0] = 0;
        table[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            table[i % 3] = table[(i - 1) % 3] + table[(i - 2) % 3];
        }
        return table[n % 3];
    }

    // Top-down memoization
    // Time: O(n)
    // Space: O(n)
    public static int fib2(int n) {
        if (n <= 1) return n;
        if (map.containsKey(n)) return map.get(n);
        int fib = fib2(n-1) + fib2(n-2);
        map.put(n, fib);
        return map.get(n);
    }
}
