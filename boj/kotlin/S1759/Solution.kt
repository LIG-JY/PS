package kotlin.S1759

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val vowels = setOf('a', 'e', 'i', 'o', 'u')

                val (l, c) = reader.readLine().split(" ").map { it.toInt() }
                val input = reader.readLine().split(" ").sortedBy { it[0] }

                fun solve() {
                    val sb = StringBuilder()
                    var vowelCount = 0
                    var consonantCount = 0

                    fun printRecursive(start: Int, end: Int) {
                        if (sb.length == l) {
                            if (vowelCount >= 1 && consonantCount >= 2) writer.writeLine(sb.toString())
                            return
                        }

                        for (i in start until end) {
                            val currentChar = input[i][0]
                            sb.append(currentChar)
                            if (vowels.contains(currentChar)) vowelCount++ else consonantCount++
                            printRecursive(i + 1, end)
                            sb.setLength(sb.length - 1)
                            if (vowels.contains(currentChar)) vowelCount-- else consonantCount--
                        }
                    }
                    printRecursive(0, c)
                }

                solve()
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
