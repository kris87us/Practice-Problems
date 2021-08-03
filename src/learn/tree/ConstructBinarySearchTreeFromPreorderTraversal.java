package learn.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.TreeNodeJava;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    static TreeNodeJava build_binary_search_tree(ArrayList<Integer> preorder) {
        if (preorder.size() == 0) return null;
        
        List<Integer> inorder = List.copyOf(preorder);
        Collections.sort(inorder);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }

        return helper(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, map);
    }

    private static TreeNodeJava helper(ArrayList<Integer> preorder, int startP, int endP, List<Integer> inorder, int startI, int endI, Map<Integer, Integer> map) {
        if (startP > endP) {
            return null;
        }
        if (startP == endP) {
            return new TreeNodeJava(preorder.get(startP));
        }

        // Recursive case
        TreeNodeJava root = new TreeNodeJava(preorder.get(startP));
        int rootIndex = map.get(root.val);
        int numsLeft = rootIndex - startI;

        root.left = helper(preorder, startP + 1, startP + numsLeft, inorder, startI, rootIndex - 1, map);
        root.right = helper(preorder, startP + numsLeft + 1, endP, inorder, rootIndex + 1, endI, map);

        return root;
    }

    
}
