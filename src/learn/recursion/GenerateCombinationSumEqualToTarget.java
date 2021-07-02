package learn.recursion;

import java.util.*;

public class GenerateCombinationSumEqualToTarget {
    // No duplicates allowed in the result
    public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        helper(arr, 0, new ArrayList<Integer>(Collections.emptyList()), result, target, set);
        return result;
    }

    private static void helper(List<Integer> subproblem, int i, ArrayList<Integer> partialSolution, List<List<Integer>> result, int target, HashSet<List<Integer>> set) {
        // Backtracking Case
        int sum = partialSolution.stream().mapToInt(Integer::intValue).sum();
        if (sum == target || !set.contains(partialSolution)) {
            result.add(new ArrayList<Integer>(partialSolution));
            set.add(partialSolution);
            return;
        }
        // Base Case
        if (i == subproblem.size()) {
            return;
        }

        // Recursive Case
        // Exclusion
        helper(subproblem, i + 1, partialSolution, result, target, set);

        // Inclusion
        partialSolution.add(subproblem.get(i));
        helper(subproblem, i + 1, partialSolution, result, target, set);
        partialSolution.remove(partialSolution.size() - 1);

    }
}
