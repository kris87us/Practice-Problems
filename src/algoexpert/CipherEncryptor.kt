package algoexpert

fun main() {
    println(CipherEncryptor.caesarCipherEncryptor("abc", 52))
}

class CipherEncryptor {
    companion object {
        @JvmStatic
        fun caesarCipherEncryptor(string: String, key: Int): String {
            // Write your code here.
            var strBuilder = StringBuilder()
            for (ch in string.toLowerCase()) {
                var newLetter = ch + key
                if (newLetter.toInt() <= 122) strBuilder.append(newLetter)
                else {
                    val mod = newLetter.toInt() % 122
                    val str: Char = (96 + mod).toChar()
                    strBuilder.append(str)
                }
            }
            return strBuilder.toString()
        }
    }
}