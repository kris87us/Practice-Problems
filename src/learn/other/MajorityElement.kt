package learn.other

fun majorityElement(nums: IntArray): Int {
    /** Sorting Array and middle of the array is the majority
    nums.sort()
    return (nums[nums.size/2])
     **/

    /** HashMap solution **/
    val map = mutableMapOf<Int, Int>()
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0) + 1
    }
    println(map)
    map.entries.forEach {
        if (it.value > nums.size/2) return it.key
    }
    return -1
}

fun main() {
    println(majorityElement(intArrayOf(3,2,3)))
}