package learn.sorting;

import java.util.*;

// Time: O(n)
// Space: O(n)
public class Kth_Largest_In_Array {
    public static void main(String[] args) {
        System.out.print(kth_largest_in_an_array(new ArrayList<>(Arrays.asList(4, 5, 1, 2, 9)), 3));
    }

    public static int kth_largest_in_an_array(List<Integer> numbers, int k) {
        quickSelectHelper(numbers,
                0, numbers.size() - 1, numbers.size() - k);
        return numbers.get(numbers.size() - k);
    }

    public static void quickSelectHelper(List<Integer> numbers, int start, int end, int k) {
        if (start >= end) return;
        int pivotIndex = pickRandom(start, end);
        int pivotElement = numbers.get(pivotIndex);
        int smaller = start;
        int mid = start;
        int bigger = end;
        while (mid <= bigger) {
            if (numbers.get(mid) < pivotElement) {
                Collections.swap(numbers, smaller, mid);
                smaller++;
                mid++;
            } else if (numbers.get(mid) > pivotElement) {
                Collections.swap(numbers, mid, bigger);
                bigger--;
            } else {
                mid++;
            }
        }
        if (k >= smaller && k < mid)
            return;
        else if (k > mid)
            quickSelectHelper(numbers, mid + 1, end, k);
        else if (k < smaller)
            quickSelectHelper(numbers, start, smaller - 1, k);
    }

    public static int pickRandom(int start, int end) {
        Random rand = new Random();
        return rand.nextInt((end - start) + 1) + start;
    }
}
