package learn.other

fun rob(nums: IntArray): Int {
    var finalVal = 0

    var total1 = 0
    var total2 = 0

    var i = 0
    var j = 1
    while(i < nums.size) {
        if (i == 0) {
            total1 += nums[i]
            i += 2
        } else {
            val newTotal = total1 + nums[i]
            total1 = if (newTotal > total1) newTotal else total1
            i++
        }
    }
    while (j < nums.size) {
        if (j == 1) {
            total2 += nums[j]
            j += 2
        } else {
            val newTotal = total2 + nums[j]
            total2 = if (newTotal > total1) newTotal else total2
            j++
        }
    }
    finalVal = total1.coerceAtLeast(total2)

    return finalVal
}

fun main() {
    println(rob(intArrayOf(1,2,3,1)))
}