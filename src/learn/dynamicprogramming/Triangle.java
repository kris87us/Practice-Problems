package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(Arrays.asList(2)));
        input.add(new ArrayList<>(Arrays.asList(3, 4)));
        input.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        input.add(new ArrayList<>(Arrays.asList(4,1,8,3)));

        System.out.println(minimumTotal(input));
        System.out.println(minimumTotal_Optimized(input));
    }

    // Bottom up tabulation
    // Time: O(m x n)
    // Space: O(m x n)
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> table = new ArrayList<>();
        // Base case
        table.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 0));
            row.set(0, triangle.get(i).get(0) + table.get(i - 1).get(0));
            row.set(row.size() - 1, triangle.get(i).get(triangle.get(i).size() - 1) + table.get(i - 1).get(triangle.get(i-1).size() - 1));
            table.add(row);
        }

        // DP case
        for (int i = 2; i < table.size(); i++) {
            // Don't hit the right-side wall, stop before it 
            for (int j = 1; j < table.get(i).size() - 1; j++) {
                int min = Math.min(table.get(i - 1).get(j - 1), table.get(i - 1).get(j));
                table.get(i).set(j, min + triangle.get(i).get(j));
            }
        }
        return table.get(table.size() - 1).stream().min(Integer::compare).get();
    }

    // Invert the Triangle and compute from top-down in-place
    // Time: O(m x n)
    // Space: O(1)
    public static int minimumTotal_Optimized(List<List<Integer>> triangle) {
        // Start from 2nd last row, so we can look up to the row above to compute the min total
        for (int i = triangle.size() - 2; i >= 0; i--) {
            // Column will be normal and go from 0 to i - 1
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // Look up to the row above and compute min
                int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, min + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }
}
