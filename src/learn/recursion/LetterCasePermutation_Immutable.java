package learn.recursion;

import java.util.ArrayList;
import java.util.List;

// Time: O(n * 2^n)
// Space: Input(O(n)) + Aux(O(n^2)) + Output(O(n*2^n)) = O(n * 2^n)
// Top down DFS approach
public class LetterCasePermutation_Immutable {
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }

    private static void letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s, 0, "", result);
        System.out.print(result);
    }

    private static void helper(String s, int i, String partialSolution, List<String> res) {
        if (s.length() == i) {
            res.add(partialSolution);
            return;
        } else {
            if (Character.isDigit(s.charAt(i))) {
                helper(s, i+1, partialSolution + s.charAt(i), res);
            } else {
                helper(s, i+1, partialSolution + Character.toUpperCase(s.charAt(i)), res);
                helper(s, i+1, partialSolution + Character.toLowerCase(s.charAt(i)), res);
            }
        }
    }
}
