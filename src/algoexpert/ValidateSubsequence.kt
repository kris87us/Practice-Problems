package algoexpert

fun main() {
    println(ValidateSubsequence.isValidSubsequence(arrayListOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(1, 6, -1, 10)))
}

class ValidateSubsequence {

    companion object {
        @JvmStatic
        fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
            // Write your code here.
            var previousIndex = array.indexOf(sequence[0])
            for ((i, item) in sequence.withIndex()) {
                if (i == 0) continue
                if ((array.indexOf(sequence[i]) < previousIndex)) {
                    return false
                }
                previousIndex = array.indexOf(item)
            }
            return true
        }
    }
}