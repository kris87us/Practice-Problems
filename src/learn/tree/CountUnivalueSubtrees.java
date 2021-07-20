package learn.tree;

import helper.Helper;
import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class CountUnivalueSubtrees {
    public static void main(String[] args) {
        System.out.println(countUniValueSubtrees(Helper.createBinaryTree()));
    }

    private static int countUniValueSubtrees(TreeNodeJava root) {
        if (root == null)
            return 0;

        int[] result = new int[] { 0 };
        helper(root, result);
        return result[0];
    }

    private static boolean helper(TreeNodeJava node, int[] result) {
        /**
         * ! 1) Compute whether I am Unival and return that to parent.
         * ! 2) Based on whether I am Unival or not, add 1 to the result.
         */
        // Base case
        if (node.left == null && node.right == null) {
            result[0] += 1;
            return true;
        }

        // Recursive case
        boolean amIUnival = true;
        if (node.left != null) {
            boolean left = helper(node.left, result);
            if (!left || node.val != node.left.val) {
                amIUnival = false;
            }
        }
        if (node.right != null) {
            boolean right = helper(node.right, result);
            if (!right || node.val != node.right.val) {
                amIUnival = false;
            }
        }
        if (amIUnival) 
            result[0] += 1;
        return amIUnival;
    }
}
