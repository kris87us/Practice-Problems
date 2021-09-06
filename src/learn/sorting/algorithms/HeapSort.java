package learn.sorting.algorithms;

import java.util.Arrays;

import helper.Helper;

public class HeapSort {
    public static void main(String[] args) {
        int[] input = new int[] {5,4,6,7,8,1};
        heapSort(input, input.length);
        System.out.print(Arrays.toString(input));
    }

    private static void heapSort(int[] input, int n) {
        // Build heap
        for (int i = (n/2)-1; i>=0; i--) {
            heapify(input, n, i);
        }
        // Delete nodes (Extract max) 
        // Needed for MIN HEAP
        for (int j = n - 1; j >= 0; j--) {
            Helper.swapArray(input, 0, j);
            heapify(input, j - 1, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            Helper.swapArray(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}
