package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static helper.Helper.swapArray;
import static helper.Helper.swapArrayList;

class OddEvenComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if ((o1 % 2 == 0) && (o2 % 2 == 0)) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class Segregate_even_and_odds {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(quickSort(new int[]{4, 9, 5, 24, 2, 6, 8, 1, 2, 9, 5, 7, 10})));
    }

    private static int[] quickSort(int[] arr) {
        return quickSortHelper(arr, 0, arr.length - 1, new OddEvenComparator());
    }

    private static int[] quickSortHelper(int[] arr, int start, int end, OddEvenComparator comparator) {
        if (start >= end) return null;
        // Select PIVOT
        int randomIndex = (start + end) / 2;
        // Put Pivot to the HEAD
        swapArray(arr, start, randomIndex);

        int pivot = arr[start];

        int smallerIndex = start;
        int biggerIndex = start + 1;
        // Partitioning
        for (int i = biggerIndex; i <= end;) {
            if (comparator.compare(arr[i], pivot) == 1) {
                smallerIndex++;
                swapArray(arr, i, smallerIndex);
            }
            i++;
        }
        swapArray(arr, smallerIndex, start);

        // Recursion
        quickSortHelper(arr, start, smallerIndex - 1, comparator);
        quickSortHelper(arr, smallerIndex + 1, end, comparator);

        return arr;
    }

    static ArrayList<Integer> segregate_evens_and_odds(ArrayList<Integer> numbers) {
        // Write your code here.
        int odd = numbers.size() - 1;
        int even = 0;

        while (even < odd) {
            int elementAtEvenIndex = numbers.get(even);
            int elementAtOddIndex = numbers.get(odd);

            if ((elementAtEvenIndex % 2 != 0) && (elementAtOddIndex % 2 == 0)) { // ElementAtEvenIndex is Odd
                swapArrayList(numbers, even, odd);
                even++;
                odd--;
            } else if (elementAtOddIndex % 2 == 0) {
                even++;
            } else {
                odd--;
            }
        }
        return numbers;
    }


}
