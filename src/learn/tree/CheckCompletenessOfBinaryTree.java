package learn.tree;

import java.util.LinkedList;
import java.util.Queue;

import models.TreeNodeJava;

public class CheckCompletenessOfBinaryTree {
    class Pair {
        TreeNodeJava key;
        int val;
        
        Pair(TreeNodeJava key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    public boolean isCompleteTree(TreeNodeJava root) {
        if (root == null) return false;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        
        int expectedIndex = 1;
        while (!q.isEmpty()) {
            Pair nodePair = q.poll();
            if (expectedIndex == nodePair.val) {
                expectedIndex += 1;
            } else {
                return false;
            }
            if (nodePair.key.left != null) {
                q.offer(new Pair(nodePair.key.left, 2*nodePair.val));
            }
            if (nodePair.key.right != null) {
                q.offer(new Pair(nodePair.key.right, 2*nodePair.val + 1));
            }
        }
        return true;
    }
}
