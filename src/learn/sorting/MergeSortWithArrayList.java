package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortWithArrayList {
    public static void main(String[] args) {
        System.out.print(merge_sort(new ArrayList<>(Arrays.asList(0, 1, 3, 2))));
    }

    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        // Write your code here.
        int[] input = arr.stream().mapToInt(Integer::intValue).toArray();
        merge_sort_helper(input, 0, input.length - 1);
        ArrayList<Integer> result = new ArrayList<>();

        for (int j : input) {
            result.add(j);
        }
        return result;
    }

    private static void merge_sort_helper(int[] arr, int start, int end) {
        if (start >= end) return;
        // Divide in the middle
        int mid = (start + end) / 2;
        // Recursion Magic for solving smaller sub-arrays
        merge_sort_helper(arr, start, mid);
        merge_sort_helper(arr, mid + 1, end);

        // Combine/Merge the resultant sub-arrays
        // HEAD of both the smaller sub-arrays
        int i = start;
        int j = mid + 1;

        int[] aux = new int[end - start + 1];
        int auxIndex = 0;
        // Compare if HEAD is smaller and merge into AUX array
        while (i <= mid && j <= end) { // Loop till the edge
            if (arr[i] <= arr[j]) {
                aux[auxIndex++] = arr[i++];
            } else {
                aux[auxIndex++] = arr[j++];
            }
        }
        // Add remaining elements to AUX array that didn't get added in the above loop
        // Loop won't execute if all elements got added above
        while (i <= mid) {
            aux[auxIndex++] = arr[i++];
        }
        while (j <= end) {
            aux[auxIndex++] = arr[j++];
        }

        // Copy to arr
        int k = 0;
        while (k < aux.length)
            arr[start++] = aux[k++];
    }
}
