package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(equalSubSetSumPartition(List.of(10, -3, 7, 2, 1, 3)));
        System.out.println(equalSubSetSumPartition(List.of(1, 5, 11, 5)));
        System.out.println(equalSubSetSumPartition(List.of(0, 0)));
    }

    public static List<Boolean> equalSubSetSumPartition(List<Integer> s) {
        // Write your code here
        List<Boolean> table = new ArrayList<>(Collections.nCopies(s.size(), false));
        // Calculate total sum
        int totalSum = s.stream().reduce(0, (a, b) -> a + b);
        if (totalSum == 0) {
            for (int i = 0; i < s.size() / 2; i++) {
                table.set(i, true);
            }
            return table;
        }
        int targetSubsetSum = (totalSum % 2 == 0) ? totalSum / 2 : 0;
        if (targetSubsetSum == 0) return table;

        // DP Case
        // Recurrence Relation : 
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == targetSubsetSum) {
                table.set(i, true);
                break;
            } else if (s.get(i) > targetSubsetSum) {
                table.set(i, false);
            } else {
                targetSubsetSum = targetSubsetSum - s.get(i);
                if (targetSubsetSum >= 0) table.set(i, true);
            }

        }
        return table;

    }
}
