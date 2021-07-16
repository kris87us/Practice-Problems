package learn.tree.algorithms;

import helper.Helper;
import models.TreeNodeJava;

// Time: O(log N)
// Space: O(1)
public class BST_FindMinimumAndMaximum {
    public static void main(String[] args) {
        System.out.println("Min: "+ findMinimum(Helper.createBST()));
        System.out.println("Max: "+ findMaximum(Helper.createBST()));
    }

    private static Integer findMaximum(TreeNodeJava root) {
        if (root == null) return null;
        TreeNodeJava curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

    private static Integer findMinimum(TreeNodeJava root) {
        if (root == null) return null;
        TreeNodeJava curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }
}
