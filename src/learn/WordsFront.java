package learn;

public class WordsFront {
    public static String[] wordsFront(String[] words, int n) {
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = words[i];
        }
        return strArray;
    }

    public static void main(String[] args) {
        System.out.println(wordsFront(new String[]{"a", "b", "c", "d"}, 1));
    }
}
