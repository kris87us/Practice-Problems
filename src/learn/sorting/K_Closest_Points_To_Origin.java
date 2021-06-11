package learn.sorting;

import java.util.Arrays;

import static helper.Helper.pickRandom;
import static helper.Helper.swap2DArray;

public class K_Closest_Points_To_Origin {
    public static void main(String[] args) {
        System.out.print(Arrays.deepToString(kClosest(new int[][]{{2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {2, 2}, {1, 1}}, 1)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        quickSelectHelper(points, 0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private static void quickSelectHelper(int[][] points, int start, int end, int k) {
        if (start >= end) return;

        int mid = pickRandom(start, end);
        int[] pivot = points[mid];
        swap2DArray(points, start, mid);

        int smaller = start;
        int bigger = start + 1;
        for (int i = bigger; i <= end; ) {
            if (closest(points[i]) <= closest(pivot)) {
                smaller++;
                swap2DArray(points, smaller, i);
            }
            i++;
        }
        swap2DArray(points, start, smaller);

        if (k == smaller) {
            return;
        } else if (k < smaller) {
            quickSelectHelper(points, start, smaller - 1, k);
        } else {
            quickSelectHelper(points, smaller + 1, end, k);
        }
    }

    private static int closest(int[] x) {
        return x[0] * x[0] + x[1] * x[1];
    }
}
