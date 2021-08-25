package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    // Bottom-up tabulation
    // Time: O(n^2)
    // Space: O(n^2)
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> table = new ArrayList<>();
        // Base case
        for (int row = 0; row < numRows; row++) {
            List<Integer> rows = new ArrayList<>(Collections.nCopies(row + 1, 0));
            rows.set(0, 1);
            rows.set(rows.size() - 1, 1);
            table.add(rows);
        }
        // DP case
        for (int row = 2; row < numRows; row++) {
            for (int col = 1; col < row; col++) {
                int a = table.get(row - 1).get(col - 1);
                int b = table.get(row - 1).get(col);
                table.get(row).set(col, a + b);
            }
        }
        return table;
    }
}
