package learn.tree;

import helper.Helper;
import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(Helper.createBinaryTree()));
    }

    private static int diameterOfBinaryTree(TreeNodeJava root) {
        if (root == null) return 0;

        int[] globalDiameter = new int[] {0};
        helper(root, globalDiameter);
        return globalDiameter[0];
    }

    private static int helper(TreeNodeJava node, int[] globalDiameter) {
        /*   Here there are two things 
        !    1) I need the longest path to me from my child 
        !    so I will return the same to my parent. - returning node height
        !    2) At every node I have to calculate longest path "through" 
        !    me which is the sum of left height and right height. - calculation of 
        !    localDiameter
        **/
        // Base case
        if (node.left == null && node.right == null) {
            return 0; // Leaf node
        }
        // Recursive case
        int leftHeight = 0, rightHeight = 0;
        int localDiameter = 0;
        if (node.left != null) {
            leftHeight = helper(node.left, globalDiameter);
            localDiameter += leftHeight + 1;
        }
        if (node.right != null) {
            rightHeight = helper(node.right, globalDiameter);
            localDiameter += rightHeight + 1;
        }
        globalDiameter[0] = Math.max(globalDiameter[0], localDiameter);
        return Math.max(leftHeight, rightHeight) + 1; // node height
    }
}
