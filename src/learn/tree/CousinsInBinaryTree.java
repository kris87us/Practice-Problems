package learn.tree;

import java.util.LinkedList;
import java.util.Queue;

import models.TreeNodeJava;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNodeJava root, int x, int y) {
        if (root == null)
            return false;

        Queue<TreeNodeJava> q = new LinkedList<TreeNodeJava>();
        q.offer(root);

        while (!q.isEmpty()) {
            Integer px = null;
            Integer py = null;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNodeJava node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                    if (node.left.val == x) {
                        px = node.val;
                    }
                    if (node.left.val == y) {
                        py = node.val;
                    }
                }
                if (node.right != null) {
                    q.offer(node.right);
                    if (node.right.val == x) {
                        px = node.val;
                    }
                    if (node.right.val == y) {
                        py = node.val;
                    }
                }
            }
            if (px != null && py != null) {
                return px != null && py != null && px != py;
            }
        }
        return false;
    }
}
