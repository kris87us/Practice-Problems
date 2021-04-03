package algoexpert

fun main() {
    println(FindTournamentWinner.tournamentWinner(listOf(listOf("HTML", "C"), listOf("C", "Python"), listOf("Python", "C")), listOf(0,0,1)))
}

class FindTournamentWinner {

    companion object {
        @JvmStatic
        fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
            // Write your code here.
            val resultsMap = mutableMapOf<String, Int>()
            var index = 0
            while (index < competitions.size && index < results.size) {
                val winner: String = if (results[index] == 0) competitions[index][1]
                else competitions[index][0]

                resultsMap[winner] = resultsMap.getOrDefault(winner, 0) + 1
                index++
            }
            return resultsMap.maxByOrNull { it.value }!!.key
        }
    }
}