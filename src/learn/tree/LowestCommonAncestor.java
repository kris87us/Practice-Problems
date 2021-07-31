package learn.tree;

import models.TreeNodeJava;

public class LowestCommonAncestor {
    static int[] LCA;

    int lca(TreeNodeJava head, TreeNodeJava a, TreeNodeJava b) {
        LCA = new int[] { -1 };
        helper(head, a, b);
        return LCA[0];
    }

    static boolean[] helper(TreeNodeJava node, TreeNodeJava a, TreeNodeJava b) {
        // Each node has to return if it was able to find 'a' and 'b' in its subtree. If
        // it did, then we know node is LCA.
        boolean aFound = false;
        boolean bFound = false;
        // Pre-condition
        // If node itself is 'a'
        if (node.val == a.val) {
            aFound = true;
        }
        // If node itself is 'b'
        if (node.val == b.val) {
            bFound = true;
        }
        // Base case: Leaf node
        if (node.left == null && node.right == null) {
            ; // Do Nothing
        }

        // Recursive case: Internal node
        if (node.left != null) {
            boolean[] pair = helper(node.left, a, b);
            // Local Problem: Update booleans based on internal node worker result.
            // LCA found if either internal node found node or retain global result
            aFound = aFound || pair[0];
            bFound = bFound || pair[1];
        }
        if (node.right != null) {
            boolean[] pair = helper(node.right, a, b);
            // Local Problem: Update booleans based on internal node worker result.
            // LCA found if either internal node found node or retain global result
            aFound = aFound || pair[0];
            bFound = bFound || pair[1];
        }

        // Compute Global Problem: LCA
        if (aFound && bFound && LCA[0] == -1) {
            LCA[0] = node.val;
        }

        return new boolean[] { aFound, bFound };
    }
}
