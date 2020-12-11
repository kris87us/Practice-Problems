package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        List<String> newList = new ArrayList<>();
        for(char c : chars) {
            if (String.valueOf(c).matches("^[a-zA-Z0-9]*$")) {
                list.add(String.valueOf(c).toLowerCase());
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return list.equals(newList);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
