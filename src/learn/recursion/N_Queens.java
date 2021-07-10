package learn.recursion;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {

    public static void main(String[] args) {
        n_queens(4);
    }

    private static String[][] n_queens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        String[][] partialSolution = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                partialSolution[i][j] = "-";
            }
        }
        helper(n, 0, partialSolution, result);
        return listToArray(result);
    }

    private static void helper(int n, int i, String[][] partialSolution, List<String[]> result) {
        // Base case
        if (i == n) {
            String[] internal = new String[n];
            for (int x = 0; x < n; x++) {
                internal[x] = String.join("", partialSolution[x]);
            }
            result.add(internal);
            return;
        }
        // Recursive case
        // Iterate through each column and try to place queen
        for (int col = 0; col < n; col++) {
            if (isValid(i, col, partialSolution, result, n)) {
                partialSolution[i][col] = "q";
                helper(n, i + 1, partialSolution, result);
                partialSolution[i][col] = "-";
            }
        }
    }

    private static boolean isValid(int row, int col, String[][] partialSolution, List<String[]> result, int n) {
        // Check if row above has queen in the same column
        boolean valid = true;
        int i = row;
        while (i > 0) {
            if (partialSolution[i - 1][col] == "q") {
                valid = false;
            }
            i--;
        }
        // Check if right upper diagonals have attacking queen
        i = row;
        int j = col;
        while (i > 0) {
            if (j < n - 1) {
                // Right upper diagonal
                if (partialSolution[i - 1][j + 1] == "q") {
                    valid = false;
                }
            }
            j++;
            i--;
        }
        // Check if left upper diagonals have attacking queen
        i = row;
        j = col;
        while (i > 0 && j > 0) {
            // Left upper diagonal
            if (partialSolution[i - 1][j - 1] == "q") {
                valid = false;
            }
            j--;
            i--;
        }
        return valid;
    }

    private static String[][] listToArray(List<String[]> input) {
        String[][] result = new String[input.size()][];
        for (int i = 0; i < input.size(); i++) {
            result[i] = input.get(i);
        }
        return result;
    }
}
