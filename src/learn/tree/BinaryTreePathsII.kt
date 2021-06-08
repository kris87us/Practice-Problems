package learn.tree

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
        fun constructPaths(root: TreeNode?, path: String?, paths: LinkedList<String?>) {
            var path = path
            if (root != null) {
                path += root.`val`.toString()
                if (root.left == null && root.right == null) // if reach a leaf
                    paths.add(path) // update paths
                else {
                    path += "->" // extend the current path
                    constructPaths(root.left, path, paths)
                    constructPaths(root.right, path, paths)
                }
            }
        }

        @JvmStatic
        fun binaryTreePaths(root: TreeNode?): List<String?> {
            val paths = LinkedList<String?>()
            constructPaths(root, "", paths)
            return paths
        }
    }
}