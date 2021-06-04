package learn.other

fun dividesSelf(n: Int): Boolean {
    var n = n
    val digits = mutableListOf<Int>()
    var i = 0
    var divisible = false
    while (n > 0) { // n - 128
        digits.add(n % 10)// mod - 8
        if (i > 0 && digits[i - 1] % digits[i] == 0) {
            divisible = true
        }
        n /= 10 // n - 12
        i++
    }
    return divisible
}

fun main() {
    println(dividesSelf(128));
}