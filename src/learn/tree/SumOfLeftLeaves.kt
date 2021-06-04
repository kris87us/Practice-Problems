package learn.tree

import models.TreeNode

fun main() {
    val response = SumOfLeftLeaves.sumOfLeftLeaves(
        TreeNode(3)
            .apply {
                left = TreeNode(9)
                right = TreeNode(20)
                    .apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
            }
    )
    print(response)
}

class SumOfLeftLeaves {

    companion object {
        @JvmStatic
        fun sumOfLeftLeaves(root: TreeNode?): Int {
            return calculateSumOfLeftLeaves(root, 0, false)
        }

        @JvmStatic
        fun calculateSumOfLeftLeaves(
            root: TreeNode?, sum: Int, isLeft: Boolean): Int {
            if (root == null) return 0

            val runningSum = root.`val` + sum
            if (root.left == null && root.right == null) {
                return if (isLeft) root.`val` else 0
            }
            var total = 0
            if (root.left != null) {
                total += calculateSumOfLeftLeaves(root.left, runningSum, true)
            }
            if (root.right != null) {
                total += calculateSumOfLeftLeaves(root.right, runningSum, false)
            }
            return total
        }
    }
}