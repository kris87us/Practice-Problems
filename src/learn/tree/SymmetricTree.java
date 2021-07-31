package learn.tree;

import java.util.LinkedList;
import java.util.Queue;

import models.TreeNodeJava;

public class SymmetricTree {
    public static class Pair {
        TreeNodeJava node1;
        TreeNodeJava node2;
    
        Pair(TreeNodeJava node1, TreeNodeJava node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }

    // BFS
    public boolean isSymmetric_BFS(TreeNodeJava root) {
        if (root == null) return true;
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(root, root));
        while (!q.isEmpty()) {
            Pair pair = q.poll();

            if (pair.node1.left != null && pair.node2.right != null) {
                q.offer(new Pair(pair.node1.left, pair.node2.right));
            } else if (pair.node1.left != null || pair.node2.right != null) {
                return false;
            }
            if (pair.node1.right != null && pair.node2.left != null) {
                q.offer(new Pair(pair.node1.right, pair.node2.left));
            } else if (pair.node1.right != null || pair.node2.left != null) {
                return false;
            }
            if (pair.node1.val != pair.node2.val) {
                return false;
            }
        }
        return true;
    }

    // DFS
    static boolean[] global;
    public boolean isSymmetric(TreeNodeJava root) {
        if (root == null) return true;
        
        return dfs(root, root);
    }
    
    private static boolean dfs(TreeNodeJava node1, TreeNodeJava node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        return (node1.val == node2.val) &&
                dfs(node1.left, node2.right) &&
                dfs(node1.right, node2.left);
    }
}
