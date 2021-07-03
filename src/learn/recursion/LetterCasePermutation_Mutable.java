package learn.recursion;

import java.util.ArrayList;
import java.util.List;

// Time: Leaf node(O(n * 2^n) + Internal node(O(2^n)) = O(n * 2^n)
// Space: Input(O(n)) + Aux(O(n)) + Output(O(n*2^n)) = O(n * 2^n) -- Improvement in Aux space/call stack
// Top down DFS approach

public class LetterCasePermutation_Mutable {
    public static void main(String[] args) {
        letterCasePermutation("acb2");
    }

    private static void letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(s, 0, new char[s.length()], result);
        System.out.print(result);
    }

    private static void helper(String s, int i, char[] partialSolution, List<String> res) {
        if (s.length() == i) {
            res.add(new String(partialSolution));
            return;
        } else {
            if (Character.isDigit(s.charAt(i))) {
                partialSolution[i] = s.charAt(i);
                helper(s, i + 1, partialSolution, res);
            } else {
                partialSolution[i] = Character.toUpperCase(s.charAt(i));
                helper(s, i + 1, partialSolution, res);
                partialSolution[i] = Character.toLowerCase(s.charAt(i));
                helper(s, i + 1, partialSolution, res);
            }
            
        }
    }
}

