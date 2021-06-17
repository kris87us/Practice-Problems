package learn.other

fun reverseVowels(s: String): String {
    val charArr = s.toCharArray()
    val vowelSet = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var i=0
    var j=charArr.size - 1
    while (i<j) {
        if (!vowelSet.contains(charArr[i])) {
            i++
            continue
        }
        if (!vowelSet.contains(charArr[j])) {
            j--
            continue
        }
        val temp = charArr[i]
        charArr[i] = charArr[j]
        charArr[j] = temp
        i++
        j--
    }
    return charArr.joinToString("")
}

fun main() {
    println(reverseVowels("hello"))
}