package learn.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsFromPhoneNumber {
    public static void main(String[] args) {
        System.out.print(getWordsFromPhoneNumber("123"));
    }

    public static List<String> getWordsFromPhoneNumber(String phoneNumber) {
        // Write your code here
        final Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");

        List<String> result = new ArrayList<String>();
        phoneNumber = phoneNumber.replace("0", "").replace("1", "");
        if (phoneNumber.isEmpty()) {
            result.add("-1");
        } else {
            helper(phoneNumber, 0, new StringBuilder(), result, map, phoneNumber.length());
        }

        return result;
    }

    private static void helper(String subproblem, int i, StringBuilder partialSolution, List<String> result,
            Map<Integer, String> map, int k) {

        // Backtracking
        if (k == partialSolution.length()) {
            result.add(new String(partialSolution.toString()));
            return;
        }
        // Base case
        if (i == subproblem.length()) {
            return;
        }

        Integer digit = Character.getNumericValue(subproblem.charAt(i));
        // Recursion
        // Exclude
        helper(subproblem, i + 1, partialSolution, result, map, k);

        // Include
        for (Character c : map.get(digit).toCharArray()) {
            partialSolution.append(c);
            helper(subproblem, i + 1, partialSolution, result, map, k);
            partialSolution.deleteCharAt(partialSolution.length() - 1);
        }
    }
}
