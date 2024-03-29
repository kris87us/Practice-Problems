package learn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenerateCombinationSumEqualToTarget_OR_SubsetSumII {

    public static void main(String[] args) {
        System.out.println(generate_all_combinations(new ArrayList<Integer>(Arrays.asList(1,1,1,1)), 2));
    }

    // No duplicates allowed in the result
    public static List<List<Integer>> generate_all_combinations(List<Integer> arr, int target) {
        Collections.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        helper(arr, 0, new ArrayList<Integer>(Collections.emptyList()), result, target);
        return result;
    }

    private static void helper(List<Integer> subproblem, int i, ArrayList<Integer> partialSolution, List<List<Integer>> result, int target) {
        // Backtracking Case
        if (target == 0) {
            result.add(new ArrayList<Integer>(partialSolution));
            return;
        } else if (target < 0) {
            return;
        }
        // Base Case
        if (i == subproblem.size()) {
            return;
        }

        // Count the number of duplicates
        int count = 0;
        for (int dup = i; dup < subproblem.size(); dup++) {
            if (subproblem.get(i) != subproblem.get(dup)) {
                break;
            }
            count++;
        }
        // Exclude duplicates and begin from next index
        helper(subproblem, i + count, partialSolution, result, target);
        // Include
        // We need to pick all the duplicate choices and pass each one of them down
        int localSum = 0;
        for (int c = 1; c <= count; c++) {
            partialSolution.add(subproblem.get(i));
            localSum += subproblem.get(i);
            helper(subproblem, i + count, partialSolution, result, target - localSum);
        }
        // We need to remove the duplicate element added above after the sub-ordinate returns to clean the slate
        for (int r = 1; r <= count; r++) {
            partialSolution.remove(partialSolution.size() - 1);
        }
    }
}
