package learn.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_OR_SubsetSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] { 2, 3, 5 }, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(candidates, 0, new ArrayList<Integer>(), 0, target, result);
        return result;
    }

    private static void helper(int[] subproblem, int i, List<Integer> partialSolution, int runningSum, int target,
            List<List<Integer>> result) {
        System.out.println(partialSolution);
        // Backtracking case
        if (runningSum == target) {
            result.add(new ArrayList<Integer>(partialSolution));
            return;
        } else if (runningSum > target) {
            return;
        }

        // Recursive case
        for (int index = i; index < subproblem.length; index++) {
            // Prune the remaining subtrees if next number in the input greater than (target - runningSum)
            if (subproblem[index] <= target - runningSum) {
                // Include
                partialSolution.add(subproblem[index]);
                helper(subproblem, index, partialSolution, runningSum + subproblem[index], target, result);
                partialSolution.remove(partialSolution.size() - 1);
            }
        }
    }
}
