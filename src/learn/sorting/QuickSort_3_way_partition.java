package learn.sorting;

import helper.Helper;

import java.util.Arrays;
import java.util.Random;

// Time : O(nlog n) Worst Case: O(n^2)
// Space : O(1)
public class QuickSort_3_way_partition {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 5, 7,11, 5, 7, 8, 9, 1, 2};
        System.out.print(Arrays.toString(quickSort(arr)));
    }

    private static int[] quickSort(int[] arr) {
        return quickSortHelper(arr, 0, arr.length - 1);
    }

    private static int[] quickSortHelper(int[] arr, int start, int end) {
        if (start >= end) return null;
        // Select PIVOT
        Random rand = new Random();
        // Pick a random index for the pivot element
        int randomIndex = rand.nextInt((end - start) + 1) + start;
        // Put Pivot to the HEAD
        swap(arr, start, randomIndex);

        int pivot = arr[start];

        // Partitioning
        int finalPivot = Helper.threeWayPartition(arr, start, start,start + 1, pivot, start, end);

        // Recursion
        quickSortHelper(arr, start, finalPivot - 1);
        quickSortHelper(arr, finalPivot, finalPivot - 1);
        quickSortHelper(arr, finalPivot + 1, end);

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
