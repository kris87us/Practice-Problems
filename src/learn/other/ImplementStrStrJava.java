package learn.other;

public class ImplementStrStrJava {

    public static int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}
