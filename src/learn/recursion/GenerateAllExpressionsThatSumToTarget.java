package learn.recursion;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: 
//   Between each digit we have 3 different things we could do:
//   1.) do nothing and concatenate the two digits together
//   2.) add ' + ' between the two digits
//   3.) add ' * ' between the two digits
//   Each call branches into 3 additional calls, and each call has a time complexity of O(n) which is the cost of copying a valid path to the result
//   T(n) = 3T(n - 1) + O(n) which is roughly O(n 3^n)

// Space Complexity: 
//    Input = O(N)
//    Aux = O(N * N)
//      Call stack space at any given point in time, there will be N recursive helpers in the stack since we are doing DFS. 
//      s.subString will create a new String everytime. Can be optimzed by using a char[]
//    Output = O(N)
// Overall: O(N * N)

public class GenerateAllExpressionsThatSumToTarget {
    public static void main(String[] args) {
        generate_all_expressions("222", 24);
    }

    static String[] generate_all_expressions(String s, long target) {
        List<String> result = new ArrayList<String>();
        helper(s, 0, 0, new StringBuilder(), result, target, 0);
        
        return result.toArray(new String[0]);
    }

    // Maintain a "last" variable to store the last digit operation that was computed
    // (1 + 2) Here last will be 2
    // (1 + 2 * 3) Here last will be 6, to give precedence to multiplication
    private static void helper(String s, int i, int runningSum, StringBuilder partialSolution, List<String> result, long target, int last) {
        // Backtracking case
        if (i == s.length()) {
            if (runningSum == target) {
                result.add(partialSolution.toString());
            }
            return;
        }

        // Recursive case
        // We can choose single digit as operands OR multi digits as operand ( 1 + 2 OR 12 + 34 )
        for (int c = i; c < s.length(); c++) {
            // Start with single digits and then go on to choosing multi-digits ( 1 + 2 OR 12 + 34). No need of a special JOIN case
            String curr = s.substring(i, c + 1);
            Integer currInt = Integer.parseInt(curr);
            // Length of slate before recursion. Used to undo the slate, easier than deleting characters.
            int len = partialSolution.length();
            if (i == 0) {
                partialSolution.append(curr);
                helper(s, c + 1, currInt, partialSolution, result, target, currInt);
                partialSolution.setLength(len);
            } else {
                // Addition
                partialSolution.append("+");
                partialSolution.append(curr);
                helper(s, c + 1, runningSum + currInt, partialSolution, result, target, currInt);
                partialSolution.setLength(len);
                
                // Multiply            
                /**
                 * As this has the highest precedence than +, we simply can't apply * on last and current value.
                 * Current value become = currentValue - lastValue + last*currentDigitvalue;
                 * For example:
                 * runningSum = 12 ,
                 * last = 2 ( let say we applied + as 10 + 2 )
                 * curr = 4
                 * so partial solution : 10 + 2 * 4
                 * if we simply do 12 * 4 = 24 which is wrong as 10 + 2 * 4 = 10 + 8 = 18
                 * So, we have to subtract last value from runningSum, do the multiplication and add it back
                 * 
                 * New value = 10 + 2 * 4 = 18 ( 10 + 2 - 2 + 2 * 4 ) [(runningSum - last) + (last * curr)]
                 * last value = 2*4 = 8
                 *
                 *
                 */
                partialSolution.append("*");
                partialSolution.append(curr);
                helper(s, c + 1, (runningSum - last) + (last * currInt), partialSolution, result, target, last * currInt);
                partialSolution.setLength(len);
            }
        }
    }
}
