package learn.tree.algorithms;

import helper.Helper;
import models.TreeNodeJava;

public class BST_Delete {

    public static void main(String[] args) {
        deleteNode(Helper.createBST(), 6);
    }

    private static TreeNodeJava deleteNode(TreeNodeJava root, int nodeToBeDeleted) {
        // Find the node to be deleted
        TreeNodeJava curr = root;
        TreeNodeJava prev = null;
        while (curr != null) {
            if (nodeToBeDeleted == curr.val) {
                break; // Key found
            } else if (nodeToBeDeleted < curr.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }
        // If root is null or node was not found
        if (root == null)
            return curr;

        // Case 1: If the node to be deleted is the leaf node
        if (curr.left == null && curr.right == null) {
            // Tree with only one node
            if (prev == null)
                return null;

            if (prev.left.val == curr.val) {
                prev.left = null;
            } else {
                prev.right = null;
            }
            return root;
        }
        // Case 2: If the node to be deleted has exactly one child
        TreeNodeJava child = null;
        if (curr.left == null && curr.right != null) {
            child = curr.right;
        } else if (curr.left != null && curr.right == null) {
            child = curr.left;
        }
        // Node to be deleted is root
        if (prev == null)
            return child;

        if (child != null) {
            if (prev.left.val == curr.val) {
                prev.left = child;
            } else if (prev.right.val == curr.val) {
                prev.right = child;
            }
            return root;
        }

        // Case 3: If the node to be deleted has both left and right childs
        
        if (curr.left != null && curr.right != null) {
            TreeNodeJava succ = curr.right;
            while (succ.left != null) {
                prev = succ;
                succ = succ.left;
            }
            // Replace node to be deleted with its successor value (to maintain a balanced BST)
            curr.val = succ.val;

            if (prev.left.val == succ.val) {
                prev.left = succ.right;
            } else {
                prev.right = succ.right;
            }
            return root;
        }
        return null;
    }
}
