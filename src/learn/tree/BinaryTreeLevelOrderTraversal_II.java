package learn.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.Helper;
import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class BinaryTreeLevelOrderTraversal_II {
    public static void main(String[] args) {
        System.out.println(levelOrderTraversal(Helper.createBinaryTree()));
    }

    private static List<List<Integer>> levelOrderTraversal(TreeNodeJava root) {
        if (root == null)
            return null;

        Queue<TreeNodeJava> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int numNodes = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numNodes; i++) {
                TreeNodeJava node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;
    }
}
