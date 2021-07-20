package learn.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import models.N_aryTreeNode;

// * Time: O(n)
// * Space: O(n)
public class N_AryTreeLevelOrderTraversal {
    @SuppressWarnings("unused")
    private static List<List<Integer>> n_aryTreeLevelOrderTraversal(N_aryTreeNode root) {
        if (root == null) return null;

        Queue<N_aryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int numNodes = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numNodes; i++) {
                N_aryTreeNode node = queue.poll();
                temp.add(node.val);
                for (N_aryTreeNode child : node.children) {
                    queue.offer(child);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
