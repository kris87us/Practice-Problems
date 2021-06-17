package learn.sorting;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArrays {
    public static List<Integer> intersectionOfThreeSortedArrays(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        List<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
            int a = arr1.get(i);
            int b = arr2.get(j);
            int c = arr3.get(k);

            if (a == b && b == c) {
                result.add(a);
                i++;
                j++;
                k++;
            } else if (a <= b && a <= c) {
                i++;
            } else if (b <= c && b <= a) {
                j++;
            } else if (c <= a && c <= b) {
                k++;
            }
        }
        if (result.size() == 0) result.add(-1);
        return result;
    }
}
