package learn.tree;

import helper.Helper;
import models.TreeNodeJava;

public class FindKthSmallestElementInBST {
    public static void main(String[] args) {
        System.out.println(kthSmallest(Helper.createBST(), 2));
    }

    static int[] result;
    static int predCount = 0;
    public static int kthSmallest(TreeNodeJava root, int k) {
        if (root == null)
            return 0;

        result = new int[1];

        helper(root, k);

        return result[0];
    }

    private static int helper(TreeNodeJava node, int k) {
        // Base case
        // No op
        // Recursive
        // Search In-order since its a BST
        if (node.left != null) {
            predCount = helper(node.left, k);
        }
        predCount += 1;
        if (predCount == k) {
            result[0] = node.val;
        }

        if (node.right != null) {
            predCount = helper(node.right, k);
        }

        return predCount;
    }

}
