package learn.tree;

import java.util.ArrayList;
import java.util.Stack;

import models.TreeNodeJava;

public class BinaryTreePreorderTraversal {
    
    static ArrayList<Integer> preorderIterative(TreeNodeJava root) {
        if (root == null) return null;
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNodeJava> stack = new Stack<TreeNodeJava>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNodeJava node = stack.pop();
            result.add(node.val);
            
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
