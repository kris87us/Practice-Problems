package learn

fun lengthOfLastWord(s: String): Int {
    if (s.isEmpty() || s.isBlank()) return 0
    val splitStr = s.trim().split(" ")
    return splitStr.get(splitStr.size - 1).length
}

fun main() {
    println(lengthOfLastWord("a "))
}