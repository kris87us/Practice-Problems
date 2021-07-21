package learn.tree;

import java.util.HashMap;
import java.util.Map;

import models.TreeNodeJava;

// * Time: O(n)
// * Space: O(n)
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        constructBTFromInorderAndPostorder(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
    }

    private static TreeNodeJava constructBTFromInorderAndPostorder(int[] inorder, int[] postorder) {
        // Create map with in-order array elements and index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return constructHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private static TreeNodeJava constructHelper(int[] inorder, int startI, int endI, int[] postorder, int startP, int endP, Map<Integer, Integer> map) {
        // Base case
        if (startP > endP) { // Both in-order and post-order should be at same index, so checking only either
                             // is sufficient
            return null;
        }
        if (startP == endP) {
            return new TreeNodeJava(postorder[startP]);
        }
        // Recursive case
        // * endP is the ending index in the Postorder array, so it is the root of
        // * the tree according to the Post-order traversal algorithm
        TreeNodeJava root = new TreeNodeJava(postorder[endP]);
        int rootIndex = map.get(root.val);
        // Calculate number of elements to the left and right
        int numsLeft = rootIndex - startI;
        int numsRight = endI - rootIndex;

        root.left = constructHelper(inorder, startI, rootIndex - 1, postorder, startP, startP + numsLeft - 1, map);
        root.right = constructHelper(inorder, rootIndex + 1, endI, postorder, startP + numsLeft, endP - 1, map);

        return root;
    }
}
