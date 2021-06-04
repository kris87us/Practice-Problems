package learn.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.print(Arrays.toString(insertionSort(arr)));
        System.out.print(Arrays.toString(insertionSortRecursive(arr, arr.length - 1)));
    }

    // ITERATIVE APPROACH
    private static int[] insertionSort(int[] arr) {
        if (arr.length < 1) return arr;

        for (int i = 0; i <= arr.length - 1; i++) {
            int nth = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > nth) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = nth;
        }
        return arr;
    }

    // RECURSIVE APPROACH
    private static int[] insertionSortRecursive(int[] arr, int n) {
        if (n <= 1) return arr;
        insertionSortRecursive(arr, n - 1);

        int nth = arr[n];
        int j = n - 1;
        while (j >= 0 && arr[j] > nth) {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = nth;

        return arr;
    }
}
