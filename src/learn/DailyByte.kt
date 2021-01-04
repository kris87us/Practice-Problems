package learn

fun main() {
    println(vacuumCleanerRoute("RUULLDRD"))
}

fun vacuumCleanerRoute(str: String): Boolean {
    var count = 0
    for (s in str) {
        when (s) {
            'L' -> count--
            'R' -> count++
            'U' -> count++
            'D' -> count--
        }
    }
    return count == 0
}

fun isPalindrome(str: String): Boolean {
    val strBuilder = StringBuilder()
    for (s in str) {
        if (s.isLetter()) strBuilder.append(s)
    }
    return strBuilder.toString().equals(reverseString(strBuilder.toString()), true)
}

fun reverseString(str: String): String {
    val strArray = str.toCharArray()
    var i = strArray.size - 1
    val stringBuilder = StringBuilder()
    while (i >= 0) {
        stringBuilder.append(strArray[i])
        i--
    }
    return stringBuilder.toString()
}