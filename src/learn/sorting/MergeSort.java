package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helper.Helper.convert;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2, 8};
        System.out.print(Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] arr) {
        return mergeSortHelper(arr, 0, arr.length - 1);
    }

    private static int[] mergeSortHelper(int[] arr, int start, int end) {
        if (start >= end) return arr;
        // Divide in the middle
        int mid = (start + end) / 2;
        // Recursion Magic for solving smaller sub-arrays
        mergeSortHelper(arr, start, mid);
        mergeSortHelper(arr, mid + 1, end);

        // Combine/Merge the resultant sub-arrays
        // HEAD of both the smaller sub-arrays
        int i = start;
        int j = mid + 1;
        List<Integer> aux = new ArrayList<>();

        // Compare if HEAD is smaller and merge into AUX array
        while (i <= mid && j <= end) { // Loop till the edge
            if (arr[i] <= arr[j]) {
                aux.add(arr[i]);
                i++;
            } else {
                aux.add(arr[j]);
                j++;
            }
        }
        // Add remaining elements to AUX array that didn't get added in the above loop
        // Loop won't execute if all elements got added above
        while (i <= mid) {
            aux.add(arr[i]);
            i++;
        }
        while (j <= end) {
            aux.add(arr[j]);
            j++;
        }
        return convert(aux);
    }
}
