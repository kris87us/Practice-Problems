package learn.sorting.algorithms;

import java.util.Arrays;
// Time : O(n^2)
// Space : O(1)
public class SelectionSort {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(selectionSort(new int[]{3, 4, 5, 1, 2})));
    }

    private static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}
