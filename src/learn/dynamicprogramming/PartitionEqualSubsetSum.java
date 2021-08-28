package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(equalSubSetSumPartition(List.of(10, -3, 7, 2, 1, 3)));
    }

    public static List<Boolean> equalSubSetSumPartition(List<Integer> s) {
        // Write your code here
        List<Boolean> table = new ArrayList<>(Collections.nCopies(s.size(), false));
        // Calculate total sum
        int totalSum = s.stream().reduce(0, (a, b) -> a + b);
        int targetSubsetSum = (totalSum % 2 == 0) ? totalSum / 2 : 0;
        if (targetSubsetSum == 0) return table;

        // DP Case
        // for (Integer e : s) {
        //     if (targetSubsetSum)
        // }
        return null;
    }
}
