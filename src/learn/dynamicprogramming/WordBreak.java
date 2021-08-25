package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
    }

    // Bottom-up tabulation
    // Time: O(n^3)
    // Space: O(n)
    public static boolean wordBreak(String s, List<String> wordDict) {
        // Convert input dict into a Set for faster lookup
        Set<String> set = new HashSet<>(wordDict);
        boolean[] table = new boolean[s.length() + 1];
        // f(0) is true because all prefixes have been processed and valid
        table[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            // To compute f(i) we rely on every single subproblem solved before.
            // Look at each prefix and check if its valid.
            for (int prefix = 1; prefix <= i; prefix++) {
                if (set.contains(s.substring(i - prefix, i)) && table[i - prefix]) {
                    table[i] = true;
                }
            }
        }
        return table[s.length()];
    }
}
