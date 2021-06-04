package learn.other

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var input = numBottles
    var div = 0
    var total = numBottles
    if (input/numExchange == 1) return total + 1
    while (input/numExchange > 0) {
        div = input / numExchange
        total = total + div
        input = input % numExchange
    }
    return total + 1
}

fun main() {
    println(numWaterBottles(5, 5))
}