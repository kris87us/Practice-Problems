package learn.recursion;

import java.util.ArrayList;
import java.util.List;

// Time complexity:
//   O(9^k) where k is the number if unfilled spaces in the input arraylist
//   Every unfilled space can have any value between 1-9. So there are 9 choices for every unfilled box.

// Space complexity:
//   Input - O(N * N) - 2D input ArrayList
//   Aux - O(k) - Call stack space is atmost k where k is number of spaces to be filled
//   Output - O(1) - No extra space used
public class SudokuSolver {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> board = createSudokoBoard();
        solve_sudoku_puzzle(board);
    }

    private static ArrayList<ArrayList<Integer>> solve_sudoku_puzzle(ArrayList<ArrayList<Integer>> board) {
        helper(board);
        return board;
    }

    private static boolean helper(ArrayList<ArrayList<Integer>> board) {
        // Recursive case
        for (int row = 0; row < board.size(); row++) {
            for (int col = 0; col < board.get(0).size(); col++) {
                if (board.get(row).get(col) == 0) {
                    for (int num = 1; num <= 9; num++) {
                        // Recurse
                        if (isValid(board, row, col, num)) {
                            // Add
                            board.get(row).set(col, num);
                            if (helper(board)) {
                                return true;
                            } else {
                                // Pop
                                board.get(row).set(col, 0);
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(ArrayList<ArrayList<Integer>> board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            // Check rows
            if (board.get(i).get(col) == num)
                return false;

            // Check columns
            if (board.get(row).get(i) == num)
                return false;

            // Check 3x3 squares
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if (board.get(r).get(c) == num)
                return false;
        }

        return true;
    }

    private static ArrayList<ArrayList<Integer>> createSudokoBoard() {
        ArrayList<Integer> rows = new ArrayList<Integer>();
        rows.addAll(List.of(8, 4, 9, 0, 0, 3, 5, 7, 0));
        rows.addAll(List.of(0, 1, 0, 0, 0, 0, 0, 0, 0));
        rows.addAll(List.of(7, 0, 0, 0, 9, 0, 0, 8, 3));
        rows.addAll(List.of(0, 0, 0, 9, 4, 6, 7, 0, 0));
        rows.addAll(List.of(0, 8, 0, 0, 5, 0, 0, 4, 0));
        rows.addAll(List.of(0, 0, 6, 8, 7, 2, 0, 0, 0));
        rows.addAll(List.of(5, 7, 0, 0, 1, 0, 0, 0, 4));
        rows.addAll(List.of(0, 0, 0, 0, 0, 0, 0, 1, 0));
        rows.addAll(List.of(0, 2, 1, 7, 0, 0, 8, 6, 5));
        ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
        board.add(rows);
        return board;
    }
}