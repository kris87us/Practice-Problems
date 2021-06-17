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
    }
}
