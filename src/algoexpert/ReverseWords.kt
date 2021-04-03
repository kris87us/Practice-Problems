package algoexpert

fun main() {
    println(ReverseWords.reverseWordsInString("Gopal is the best!"))
}

class ReverseWords {

    companion object {
        @JvmStatic
        fun reverseWordsInString(string: String): String {
            // Write your code here.
            var start = 0
            var words = mutableListOf<String>()
            for (ch in string) {
                if (ch == ' ') {
                    words.add(string.substring(start, string.indexOf(ch) - 1))
                    start = string.indexOf(ch)
                }
            }
            return words.joinToString("")
        }
    }
}