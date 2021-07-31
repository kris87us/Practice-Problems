package learn.tree;

import models.TreeNodeJava;

public class ValidateBinarySearchTree {

    static boolean[] result;
    static Integer prev;

    static boolean isBST(TreeNodeJava root) {
        result = new boolean[] { true };
        prev = null;
        if (root == null)
            return result[0];

        validate(root);
        return result[0];
    }

    private static void validate(TreeNodeJava node) {
        boolean amIBST = true;
        // Base case : Leaf node
        if (node.left == null && node.right == null) {
            amIBST = true;
            return;
        }
        if (node.left != null) {
            validate(node.left);
        }
        if (prev != null && prev >= node.val) {
            amIBST = false;
        }
        prev = node.val;
        if (node.right != null) {
            validate(node.right);
        }

        if (amIBST == false) {
            result[0] = false;
        }
    }
}
