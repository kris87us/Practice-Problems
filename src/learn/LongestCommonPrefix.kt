package learn

fun longestCommonPrefix(strs: Array<String>): String {
    var string = ""
    strs.sort()
    if (strs.isEmpty() || strs.isNullOrEmpty()) return ""
    val first = strs[0].toCharArray()
    val last = strs[strs.size - 1].toCharArray()
    var i = 0
    while (i < first.size) {
        if (last.size > i && last[i] == first[i]) {
            string += last[i]
        } else {
            return string
        }
        i++
    }
    return string
}

fun main() {
    println(longestCommonPrefix(arrayOf("flower","flow","flight")))
}