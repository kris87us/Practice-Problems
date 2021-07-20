package learn.recursion;

import java.util.HashSet;
import java.util.Set;

// Time: O(N!)
// Space: O(N)
public class N_Queens_II {
    
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        Set<Integer> colSet = new HashSet<Integer>();
        Set<Integer> forwardDiagSet = new HashSet<Integer>();
        Set<Integer> backwardDiagSet = new HashSet<Integer>();
        
        return helper(n, 0, colSet, forwardDiagSet, backwardDiagSet);
        
    }
    
    private static int helper(int n, int row, Set<Integer> colSet, Set<Integer> forwardDiagSet, Set<Integer> backwardDiagSet) {
        // Base
        if (row == n) {
            return 1;
        }
        // Recursive
        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, colSet, forwardDiagSet, backwardDiagSet, n)) {
                colSet.add(col);
                forwardDiagSet.add(row + col);
                backwardDiagSet.add(row - col + n - 1);
                count += helper(n, row + 1, colSet, forwardDiagSet, backwardDiagSet);
                colSet.remove(col);
                forwardDiagSet.remove(row + col);
                backwardDiagSet.remove(row - col + n - 1);
            }
        }
        return count;
    }
    
    private static boolean isValid(int row, int col, Set<Integer> colSet, Set<Integer> forwardDiagSet, Set<Integer> backwardDiagSet, int n) {
        return !colSet.contains(col) && !forwardDiagSet.contains(row + col) && !backwardDiagSet.contains(row - col + n - 1);
    }
}
