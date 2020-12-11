package learn

fun singleNumber(nums: IntArray): Int {
    var i = 0
    for (n in nums) {
        i = i xor n
    }
    return i
}