package learn.recursion;

import java.util.Arrays;
import java.util.List;

public class NumberOfSubsetsOfASet {
    public static void main(String[] args) {
        int[] partialSolution = new int[2];
        numberOfSubsets(List.of(1, 2), partialSolution, 2, 0);
    }

    private static void numberOfSubsets(List<Integer> subProblem, int[] partialSolution, int n, int i) {
        if (n == 0) {
            System.out.println(Arrays.toString(partialSolution));
        } else {
            for (int id = 0; id< n; id++) {
                // Exclude
                // numberOfSubsets(subProblem.subList(1, subProblem.size()), partialSolution, n - 1, i+1);
                // Include
                partialSolution[i] = subProblem.get(id);
                numberOfSubsets(subProblem.subList(1, subProblem.size()), partialSolution, n - 1, i+1);
            }
        }
    }
}
