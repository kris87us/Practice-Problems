package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i-1][1]) {
                result.add(List.of(intervals[i-1][0], intervals[i][1]));
            } else {
                result.add(List.of(intervals[i][0], intervals[i][1]));
            }
        }
        return result.stream().map(a -> a.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    }
}
