package learn.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import models.TreeNodeJava;

/**
 * * In this solution, we will be replicating the working of the recursive call stack using the stack data structure to extract the node labels in the required order. 
*  * The postorder traversal of a binary tree follows the following sequence:
*  * Process the left subtree.
*  * Process the right subtree.
*  * Process the root node.
*  * If we reverse this sequence, we will get:

*  * Process the root node.
*  * Process the right subtree.
*  * Process the left subtree.
*  * The reversed sequence is a modified preorder traversal where the root is processed first and then the right and left subtrees respectively. 

*  * In this solution, we will be extracting the node labels in the order of the modified preorder traversal. Finally, reversing those extracted labels will get us the required postorder traversal of the node labels. 

*  * Our approach will be:

*  * Initiate a process by pushing the root node in a stack. This process will visit all the nodes of the binary tree exactly once in the required order.
*  * As we pop out a node from the stack, we will push its label in the resultant list. While pushing the child nodes into the stack, we will push the left child before the right child. Note that a stack follows the last-in-first-out property. So the node that is pushed later will be popped out first from the stack. Hence, the right child will be popped out before the left child and we will get the node labels in the required order of first getting the root node and then the right and left subtrees respectively.
*  * Finally, we will reverse the resultant list to convert the ordering from the modified preorder traversal to the required postorder traversal.
 */
public class BinaryTreePostOrderTraversal {
    
    static ArrayList<Integer> postorderIterative(TreeNodeJava root) {
        if (root == null) return null;
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNodeJava> stack = new Stack<TreeNodeJava>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNodeJava node = stack.pop();
            result.add(node.val);
            
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
