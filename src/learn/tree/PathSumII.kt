package learn.tree

import models.TreeNode
import java.util.ArrayList

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
internal class PathSumII {
    private fun recurseTree(
        node: TreeNode?,
        remainingSum: Int,
        pathNodes: MutableList<Int>,
        pathsList: MutableList<List<Int>>
    ) {
        if (node == null) {
            return
        }

        // Add the current node to the path's list
        pathNodes.add(node.`val`)

        // Check if the current node is a leaf and also, if it
        // equals our remaining sum. If it does, we add the path to
        // our list of paths
        if (remainingSum == node.`val` && node.left == null && node.right == null) {
            pathsList.add(ArrayList(pathNodes))
        } else {

            // Else, we will recurse on the left and the right children
            recurseTree(node.left, remainingSum - node.`val`, pathNodes, pathsList)
            recurseTree(node.right, remainingSum - node.`val`, pathNodes, pathsList)
        }

        // We need to pop the node once we are done processing ALL of it's
        // subtrees.
        pathNodes.removeAt(pathNodes.size - 1)
    }

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val pathsList: MutableList<List<Int>> = ArrayList()
        val pathNodes: MutableList<Int> = ArrayList()
        recurseTree(root, sum, pathNodes, pathsList)
        return pathsList
    }
}