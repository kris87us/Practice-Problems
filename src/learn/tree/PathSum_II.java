package learn.tree;

import java.util.ArrayList;
import java.util.List;

import helper.Helper;
import models.TreeNodeJava;

// * Time: O(n logn)
//   ? Length of slate for one leaf node could be (log n) in the worst case, when all paths to leaf == target
// * Space: O(n logn)
public class PathSum_II {
    public static void main(String[] args) {
        System.out.println(pathSum_II(Helper.createBinaryTree(), 15));
    }

    private static List<List<Integer>> pathSum_II(TreeNodeJava root, Integer target) {
        if (root == null)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        dfsHelper(root, target, new ArrayList<Integer>(), result);
        return result;
    }

    private static void dfsHelper(TreeNodeJava node, Integer target, List<Integer> slate, List<List<Integer>> result) {
        // Base case
        if (node.left == null && node.right == null) {
            if (target == node.val) {
                slate.add(node.val);
                result.add(new ArrayList<>(slate));
                slate.remove(slate.size() - 1);
            }
            return;
        }
        // Recursive case
        slate.add(node.val);
        if (node.left != null) {
            dfsHelper(node.left, target - node.val, slate, result);
        }
        if (node.right != null) {
            dfsHelper(node.right, target - node.val, slate, result);
        }
        slate.remove(slate.size() - 1);
    }
}
