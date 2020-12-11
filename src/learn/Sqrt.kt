package learn

import kotlin.math.pow
import kotlin.math.roundToInt

// sqrt(x) = y
// x = 4, y = 2
// So, y^2 = x
// f(x) = y^2 - x = 0
// newton's method: iterate newX = y - f(x)/f'(x) where f'(x)=2y
// newX = y - y^2-x/2y
fun mySqrt(x: Int): Int {
    var prev = -1
    var new = 1
    while (Math.abs(new.toDouble() - prev.toDouble()) > 1e-10) {
        prev = new
        new = (prev.toDouble() - ((prev.toDouble().pow(2.0) - x))/(2.0 * prev.toDouble())).toInt()
    }
    return new
}

fun main() {
    println(mySqrt(8))
}