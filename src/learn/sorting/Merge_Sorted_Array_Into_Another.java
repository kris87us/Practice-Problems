package learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_Sorted_Array_Into_Another {

    public static void main(String[] args) {
        System.out.print(merge_one_into_another(
                new ArrayList<>(Arrays.asList(1,3,5)),
                new ArrayList<>(Arrays.asList(2,4,6,0,0,0))
        ));
    }

    static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
        // Write your code here.
        int i = 0;
        int j = 0;
        int k = first.size() - 1;

        while (i <= first.size() - 1 && j <= k) {
            if (first.get(i) <= second.get(j)) {
                int x = k;
                while (x >= j) {
                    second.set(x + 1, second.get(x));
                    x--;
                }
                second.set(j, first.get(i));
                i++;
                j++;
                k++;
            } else {
                j++;
            }
        }
        return second;
    }

    static ArrayList<Integer> merge_one_into_another_InsertionSort(ArrayList<Integer> first, ArrayList<Integer> second) {
        // Write your code here.
        int i = 0;
        for (Integer n : first) {
            int indexToInsert = second.size() - first.size() + i;
            second.set(indexToInsert, n);

            int j = indexToInsert - 1;

            while (j >= 0 && second.get(j) > n) {
                second.set(j+1, second.get(j));
                j--;
            }
            second.set(j+1, n);
            i++;
        }
        return second;
    }

}
