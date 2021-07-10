package learn.recursion;

import java.util.HashMap;
import java.util.Map;

public class HowManyBinaryTreesFrom_N_nodes {
    
    public static void main(String[] args) {
        System.out.println(numberOfBinaryTrees_Memoized(10, new HashMap<>()));
    }
    // This is BruteForce, since there will be many nodes that will be computed again and again during recursing left and right subtrees
    // For example: For input n=3 [1,2,3] in the below example, 3 has 2 nodes on the left subtrees in both the arrangement and this redundant calculation can be memoized.
    //       3            3
    //     /            /
    //    2            1
    //   /              \
    //  1                2
    // Time Complexity: 
    // O(Catalan number(n)).
    // This is a loose bound, tight bound is very complex to derive and explain.

    // Space Complexity: O(n)
    // Auxiliary space used is O(n), input takes O(1). O(n) + O(1) = O(n).
    @SuppressWarnings("unused")
    private static int numberOfBinaryTrees(int n) {
        if (n <= 1) return 1;

        int sum = 0;
        // Loop through the nodes and arrange them left/right
        for (int i = 1; i <= n; i++) {
            int left = numberOfBinaryTrees(i - 1);
            int right = numberOfBinaryTrees(n - i);

            sum += left * right;
        }
        return sum;
    }

    // Time Complexity: 
    // O(n^2).
    // Memoizing helps drastically. For example, Catalan_number(35) = 3116285494907301262, while 35^2 = 1225.

    // Space Complexity: O(n)
    // Auxiliary space used is O(n), input takes O(1). O(n) + O(1) = O(n).
    private static int numberOfBinaryTrees_Memoized(int n, Map<Integer, Integer> memoized) {
        if (memoized.containsKey(n)) {
            return memoized.get(n);
        }
        if (n <= 1) {
            memoized.put(n, 1);
            return 1;
        }

        int sum = 0;
        // Loop through the nodes and arrange them left/right
        for (int i = 1; i <= n; i++) {
            int left = numberOfBinaryTrees_Memoized(i - 1, memoized);
            int right = numberOfBinaryTrees_Memoized(n - i, memoized);

            sum += left * right;
        }
        memoized.put(n, sum);
        return sum;
    }
}

