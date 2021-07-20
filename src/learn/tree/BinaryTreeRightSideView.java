package learn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import helper.Helper;
import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        System.out.println(rightSideView(Helper.createBinaryTree()));
    }

    private static List<Integer> rightSideView(TreeNodeJava root) {
        if (root == null)
            return null;

        Queue<TreeNodeJava> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int numNodes = queue.size();
            Integer temp = 0;
            for (int i = 0; i < numNodes; i++) {
                TreeNodeJava node = queue.poll();
                temp = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
