package learn.tree;

import helper.Helper;
import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class PathSum {
    public static void main(String[] args) {
        System.out.println(pathSum(Helper.createBinaryTree(), 15));
    }

    private static boolean pathSum(TreeNodeJava root, Integer target) {
        if (root == null)
            return false;

        boolean[] result = new boolean[] {false};
        dfsHelper(root, target, result);
        return result[0];
    }

    private static void dfsHelper(TreeNodeJava node, Integer target, boolean[] result) {
        // Base case
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                result[0] = true;
            }
            return;
        }
        // Recursive case
        if (node.left != null) {
            dfsHelper(node.left, target - node.val, result);
        }
        if (node.right != null) {
            dfsHelper(node.right, target - node.val, result);
        }
    }

}
