package learn.other

import kotlin.math.pow

fun main() {
    println(vacuumCleanerRoute("RUULLDRD"))
}

fun addBinary(str1: String, str2: String) {
    var strInt1 = str1.toInt()
    var strInt2 = str2.toInt()
    var dec1 = 0.0
    var dec2 = 0.0
    var i = 0
    var j = 0
    while (strInt1 > 0) {
        dec1 += strInt1 % 10 * 2.0.pow(i)
        strInt1 /= 10
        i++
    }
    while (strInt2 > 0) {
        dec2 += strInt2 % 10 * 2.0.pow(i)
        strInt2 /= 10
        j++
    }
}

fun correctCapitalization(str: String): Boolean {
    var count = 0
    for (s in str) {
        if (s.isUpperCase()) count++
    }
    return count == 0 || count == str.length || (count == 1 && str[0].isUpperCase())
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