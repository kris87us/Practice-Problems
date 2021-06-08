package learn.tree

import models.TreeNode

class BinarySumRootToLeaf {
    companion object {
        @JvmStatic
        fun sumRootToLeaf(root: TreeNode?): Int {
            return calculateBinarySum(root, 0)
        }

        @JvmStatic
        fun calculateBinarySum(root: TreeNode?, current: Int): Int {
            if (root == null) return 0

            var current = (current.shl(1)).or(root.`val`)

            if (root.left == null && root.right == null) {
                sum += current
            }

            calculateBinarySum(root.left, sum)
            calculateBinarySum(root.left, sum)

            return sum
        }

        var sum = 0
    }
}