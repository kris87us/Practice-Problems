package learn.sorting;

import java.util.Arrays;

public class Merge_Sorted_Array_Into_Another {

    public static void main(String[] args) {
        int[] arr1 = new int[]{13, 21, 24};
        int[] arr2 = new int[]{13, 23, 26, 0, 0, 0};

        merger_first_into_second_Alternative(arr1, arr2);
        System.out.print(Arrays.toString(arr2));
    }

    static void merger_first_into_second_Alternative(int[] arr1, int[] arr2) {
        // Write your code here.
        int i = arr1.length - 1; // End of first array
        int j = i; // Pointing to end of valid elements (before ZERO)
        int index = arr2.length - 1;

        while (i >= 0 && j >= 0 && index >= 0) {
            if (arr1[i] <= arr2[j]) {
                arr2[index--] = arr2[j--];
            } else {
                arr2[index--] = arr1[i--];
            }
        }
        // Move remaining elements
        while (i >= 0 && index >= 0) {
            arr2[index--] = arr1[i--];
        }
        while (j >= 0 && index >= 0) {
            arr2[index--] = arr2[j--];
        }
    }

    static void merger_first_into_second(int[] arr1, int[] arr2) {
        // Write your code here.
        int i = arr1.length - 1;
        int j = arr1.length - 1;
        int end = arr2.length - 1;

        while (i >= 0 && j >= 0 && end >= 0) {
            if (arr1[i] <= arr2[j]) {
                arr2[end--] = arr2[j--];
            } else {
                arr2[end--] = arr1[i--];
            }
        }
        // Move remaining elements
        while (i >= 0 && end >= 0) {
            arr2[end--] = arr1[i--];
        }
        while (j >= 0 && end >= 0) {
            arr2[end--] = arr2[j--];
        }
    }

    @SuppressWarnings("unused")
    static void merge_one_into_another_InsertionSort(int[] arr1, int[] arr2) {
        // Write your code here.
        int i = 0;
        for (Integer n : arr1) {
            int indexToInsert = arr2.length - arr1.length + i;
            arr2[indexToInsert] = n;

            int j = indexToInsert - 1;

            while (j >= 0 && arr2[j] > n) {
                arr2[j + 1] = arr2[j];
                j--;
            }
            arr2[j + 1] = n;
            i++;
        }
    }

}
