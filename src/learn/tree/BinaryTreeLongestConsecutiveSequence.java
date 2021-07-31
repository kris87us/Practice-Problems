package learn.tree;

import models.TreeNodeJava;

public class BinaryTreeLongestConsecutiveSequence {
    static int[] globalMax;

    public int longestConsecutive(TreeNodeJava root) {
        if (root == null)
            return 0;

        globalMax = new int[] { 0 };
        helper(root, root.val, 0);
        return globalMax[0];
    }

    private static void helper(TreeNodeJava node, int parent, int longestSumSoFar) {
        // Common case
        if (node.val == parent + 1) {
            longestSumSoFar += 1;
        } else {
            longestSumSoFar = 1;
        }

        if (longestSumSoFar > globalMax[0]) {
            globalMax[0] = longestSumSoFar;
        }

        // Base case
        // No-op

        // Recursion
        if (node.left != null) {
            helper(node.left, node.val, longestSumSoFar);
        }
        if (node.right != null) {
            helper(node.right, node.val, longestSumSoFar);
        }
    }
}
