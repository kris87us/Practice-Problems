package learn.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// Time: O(N!)
// Space: O(N^2)
public class N_Queens_Optimal {

    public static void main(String[] args) {
        n_queens(4);
    }

    private static List<List<String>> n_queens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<Integer> partialSolution = new ArrayList<>();
        Set<Integer> col_set = new HashSet<Integer>();
        Set<Integer> forward_diagonal_set = new HashSet<Integer>();
        Set<Integer> backward_diagonal_set = new HashSet<Integer>();

        helper(n, 0, col_set, forward_diagonal_set, backward_diagonal_set, partialSolution, result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        return result;
    }

    private static List<String> createBoard(List<Integer> partialSolution) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < partialSolution.size(); row++) {
            StringBuilder build = new StringBuilder();
            for (int col = 0; col < partialSolution.size(); col++) {
                if (col == partialSolution.get(row)) {
                    build.append("Q");
                } else {
                    build.append(".");
                }
            }
            board.add(build.toString());
        }

        return board;
    }

    private static void helper(int n, int i, Set<Integer> col_set, Set<Integer> forward_diagonal_set,
            Set<Integer> backward_diagonal_set, List<Integer> partialSolution, List<List<String>> result) {
        // Base case  
        if (i == n) {
            result.add(createBoard(partialSolution));
            return;
        }
        // Recursive case
        // Iterate through each column and try to place queen
        for (int col = 0; col < n; col++) {
            if (isValid(col_set, forward_diagonal_set, backward_diagonal_set, i, col, n)) {
                partialSolution.add(col);
                col_set.add(col);
                forward_diagonal_set.add(i + col);
                backward_diagonal_set.add(i - col + n - 1);
                helper(n, i + 1, col_set, forward_diagonal_set, backward_diagonal_set, partialSolution, result);
                backward_diagonal_set.remove(i - col + n - 1);
                forward_diagonal_set.remove(i + col);
                col_set.remove(col);
                partialSolution.remove(partialSolution.size() - 1);
            }
        }
    }

    private static boolean isValid(Set<Integer> col_set, Set<Integer> forward_diagonal_set,
            Set<Integer> backward_diagonal_set, int row, int col, int n) {
        boolean isValid = false;
        isValid = !col_set.contains(col) && !forward_diagonal_set.contains(row + col)
                && !backward_diagonal_set.contains(row - col + n - 1);

        return isValid;
    }
}
