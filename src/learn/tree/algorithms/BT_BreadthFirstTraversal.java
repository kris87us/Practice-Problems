package learn.tree.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import helper.Helper;
import models.TreeNodeJava;

// Time: O(N)
// Space: O(N)
public class BT_BreadthFirstTraversal {
    public static void main(String[] args) {
        levelOrder(Helper.createBinaryTree());
    }

    public static void levelOrder(TreeNodeJava root) {
        Queue<TreeNodeJava> queue = new LinkedList<TreeNodeJava>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNodeJava node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }
}
