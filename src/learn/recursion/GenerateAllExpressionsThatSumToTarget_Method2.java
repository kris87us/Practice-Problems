package learn.recursion;

import java.util.ArrayList;
import java.util.List;

// Does not work for all types of inputs like 05050505
public class GenerateAllExpressionsThatSumToTarget_Method2 {

    public static void main(String[] args) {
        generate_all_expressions("050", 5);
    }

    static String[] generate_all_expressions(String s, long target) {
        StringBuilder slate = new StringBuilder();
        List<String> result = new ArrayList<>();
        helper(s, 0, slate, result, target, 0, 0);
        System.out.printf("%d combinations", result.size());
        return result.toArray(new String[0]);
    }

    public static void helper(String subProblem, int index, StringBuilder slate, List<String> result, long target,
            long runningSum, long last) {

        System.out.println(slate.toString());
        // Backtracking
        if (index == subProblem.length()) {
            if (runningSum == target) {
                result.add(slate.toString());
            }
            return;
        }
        
        long currInt = Character.getNumericValue(subProblem.charAt(index));

        if (index == 0) {
            slate.append(subProblem.charAt(index));
            helper(subProblem, index + 1, slate, result, target, currInt, currInt);
            slate.deleteCharAt(slate.length() - 1);
        } else {
            // Join Case
            String lastVal = String.valueOf(last).concat(String.valueOf(subProblem.charAt(index)));
            slate.append(subProblem.charAt(index));
            helper(subProblem, index + 1, slate, result, target, (runningSum - last) + Long.parseLong(lastVal),
                    Long.parseLong(lastVal));
            slate.deleteCharAt(slate.length() - 1);

            // Multiply Case
            slate.append("*");
            slate.append(subProblem.charAt(index));
            helper(subProblem, index + 1, slate, result, target, (runningSum - last) + (last * currInt),
                    last * currInt);
            slate.deleteCharAt(slate.length() - 1);
            slate.deleteCharAt(slate.length() - 1);

            // Addition Case
            slate.append("+");
            slate.append(subProblem.charAt(index));
            helper(subProblem, index + 1, slate, result, target, runningSum + currInt, currInt);
            slate.deleteCharAt(slate.length() - 1);
            slate.deleteCharAt(slate.length() - 1);

        }
    }
}
