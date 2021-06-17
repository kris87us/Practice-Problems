package learn.recursion;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubsetsOfASet {
    public static void main(String[] args) {
        Map<Integer, Double> map = new HashMap<>();
        System.out.print(numberOfSubsets(new int[]{1,2,3,4,5}, 5, map));
    }

    private static double numberOfSubsets(int[] arr, int n, Map<Integer, Double> map) {
        if (n == 0) return 1;
        return 0.0;
//        if (map.containsKey(n)) return map.get(n);
//        else if (n % 2 == 0) {
//            map.put(n, numberOfSubsets(arr, n / 2, map) * numberOfSubsets(arr, n / 2, map));
//        } else {
//            map.put(n, 2 * numberOfSubsets(arr, n - 1, map));
//        }
    }
}
