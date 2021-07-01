package learn.sorting.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helper.Helper.convertIntegerListToArray;
// Time : O(n + k)
// Space : O(n)
public class CountingSort {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(countingSort(new int[]{1, 2, 3, 0, 0, 9, 7, 1, 2, 7, 8}, 9)));
    }

    private static int[] countingSort(int[] arr, int k) {
        int[] arrWithCounts = new int[k+1];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            ++arrWithCounts[arr[i]];
        }

        for (int i = 0; i < arrWithCounts.length; i++) {
            while (arrWithCounts[i] != 0) {
                result.add(i);
                arrWithCounts[i]--;
            }
        }
        return convertIntegerListToArray(result);
    }
}
