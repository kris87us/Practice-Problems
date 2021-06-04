package learn.other;

import java.util.Arrays;

public class WordsFront {
    public static String[] wordsFront(String[] words, int n) {
        String[] strArray = new String[n];
        System.arraycopy(words, 0, strArray, 0, n);
        return strArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wordsFront(new String[]{"a", "b", "c", "d"}, 1)));
    }
}
