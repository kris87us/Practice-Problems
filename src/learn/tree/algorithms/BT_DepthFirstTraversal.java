package learn.tree.algorithms;

import helper.Helper;
import models.TreeNodeJava;

public class BT_DepthFirstTraversal {
    
    public static void main(String[] args) {
        inorder_dfs(Helper.createBinaryTree());
    }

    public static void preorder_dfs(TreeNodeJava root) {
        if (root == null) return;
        // Preorder
        System.out.println(root.val);
        
        preorder_dfs(root.left);
        preorder_dfs(root.right);
    }

    public static void inorder_dfs(TreeNodeJava root) {
        if (root == null) return;
        
        inorder_dfs(root.left);
        // Inorder
        System.out.println(root.val);
        inorder_dfs(root.right);
    }

    public static void postorder_dfs(TreeNodeJava root) {
        if (root == null) return;
        
        postorder_dfs(root.left);
        postorder_dfs(root.right);
        // Postorder
        System.out.println(root.val);
    }
}
