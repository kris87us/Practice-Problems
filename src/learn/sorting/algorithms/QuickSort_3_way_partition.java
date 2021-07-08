package learn.sorting.algorithms;

import java.util.Arrays;

// Time : O(n log n) Worst Case: O(n^2)
// Space : O(1)
public class QuickSort_3_way_partition {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 4, 2, 4, 1, 2, 4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4};
        quickSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int start, int end) {
        if (start >= end) return;
        // Select PIVOT
        int mid = (start + end) / 2;
        // Put Pivot to the HEAD
        swap(arr, start, mid);

        int pivot = arr[start];

        // Partitioning
        int smaller = start;
        int bigger = end;

        // Running pointer
        int i = start + 1;

        while (i <= bigger) {
            if (arr[i] < pivot) {
                swap(arr, i++, smaller++);
            } else if (arr[i] > pivot) {
                swap(arr, i, bigger--);
            } else {
                i++;
            }
        }
        // Recursion
        quickSortHelper(arr, start, smaller - 1);
        quickSortHelper(arr, bigger + 1, end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
