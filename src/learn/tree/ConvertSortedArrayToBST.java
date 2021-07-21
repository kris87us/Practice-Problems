package learn.tree;

import models.TreeNodeJava;

// * Time: O(n)
// * Space: -- Explicit - O(n)
// *       \-- Implicit call stack - O(logn)
public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        convertToBST(new int[] { -10, -3, 0, 5, 9 });
    }

    private static TreeNodeJava convertToBST(int[] input) {
        if (input.length == 0) {
            return null;
        }
        return convertHelper(input, 0, input.length - 1);
    }

    private static TreeNodeJava convertHelper(int[] input, int start, int end) {
        // Base case
        if (start > end) { // ZERO remaining
            return null;
        }
        if (start == end) { // ONE remaining
            return new TreeNodeJava(input[start]);
        }
        // Recursive case
        int mid = (start + end) / 2;
        TreeNodeJava root = new TreeNodeJava(input[mid]);
        // Divide and Conquer approach
        root.left = convertHelper(input, start, mid - 1);
        root.right = convertHelper(input, mid + 1, end);

        return root;
    }
}
