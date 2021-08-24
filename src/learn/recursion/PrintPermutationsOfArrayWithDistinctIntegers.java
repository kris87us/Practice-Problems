package learn.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Time:
// Leaf workers = n! leaf workers and each worker is doing O(n) work = O(n * n!)
// Internal workers = Less than O(n * n!)
// Overall ==> O(n * n!)

// Space:
// Input(O(n)) = Input array of n elements
// Aux(O(n)) = Screenshot at each leaf level will be O(n)
// Output(O(n*n!)) = Output array of n! sub-arrays, with each sub-array almost having n elements on average.
// Overall ==> O(n * n!)

public class PrintPermutationsOfArrayWithDistinctIntegers {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static void permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Convert array to List
        List<Integer> input = new ArrayList<>();
        for (int n : nums) {
            input.add(n);
        }
        permuteHelper(input, 0, new ArrayList<>(Collections.emptyList()), res);
        System.out.print(res);
    }

    private static void permuteHelper(List<Integer> subproblem, int i, ArrayList<Integer> partialSolution, List<List<Integer>> res) {
        if (i == subproblem.size()) {
            res.add(new ArrayList<>(partialSolution));
            return;
        }
        // i will increment with each level in the tree
        // pick will increment each time a element needs to be picked
        for (int pick = i; pick < subproblem.size(); pick++) {
            // Swap i with pick so that we can pass a contiguous list of elements to sub-ordinate to pick next permutation
            Collections.swap(subproblem, pick, i);

            partialSolution.add(subproblem.get(i));
            permuteHelper(subproblem, i + 1, partialSolution, res);
            partialSolution.remove(partialSolution.size() - 1);

            // Un-swap i with pick so that we restore the original array for next iteration
            Collections.swap(subproblem, pick, i);
        }
    }
}
