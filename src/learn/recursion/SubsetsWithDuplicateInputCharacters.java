package learn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time:
// Leaf workers = 2^n workers and each worker is doing O(n) work = O(n * 2^n)
// Internal workers = O(1 * 2^n)
// Overall ==> O(n * 2^n)

// Space:
// Input(O(n)) = Input array of n elements
// Aux(O(n)) = Screenshot at each leaf level will be O(n)
// Output(O(n*2^n)) = Output array of 2^n sub-arrays, with each sub-array almost having n/2 elements on average.
// Overall ==> O(n * 2^n)

public class SubsetsWithDuplicateInputCharacters {
    public static void main(String[] args) {
        System.out.print(get_distinct_subsets("dc"));
    }

    public static List<String> get_distinct_subsets(String str) {
        // Sort the input
        char[] input = str.toCharArray();
        Arrays.sort(input);
        
        List<String> result = new ArrayList<String>();
        // Call recursion helper
        helper(input, 0, new StringBuilder(), result);
        return result;
    }
    
    private static void helper(char[] subproblem, int i, StringBuilder partialSolution, List<String> result) {
        // Base case
        if (i == subproblem.length) {
            result.add(partialSolution.toString());
            return;
        }
        
        // Recursion case
        
        // Count the number of duplicates
        int count = 0;
        for (int dup = i; dup < subproblem.length; dup++) {
            if (subproblem[dup] != subproblem[i]) {
                break;
            }
            count++;
        }
        
        // Exclusion
        helper(subproblem, i + count, partialSolution, result);
        
        // Inclusion
        // Loop through all the duplicates and send them down to the subordinate
        for (int c = 1;c <= count;c++) {
            partialSolution.append(subproblem[i]);
            // i+count because my next subordinate has to skip all duplicates and look at next number, since I am processing the duplicates.
            helper(subproblem, i + count, partialSolution, result);
        }
        
        // Remove the added element to clean the slate
        for (int j = 1;j <= count;j++) {
            partialSolution.deleteCharAt(partialSolution.length() - 1);
        }
    }
}
