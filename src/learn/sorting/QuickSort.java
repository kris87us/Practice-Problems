package learn.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
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

        // Initialize two pointers at the HEAD.
        int smaller = start;
        int bigger = start;

        for (bigger = start + 1; bigger <= end;) {
            if (arr[bigger] < pivot) {
                smaller++;
                swap(arr, smaller, bigger);
            }
            bigger++;
        }
        // Swap pivot back to middle
        swap(arr, smaller, start);

        // Recursion
        quickSortHelper(arr, start, smaller - 1);
        quickSortHelper(arr, smaller + 1, end);

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
