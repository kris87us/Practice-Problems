package learn

fun climbStairs(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    if (n == 2) return 2

    var i = 3
    var list = mutableListOf(0, 1, 2)
    while (i <= n) {
        list.add(list[i-1] + list[i-2])
        i++
    }
    return list[i-1]
}

fun main() {
    println(climbStairs(3))
}