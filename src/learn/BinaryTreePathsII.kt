package learn

import models.TreeNode
import java.util.*

fun main() {
    println(BinaryTreePathsII.binaryTreePaths(
        TreeNode(1).apply {
            left = TreeNode(2).apply {
                right = TreeNode(5)
            }
            right = TreeNode(3)
        }
    ))
}

class BinaryTreePathsII {

    companion object {
        @JvmStatic
        fun construct_paths(root: TreeNode?, path: String?, paths: LinkedList<String?>) {
            var path = path
            if (root != null) {
                path += root.`val`.toString()
                if (root.left == null && root.right == null) // if reach a leaf
                    paths.add(path) // update paths
                else {
                    path += "->" // extend the current path
                    construct_paths(root.left, path, paths)
                    construct_paths(root.right, path, paths)
                }
            }
        }

        @JvmStatic
        fun binaryTreePaths(root: TreeNode?): List<String?> {
            val paths = LinkedList<String?>()
            construct_paths(root, "", paths)
            return paths
        }
    }
}