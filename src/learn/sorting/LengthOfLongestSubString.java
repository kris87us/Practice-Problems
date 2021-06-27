package learn.sorting;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("qrsvbspk"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Set<Character> temp = new HashSet<>();
        int first = 0;
        int second = 0;
        int max = 0;

        while (second < s.length()) {
            char c = s.charAt(second);
            while (temp.contains(c)) {
                temp.remove(s.charAt(first));
                first++;
            }
            temp.add(c);
            max = Math.max(max, second - first + 1);
            second++; // 2
        }

        return max;
    }
}
