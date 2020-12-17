package learn

import java.util.*
import kotlin.math.roundToInt
import kotlin.math.min


fun main(args: Array<String>) {
    println(equalizeArray(arrayOf(37, 32, 97, 35, 76, 62)))
    //println("ash".substring(3))
    val cal = Calendar.getInstance()
    cal.set(1, 2017)
    cal.get(6)
}

// Complete the circularArrayRotation function below.
fun circularArrayRotation(a: Array<Int>, k: Int, queries: Array<Int>): Array<Int> {


}

// Complete the equalizeArray function below.
// Count occurence of each element in array..
// Maximum occuring element is the one we want to retain..
//
fun equalizeArray(arr: Array<Int>): Int {
    val map = mutableMapOf<Int, Int>()
    for (a in arr) {
        map[a] = map.getOrDefault(a, 0) + 1
    }
    val maxValue = map.maxOf { it.value }
    return arr.size - maxValue
}

// Complete the appendAndDelete function below.
fun appendAndDelete(s: String, t: String, k: Int): String {
    var commonLength = 0

    for (i in 0 until min(s.length, t.length)) {
        if (s[i] == t[i]) commonLength++ else break
    }
    return when {
        // diff in length is bigger than k
        ((s.length + t.length - 2) * commonLength > k) -> {
            "No"
        }
        // since we need exact k moves.. only possible if they are odd/even
        ((s.length + t.length - 2) * commonLength) % 2 == k % 2 -> {
            "Yes"
        }
        // delete string..
        s.length + t.length - k < 0 -> {
            "Yes"
        }
        else -> {
            "No"
        }
    }
}

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    var count = 0L
    for (c in s) {
        if (c == 'a') count++
    }
    val fullParts = n / s.length
    val remainingParts = n % s.length
    // fullpart count with all parts
    count *= fullParts
    var i = 0
    while (i < remainingParts) {
        if (s[i] == 'a') count++
        i++
    }
    return count.toLong()
}

fun cutTheSticks(arr: Array<Int>): Array<Int> {
    val mutableArr = arr.toMutableList()

    var min = arr.min()
    var sticksCut: Int
    var result = mutableListOf<Int>()
    while (true) {
        sticksCut = 0
        for ((i, item) in mutableArr.withIndex()) {
            if (item != -1) {
                val cut = mutableArr[i] - min!!
                if (cut == 0) mutableArr[i] = -1 else mutableArr[i] = cut
                sticksCut++
            }
        }
        result.add(sticksCut)
        min = mutableArr.filter { it > 0 }.minOrNull()
        if (min == null) break
    }
    return result.toTypedArray()
}

fun designerPdfViewer(h: Array<Int>, word: String): Int {
    var max = 0
    for (char in word) {
        var height = h[(char - 96).toInt() - 1]
        if (height > max) max = height
    }
    return max * word.length
}

fun saveThePrisoner(n: Int, m: Int, s: Int): Int {
    val mod = m % n
    if (m < n) return m + s - 1
    return mod + s - 1
}

fun solve(meal_cost: Double, tip_percent: Int, tax_percent: Int): Unit {
    val tip = (meal_cost * tip_percent / 100).toDouble()
    val tax = (meal_cost * tax_percent / 100).toDouble()
    val total = meal_cost + tip + tax
    println(total.roundToInt())
}

fun jumpingOnClouds(c: Array<Int>, k: Int): Int {
    var i = k
    var energy = 100
    while (true) {
        if (i >= c.size) i -= c.size
        if (c[i] == 1) energy -= 2
        if (i == 0) break // 3
        i += k // 6,9
        energy-- // 98
    }
    return energy - 1
}

// Complete the beautifulDays function below.
fun beautifulDays(i: Int, j: Int, k: Int): Int {
    var count = 0
    for (digit in i..j) {
        if ((digit - reverseLocal(digit)) % k == 0) count++
    }
    return count
}

fun reverseLocal(i: Int): Int {
    var rev = 0
    var n = i
    while (n != 0) {
        rev = rev * 10 + n % 10
        n /= 10
    }
    return rev
}


fun migratoryBirds(arr: Array<Int>): Int {
    var map = mutableMapOf<Int, Int>()
    val arr0 = mutableListOf<Int>()
    for (a in arr) {
        map[a] = map.getOrDefault(a, 0) + 1
    }
    //val max = map.maxOf { it.value }
    var maxEntry: Map.Entry<Int, Int>? = null
    for (entry in map.entries) {
        if (maxEntry == null || entry.value.compareTo(maxEntry.value) > 0) {
            maxEntry = entry
        }
    }
    val max = maxEntry!!.value
    println(max)
    for (it in map) {
        if (it.value == max) arr0.add(it.key)
    }
    arr0.sort()
    return arr0[0]
}

fun birthday(s: Array<Int>, sumI: Int, pieces: Int): Int {
    if (s.size == 1 && s[0] == sumI && pieces == 1) return 1
    var count = 0
    var i = 0

    while (i < s.size) {
        var j = i
        var piece = 0
        val limit = i + pieces
        if (limit > s.size) break
        while (j < limit) {
            piece += s[j]
            j++
        }
        if (piece == sumI) {
            count++
        }
        i++
    }
    return count
}

