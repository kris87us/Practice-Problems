package learn

fun isHappy(n: Int): Boolean {
    val inLoop = HashSet<Int>()
    var squareSum : Int
    var remain : Int
    var input = n
    while (inLoop.add(input)) {
        squareSum = 0
        while (input > 0) {
            remain =  input%10
            squareSum += remain*remain
            input /= 10
        }
        if (squareSum == 1)
            return true
        else
            input = squareSum

    }
    return false
}