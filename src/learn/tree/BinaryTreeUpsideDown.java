package learn.tree;

import helper.Helper;
import models.TreeNodeJava;

public class BinaryTreeUpsideDown {

    public static void main(String[] args) {
        TreeNodeJava result = flipUpsideDown(Helper.createBinaryTree());
        System.out.println(result);
    }

    static TreeNodeJava[] result;
    static TreeNodeJava flipUpsideDown(TreeNodeJava root){
        if (root == null) return null;
        result = new TreeNodeJava[1];
        helper(root, null, null);
        return result[0];
    }

    static void helper(TreeNodeJava node, TreeNodeJava parent, TreeNodeJava sibling) {
        if (node.left == null && node.right == null) {
            result[0] = node;
        }

        TreeNodeJava oldLeft = node.left;
        TreeNodeJava oldRight = node.right;
        node.right = parent;
        node.left = sibling;

        if (oldLeft != null) {
            helper(oldLeft, node, oldRight);
        }
    }
}
