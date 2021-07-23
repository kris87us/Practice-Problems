package learn.tree;

import java.util.LinkedList;
import java.util.Queue;

import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class AddOneRowToTree {
    
    public TreeNodeJava addOneRow(TreeNodeJava root, int val, int depth) {
        if (root == null) return null;
        Queue<TreeNodeJava> queue = new LinkedList<TreeNodeJava>();
        
        int level = 0;
        // * If depth is 1, then element needs to be added as the new root
        if (level == depth - 1) {
            TreeNodeJava prevRoot = root;
            TreeNodeJava newRoot = new TreeNodeJava(val);
            root = newRoot;
            root.left = prevRoot;
            
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            level += 1;
            
            for (int i = 0; i < length; i++) {
                TreeNodeJava node = queue.poll();
                
                if (node.left != null) {
                    // * Check if current level is less than depth by 1
                    // * If yes, add the new node and adjust its left to the old left
                    if (level == depth - 1) {
                        TreeNodeJava oldLeft = node.left;
                        TreeNodeJava newLeft = new TreeNodeJava(val);
                        node.left = newLeft;
                        newLeft.left = oldLeft;
                    }
                    queue.offer(node.left);
                } else {
                    // * If requested depth is greater than current leaf, then new node needs to be added as a leaf
                    if (level == depth - 1) {
                        TreeNodeJava newLeft = new TreeNodeJava(val);
                        node.left = newLeft;
                    }
                }
                if (node.right != null) {
                    // * Check if current level is less than depth by 1
                    // * If yes, add the new node and adjust its right to the old right
                    if (level == depth - 1) {
                        TreeNodeJava oldRight = node.right;
                        TreeNodeJava newRight = new TreeNodeJava(val);
                        node.right = newRight;
                        newRight.right = oldRight;
                    }
                    queue.offer(node.right);
                } else {
                    // * If requested depth is greater than current leaf, then new node needs to be added as a leaf
                    if (level == depth - 1) {
                        TreeNodeJava newRight = new TreeNodeJava(val);
                        node.right = newRight;
                    }
                }
            }
        }
        return root;
    }
}
