package learn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
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

public class PrintSubsetsOfASetWithDuplicateElements {
    public static void main(String[] args) {
        printPermutationsOfSet(new int[]{1, 2, 1, 1});
    }

    private static void printPermutationsOfSet(int[] nums) {
        Arrays.sort(nums);
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
        // Count the number of duplicates
        int count = 0;
        for (int dup = i; dup < subProblem.length; dup++) {
            if (subProblem[i] != subProblem[dup]) {
                break;
            }
            count++;
        }
        // Exclude duplicates and begin from next index
        helper(subProblem, partialSolution, i + count, res);
        // Include
        // We need to pick all the duplicate choices and pass each one of them down
        for (int c = 1; c <= count; c++) {
            partialSolution.add(subProblem[i]);
            helper(subProblem, partialSolution, i + count, res);
        }
        // We need to remove the duplicate element added above after the sub-ordinate returns to clean the slate
        for (int r = 1; r <= count; r++) {
            partialSolution.remove(partialSolution.size() - 1);
        }
    }
}
