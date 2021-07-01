package learn.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Time:
// Leaf workers = 2^n workers and each worker is doing O(n) work = O(n * 2^n)
// Internal workers = O(1 * 2^n)
// Overall ==> O(n * 2^n)

// Space:
// Input(O(n)) = Input array of n elements
// Aux(O(n)) = Screenshot at each leaf level will be O(n)
// Output(O(n*2^n)) = Output array of 2^n sub-arrays, with each sub-array almost having n/2 elements on average.
// Overall ==> O(n * 2^n)

public class PrintSubsetsOfASetWithoutDuplicateElements {
    public static void main(String[] args) {
        printPermutationsOfSet(new int[]{1, 2, 3});
    }

    private static void printPermutationsOfSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(Collections.emptyList()), 0, res);
        System.out.print(res);
    }

    private static void helper(int[] subProblem, List<Integer> partialSolution, int i, List<List<Integer>> res) {
        if (subProblem.length == i) {
            // new ArrayList<>() is very important in-order to copy `partialSolution` and avoid adding reference of it which keeps mutating.
            res.add(new ArrayList<>(partialSolution));
            return;
        }
        // Exclude
        helper(subProblem, partialSolution, i + 1, res);
        // Include
        partialSolution.add(subProblem[i]);
        helper(subProblem, partialSolution, i + 1, res);
        partialSolution.remove(partialSolution.size() - 1);
    }
}
