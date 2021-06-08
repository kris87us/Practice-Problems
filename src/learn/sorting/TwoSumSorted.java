package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time: O(n)
// Space: O(n)
public class TwoSumSorted {
    public static void main(String[] args) {
        System.out.print(twoSumSorted(Arrays.asList(1,4,5,10,15), 9));
    }

    private static List<Integer> twoSumSorted(List<Integer> nums, int target) {
        // Two Pointer approach
        int i = 0;
        int j = nums.size() - 1;

        List<Integer> res = new ArrayList<>();

        while (i < j) {
            int sum = nums.get(i) + nums.get(j);
            if (sum == target) {
                res.add(i);
                res.add(j);

                return res;
            } else if (sum > target) {
                j--;
            } else i++;
        }
        if (res.size() < 1) {
            res.add(-1);
            res.add(-1);
        }
        return res;
    }
}
