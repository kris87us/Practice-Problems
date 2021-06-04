package learn.other

fun minMoves(nums: IntArray): Int {
    if (nums == null) return 0
    var min = nums.minOrNull()
    var newArr = IntArray(nums.size)
    var moves = 0
    for ((i,n) in nums.withIndex()) {
        newArr[i] = n - min!!
        moves += (n - min)
    }
    return moves
}