package learn.sorting;

import java.util.Arrays;
import java.util.Comparator;

// Time: O(nlog n)
public class LargestNumber {
    public static void main(String[] args) {
        System.out.print(largestNumber(new int[]{1, 2, 3, 4, 5, 6}));
    }

    private static class LargestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        }
    }

    public static String largestNumber(int[] nums) {
        String[] strInput = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strInput[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strInput, new LargestNumberComparator());

        if (strInput[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String str : strInput) {
            result.append(str);
        }
        return result.toString();
    }
}
