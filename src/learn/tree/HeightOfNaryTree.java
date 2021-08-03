package learn.tree;

import java.util.LinkedList;
import java.util.Queue;

import models.N_aryTreeNode;

public class HeightOfNaryTree {
    public static int heightOfNaryTree(N_aryTreeNode root) {
        if (root == null) return 0;

        Queue<N_aryTreeNode> q = new LinkedList<>();
        q.offer(root);

        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            level += 1;
            for (int i = 0; i < len; i++) {
                N_aryTreeNode node = q.poll();

                for (N_aryTreeNode child : node.children) {
                    q.offer(child);
                }
            }
        }
        return level - 1;
    }
}
