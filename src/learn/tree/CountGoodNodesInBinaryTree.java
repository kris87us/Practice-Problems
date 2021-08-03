package learn.tree;

import models.TreeNodeJava;

public class CountGoodNodesInBinaryTree {
    static int[] global;
    public int goodNodes(TreeNodeJava root) {
        if (root == null) return 0;
        
        global = new int[] { 0 };
        helper(root, Integer.MIN_VALUE);
        return global[0];
    }
    
    private static void helper(TreeNodeJava node, int maxSoFar) {
        // Common Case
        // Current node is bigger than max, so increment count
        if (maxSoFar <= node.val) {
            global[0] += 1;
        }
        // Recursive case
        if (node.left != null) {
            helper(node.left, Math.max(node.val, maxSoFar));
        }
        if (node.right != null) {
            helper(node.right, Math.max(node.val, maxSoFar));
        }
    }
}
