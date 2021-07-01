package learn.sorting.algorithms;

import java.util.Arrays;

// Time : O(n^2)
// Space : O(1)
public class BubbleSort {
    public static int[] bubbleSortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(bubbleSortArray(new int[]{3, 4, 5, 1, 2})));
    }
}
