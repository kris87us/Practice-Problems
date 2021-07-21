package learn.tree;

import java.util.HashMap;
import java.util.Map;

import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        constructBTFromPreorderAndInorder(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    private static TreeNodeJava constructBTFromPreorderAndInorder(int[] preorder, int[] inorder) {
        // Create map with in-order array elements and index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return constructHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private static TreeNodeJava constructHelper(int[] preorder, int startP, int endP, int[] inorder, int startI, int endI, Map<Integer, Integer> map) {
        // Base case
        if (startP > endP) { // Both in-order and pre-order should be at same index, so checking only either is sufficient
            return null;
        }
        if (startP == endP) {
            return new TreeNodeJava(preorder[startP]);
        }
        // Recursive case
        // * startP is the starting index in the Preorder array, so it is the root of the tree according to the Pre-order traversal algorithm
        TreeNodeJava root = new TreeNodeJava(preorder[startP]);
        int rootIndex = map.get(root.val);
        // Calculate number of elements to the left and right
        int numsLeft = rootIndex - startI;
        // int numsRight = endI - rootIndex;

        root.left = constructHelper(preorder, startP + 1, startP + numsLeft, inorder, startI, rootIndex - 1, map);
        root.right = constructHelper(preorder, startP + numsLeft + 1, endP, inorder, rootIndex + 1, endI, map);

        return root;
    }
}
