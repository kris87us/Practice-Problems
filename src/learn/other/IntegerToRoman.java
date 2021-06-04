package learn.other;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap();
        map.put(1, "I"); map.put(5, "V"); map.put(10, "X");
        map.put(50, "L"); map.put(100, "C"); map.put(500, "D"); map.put(1000, "M");
        map.put(4, "IV"); map.put(9, "IX"); map.put(40, "XL"); map.put(90, "XC");
        map.put(400, "CD"); map.put(900, "CM");

        int[] sequence = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // 58

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<sequence.length; i++) {
            int base = sequence[i]; // 50, 5

            while (num >= base) {
                sb.append(map.get(base)); // sb = LV
                num -= base; // 8-5=3
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
