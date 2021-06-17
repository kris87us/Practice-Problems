package algoexpert

import java.util.*

fun main() {
    println(CipherEncryptor.caesarCipherEncryptor("abc", 52))
}

class CipherEncryptor {
    companion object {
        @JvmStatic
        fun caesarCipherEncryptor(string: String, key: Int): String {
            // Write your code here.
            val strBuilder = StringBuilder()
            for (ch in string.lowercase(Locale.getDefault())) {
                val newLetter = ch + key
                if (newLetter.code <= 122) strBuilder.append(newLetter)
                else {
                    val mod = newLetter.code % 122
                    val str: Char = (96 + mod).toChar()
                    strBuilder.append(str)
                }
            }
            return strBuilder.toString()
        }
    }
}