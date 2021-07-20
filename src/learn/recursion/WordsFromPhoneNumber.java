package learn.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsFromPhoneNumber {
    final static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
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
    }
    
    public static void main(String[] args) {
        System.out.print(getWordsFromPhoneNumber("23"));
    }

    public static List<String> getWordsFromPhoneNumber(String phoneNumber) {
        // Write your code here


        List<String> result = new ArrayList<String>();
        phoneNumber = phoneNumber.replace("0", "").replace("1", "");
        if (phoneNumber.isEmpty()) {
            result.add("-1");
        } else {
            helper(phoneNumber, 0, new StringBuilder(), result);
        }

        return result;
    }

    private static void helper(String subproblem, int i, StringBuilder partialSolution, List<String> result) {
        
        // Base case
        if (i == subproblem.length()) {
            result.add(new String(partialSolution.toString()));
            return;
        }

        Integer digit = Character.getNumericValue(subproblem.charAt(i));
        // Recursion
        // No need of Exclude case
        // Include
        for (Character c : map.get(digit).toCharArray()) {
            partialSolution.append(c);
            helper(subproblem, i + 1, partialSolution, result);
            partialSolution.deleteCharAt(partialSolution.length() - 1);
        }
    }
}
