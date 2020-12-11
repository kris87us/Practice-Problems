package learn

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val ransomMap = mutableMapOf<Char, Int>()
    val magazineMap = mutableMapOf<Char, Int>()
    for (s in ransomNote) {
        ransomMap[s] = ransomMap.getOrDefault(s, 0) + 1
    }
    for (s in magazine) {
        magazineMap[s] = magazineMap.getOrDefault(s, 0) + 1
    }

    for (s in ransomNote) {
        if (!magazineMap.contains(s) || magazineMap[s]?.compareTo(ransomMap[s]!!) == -1) {
            return false
        }
    }
    return true
}

fun main() {
    println(canConstruct("ab", "aaa"))
}