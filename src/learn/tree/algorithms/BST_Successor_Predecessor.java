package learn.tree.algorithms;

import helper.Helper;
import models.TreeNodeJava;

// Time: O(log n)
public class BST_Successor_Predecessor {
    public static void main(String[] args) {
        System.out.println("Successor: " + successor(Helper.createBST(), Helper.createBST()));
        System.out.println("Predecessor: " + predecessor(Helper.createBST(), Helper.createBST()));
    }

    private static Integer successor(TreeNodeJava root, TreeNodeJava key) {
        if (root == null)
            return null;

        // Check if KEY has a right child. If YES, then left-most node in the right
        // subtree is the successor
        if (key.right != null) {
            TreeNodeJava curr = key.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr.val;
        }
        // If KEY does not have a right subtree, then we need to look up to the
        // ancestors to find the first right turn
        TreeNodeJava prev = null;
        TreeNodeJava curr = root;
        while (curr.val != key.val) {
            if (key.val < curr.val) {
                prev = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        return prev.val;
    }

    private static Integer predecessor(TreeNodeJava root, TreeNodeJava key) {
        if (root == null)
            return null;

        // Check if KEY has a right child. If YES, then left-most node in the right
        // subtree is the successor
        if (key.left != null) {
            TreeNodeJava curr = key.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            return curr.val;
        }
        // If KEY does not have a right subtree, then we need to look up to the
        // ancestors to find the first right turn
        TreeNodeJava prev = null;
        TreeNodeJava curr = root;
        while (curr.val != key.val) {
            if (key.val > curr.val) {
                prev = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        return prev.val;
    }
}
