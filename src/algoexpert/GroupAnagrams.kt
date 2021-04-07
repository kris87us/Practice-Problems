package algoexpert

fun main() {
    println(GroupAnagrams.groupAnagrams(listOf("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")))
}

class GroupAnagrams {
    companion object {
        @JvmStatic
        fun groupAnagrams(words: List<String>): List<List<String>> {
            // Write your code here.
            var resultList = mutableListOf<List<String>>()
            var map = mutableMapOf<String, Boolean>()
            var i = 0
            while (i < words.size) {
                var j = i + 1
                var innerList = mutableListOf<String>()

                while (j < words.size) {
                    if (!innerList.contains(words[i]) && !map[words[i]]!! && !map[words[j]]!!) innerList.add(words[i])
                    if (words[i].toCharArray().sorted().joinToString("") == words[j].toCharArray().sorted().joinToString("")) {
                        map.putIfAbsent(words[i], true)
                        map.putIfAbsent(words[j], true)
                        innerList.add(words[j])
                    }
                    j++
                }
                i++
                resultList.add(innerList)
            }
            return resultList
        }
    }
}