package learn.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Time : O(nCk * k)
// Space : O(nCk * k)
public class Combinations {
    public static void main(String[] args) {
        System.out.print(combinations(5, 2)); // n choose k
    }

    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        helper(n, 0, new ArrayList<Integer>(Collections.emptyList()), result, k);
        return result;
    }
    
    private static void helper(int n, int i, List<Integer> partialSolution, List<List<Integer>> result, int k) {
        // Backtracking case
        if (k == partialSolution.size()) {
            result.add(new ArrayList<Integer>(partialSolution));
            return;
        }
        // Base case
        if (i > n) {
            return;
        }
        
        // Recursive case
        // Exclusion
        helper(n, i + 1, partialSolution, result, k);
        
        // Inclusion
        partialSolution.add(i);
        helper(n, i + 1, partialSolution, result, k);
        partialSolution.remove(partialSolution.size() - 1);
    }
}
