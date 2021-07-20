package learn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time: O(N * 2^N)
// Space: O(N * 2^N)
public class PalindromicDecompositionOfAString {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print(Arrays.toString(generate_palindromic_decompositions("abracadabra")));
    }

    static String[] generate_palindromic_decompositions(String s) {
        helper(s, 0, new StringBuilder());
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i).substring(0, res.get(i).lastIndexOf("|"));
        }
        return result;
    }

    private static void helper(String subproblem, int i, StringBuilder partialSolution) {
        // Base case
        if (i == subproblem.length()) {
            res.add(new String(partialSolution.toString()));
            return;
        }

        // Recursive case
        for (int j = i; j < subproblem.length(); j++) {
            String sub = subproblem.substring(i, j + 1);
            int len = partialSolution.length();
            if (reverse(sub).equals(sub)) {
                partialSolution.append(sub);
                partialSolution.append("|");
                
                helper(subproblem, i + sub.length(), partialSolution);
                
                partialSolution.setLength(len);
            }
        }
    }

    private static String reverse(String s) {
        char[] c = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = c.length - 1; i >= 0; i--)
            res.append(c[i]);
        return res.toString();
    }
}
