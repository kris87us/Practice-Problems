package learn.recursion;

// Time complexity
//    O(N⋅3^L) where L is the length of the word to be searched. 
//    There are at-most 3 directions that we search, because the 4th direction is avoided (it is the direction from we started)
// Space complexity
//    O(N)
public class WordSearch {
    public static void main(String[] args) {
        char[][] input = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(exist(input, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // Optimzed to call helper only if first letter matches the WORD that we are looking for
                if (board[i][j] == word.charAt(0) && helper(board, i, j, 0, new StringBuilder(), word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, int row, int col, int index, StringBuilder partialSolution,
            String word) {
        // Backtracking case
        if (partialSolution.toString().equals(word)) {
            return true;
        }
        // Base case
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        // Recursive case
        int len = partialSolution.length();
        boolean found;

        partialSolution.append(board[row][col]);
        board[row][col] = '#'; // mark visited so that same cell is not considered twice.
        // Recurse through in all four directions
        found = helper(board, row + 1, col, index + 1, partialSolution, word) ||
                helper(board, row, col + 1, index + 1, partialSolution, word) ||
                helper(board, row - 1, col, index + 1, partialSolution, word) ||
                helper(board, row, col - 1, index + 1, partialSolution, word);

        board[row][col] = partialSolution.charAt(partialSolution.length() - 1); // undo visited
        partialSolution.setLength(len);

        return found;
    }
}
