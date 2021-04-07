package algoexpert

fun main() {
    println(FirstNonRepeatingChar.firstNonRepeatingCharacter("abcacd"))
}

class FirstNonRepeatingChar {

    companion object {
        @JvmStatic
        fun firstNonRepeatingCharacter(string: String): Int {
            // Write your code here.
            for (ch in string) {
                if (string.count { it == ch } == 1) {
                    return string.indexOf(ch)
                }
            }
            return -1
        }
    }
}