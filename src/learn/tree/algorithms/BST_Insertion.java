package learn.tree.algorithms;

import helper.Helper;
import models.TreeNodeJava;

// Time: O(log N)
// Note: This doesn't account for rebalancing the Tree after insertion. So if this is used create a BST from scratch using a sorted array, all the elements
//       will be on the RIGHT of the root making the height = O(N)
public class BST_Insertion {
    public static void main(String[] args) throws Exception {
        insert(Helper.createBST(), 8);

    }

    private static TreeNodeJava insert(TreeNodeJava root, int key) throws Exception {
        TreeNodeJava newNode = new TreeNodeJava(key);
        if (root == null) return newNode; // If root is null, then return the newNode directly

        TreeNodeJava curr = root;
        TreeNodeJava prev = null;
        while (curr != null) {
            if (key == curr.val) {
                throw new Exception("Node already present in the tree");
            } else if (key < curr.val) {
                prev = curr;
                curr = curr.left;
            } else {
                prev = curr;
                curr = curr.right;
            }
        }
        if (key < prev.val) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }
        return root;
    }
}
