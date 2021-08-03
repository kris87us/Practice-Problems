package learn.tree;

import models.TreeNodeJava;

public class LongestUnivalPath {
    static int[] globalMax;

    public int longestUnivaluePath(TreeNodeJava root) {
        if (root == null)
            return 0;
        globalMax = new int[1];
        helper(root);
        return globalMax[0];
    }

    private static int helper(TreeNodeJava node) {
        int longestPath = 0;
        int longestVPath = 0;

        // Base case
        // No op

        // Recursive case
        if (node.left != null) {
            int left = helper(node.left);
            if (node.left.val == node.val) {
                longestPath = 1 + left;
                longestVPath = longestPath;
            }
        }
        if (node.right != null) {
            int right = helper(node.right);
            if (node.right.val == node.val) {
                longestPath = Math.max(longestPath, 1 + right);
                longestVPath += 1 + right;
            }
        }
        if (longestVPath > globalMax[0]) {
            globalMax[0] = longestVPath;
        }

        return longestPath;
    }
}
