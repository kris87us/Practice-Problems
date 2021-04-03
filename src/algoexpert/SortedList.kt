package algoexpert

fun main() {
    println(SortedList.sortedSquaredArray(listOf(1,2,3,4,5)))
}

class SortedList {
    companion object {
        @JvmStatic
        fun sortedSquaredArray(array: List<Int>): List<Int> {
            // Write your code here.
            return array.map { it * it }.sorted()
        }
    }
}