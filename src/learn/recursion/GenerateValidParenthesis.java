package learn.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n, n, new StringBuilder(), result);
        return result;
    }

    private static void helper(int numOfLeftParanthesisRemaining, int numOfRightParanthesisRemaining, StringBuilder partialSolution, List<String> result) {
        // Backtracking case
        // Example: If partialSolution has "())" we can prune remaining subtrees because there is no way we can make a valid paranthesis pattern after this partialSolution
        if (numOfLeftParanthesisRemaining > numOfRightParanthesisRemaining) {
            return;
        }
        // Base case
        if (numOfLeftParanthesisRemaining == 0 && numOfRightParanthesisRemaining == 0) {
            result.add(new String(partialSolution));
            return;
        }
        // Recursive case
        if (numOfLeftParanthesisRemaining > 0) {
            partialSolution.append("(");
            helper(numOfLeftParanthesisRemaining - 1, numOfRightParanthesisRemaining, partialSolution, result);
            partialSolution.deleteCharAt(partialSolution.length() - 1);
        }
        if (numOfRightParanthesisRemaining > 0) {
            partialSolution.append(")");
            helper(numOfLeftParanthesisRemaining, numOfRightParanthesisRemaining - 1, partialSolution, result);
            partialSolution.deleteCharAt(partialSolution.length() - 1);
        }
    }
}
