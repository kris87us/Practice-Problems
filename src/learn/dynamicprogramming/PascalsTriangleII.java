package learn.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII {
    public static void main(String[] args) {
        System.out.println(getRow(4));
    }

    // Time: O(k)
    // Space: O(k)
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> table = new ArrayList<>();
        List<Integer> row = new ArrayList<Integer>(Collections.nCopies(rowIndex + 1, 0));
        // Base case
        row.set(0, 1);
        
        // Compute only the row that is required
        // Use binomial co-efficient
        // Because, n C k and n C k-1 differ by (n C k) / (n C k-1). Evaluate this to get the expression.
        // Every element = row[i - 1] * (n - k + 1 / k)
        for (int i = 1; i < row.size() - 1; i++) {
            int val = (int) ((row.get(i - 1)) * (long)(rowIndex - i + 1) / i);
            row.set(i, val);
        }
        row.set(row.size() - 1, 1);
        table.add(row);
        return table.get(0);
    }
}
