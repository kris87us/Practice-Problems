package learn.recursion;

import java.util.Arrays;

public class PrintPermutationsOfASetWithoutRepetition {
    public static void main(String[] args) {
        printPermutationsOfSet("abc");
    }

    private static void printPermutationsOfSet(String s) {
        helper(s, new String[s.length()], 0);
    }

    private static void helper(String subProblem, String[] partialSolution, int i) {
        if (partialSolution.length == i) {
            System.out.println(Arrays.toString(partialSolution));
        } else {
            for (int id = 0; id < subProblem.length(); id++) {
                partialSolution[i] = String.valueOf(subProblem.charAt(id));
                // Remove the character just added from the sub-problem
                String reducedSubProblem = subProblem.substring(0,id) + subProblem.substring(id+1);
                helper(reducedSubProblem, partialSolution, i+1);
            }
        }
    }
}
