package learn;

import java.util.Arrays;

public class MatchingStrings {
    public static void main(String[] args) {
        int [] result = matchingStrings(new String[]{"aba", "baba", "aba", "xzxb"},
                new String[]{"aba", "xzxb", "ab"});
        System.out.println(Arrays.toString(result));
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = 0; j < strings.length; j++) {
                if (queries[i] == strings[j]) {
                    count += 1;
                    output[i] = count;
                }
            }
        }
        return output;
    }
}
