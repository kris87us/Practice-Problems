package learn.sorting;

import java.util.Arrays;

// Time : O(nlog n)
// Space : O(n)
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 3, 2, 6, 5, 4};

        System.out.print(Arrays.toString(mergeSort(arr)));
    }

    private static int[] mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSortHelper(int[] arr, int start, int end) {
        if (start >= end) return;
        // Divide in the middle
        int mid = (start + end) / 2;
        // Recursion Magic for solving smaller sub-arrays
        mergeSortHelper(arr, start, mid);
        mergeSortHelper(arr, mid + 1, end);

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
