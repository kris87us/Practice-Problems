package learn.other;

import java.util.HashMap;

public class RomanToInteger {
    @SuppressWarnings("unchecked")
    public static int romanToInt(String s) {
        HashMap<String, Integer> roman = new HashMap();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);

        Integer sum = 0;
        int i = 0;
        if (roman.containsKey(s)) return roman.get(s);

        while (i < s.length()) {
            if ((i+1) < s.length() && roman.get(String.valueOf(s.charAt(i))) < roman.get(String.valueOf(s.charAt(i+1)))) {
                sum += roman.get(String.valueOf(s.charAt(i+1))) - roman.get(String.valueOf(s.charAt(i)));
                i += 2;
            } else {
                sum += roman.get(String.valueOf(s.charAt(i)));
                i += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
