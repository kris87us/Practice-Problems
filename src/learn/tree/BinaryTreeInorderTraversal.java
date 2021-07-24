package learn.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import models.TreeNodeJava;

public class BinaryTreeInorderTraversal {
    
    // * INORDER - LEFT, ROOT, RIGHT
    @SuppressWarnings("unused")
    private static List<Integer> inorderIterative(TreeNodeJava root) {
        if (root == null) return null;

        Stack<TreeNodeJava> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        // Process all left subtrees first
        pushToStack(root, stack);

        while (!stack.isEmpty()) {
            TreeNodeJava node = stack.pop();

            result.add(node.val);

            // Process right subtree after  current node has been processed
            pushToStack(node.right, stack);
        }
        return result;
    }

    private static void pushToStack(TreeNodeJava node, Stack<TreeNodeJava> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

}
