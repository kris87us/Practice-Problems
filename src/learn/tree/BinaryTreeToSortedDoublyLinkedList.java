package learn.tree;

import models.TreeNodeJava;

public class BinaryTreeToSortedDoublyLinkedList {
    static TreeNodeJava pred = null;
    static TreeNodeJava binary_tree_to_cdll(TreeNodeJava root){
        if (root == null) return null;
        
        TreeNodeJava sentinel = new TreeNodeJava(-1);
        pred = sentinel;
        
        helper(root);
        
        TreeNodeJava head = sentinel.right;
        // Make it doubly
        head.left = pred;
        pred.right = head;
        
        return head;
    }
    
    static void helper(TreeNodeJava node) {
        // Base case
        if (node == null) {
            return;
        }
        
        // Recursive
        // Pre-order (pred = node)
        // Left Subtree
        helper(node.left);
        // In-order
        pred.right = node;
        node.left = pred;
        pred = node;
        // Right subtree
        helper(node.right);
    }
}
