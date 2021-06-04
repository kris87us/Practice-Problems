package learn.recursion;

import java.util.Arrays;

public class SumOfNumbersInEachIndexArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        sumOfIndexes(arr, 1);
        System.out.print(Arrays.toString(arr));
    }

    private static void sumOfIndexes(int[] arr, int index) {
        if (index > arr.length - 1) return;

        arr[index] += arr[index - 1];
        sumOfIndexes(arr, index + 1);
    }
}
