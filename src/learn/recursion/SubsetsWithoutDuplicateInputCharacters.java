package learn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithoutDuplicateInputCharacters {
    static List<String> resList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print(Arrays.toString(generate_all_subsets("abracadabra")));
    }

    static String[] generate_all_subsets(String s) {
        helper(s, 0, new StringBuilder());
        String[] result = new String[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        return result;
    }
    
    private static void helper(String subproblem, int i, StringBuilder partialSolution) {
        // Base case
        if (i == subproblem.length()) {
            resList.add(new String(partialSolution.toString()));
            return;
        }
        // Recursive case
        // Exclusion
        helper(subproblem, i+1, partialSolution);
        // Inclusion
        partialSolution.append(subproblem.charAt(i));
        helper(subproblem, i+1, partialSolution);
        partialSolution.deleteCharAt(partialSolution.length() - 1);
    }
}
