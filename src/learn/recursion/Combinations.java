package learn.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Time : O(nCk * k)
// Space : O(nCk * k)
public class Combinations {
    public static void main(String[] args) {
        combinations(5, 2); // n choose k
    }

    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> input = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            input.add(i);
        }
        helper(input, 0, new ArrayList<Integer>(Collections.emptyList()), result, k);
        return result;
    }
    
    private static void helper(List<Integer> subproblem, int i, List<Integer> partialSolution, List<List<Integer>> result, int k) {
        // Backtracking case
        if (k == partialSolution.size()) {
            result.add(new ArrayList<Integer>(partialSolution));
            return;
        }
        // Base case
        if (i == subproblem.size()) {
            return;
        }
        
        // Recursive case
        // Exclusion
        helper(subproblem, i + 1, partialSolution, result, k);
        
        // Inclusion
        partialSolution.add(subproblem.get(i));
        helper(subproblem, i + 1, partialSolution, result, k);
        partialSolution.remove(partialSolution.size() - 1);
    }
}
