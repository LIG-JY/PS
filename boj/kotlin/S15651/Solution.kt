package kotlin.S15651

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }

                fun printPermutationWithRepetition(start: Int, end: Int, size: Int) {
                    val stack = ArrayDeque<Int>()
                    fun printPermutationWithRepetitionRecursive() {
                        if (stack.size == size) {
                            writer.writeLine(stack.joinToString(separator = " "))
                            return
                        }

                        for (num in start..end) {
                            stack.addLast(num)
                            printPermutationWithRepetitionRecursive()
                            stack.removeLast()
                        }
                    }
                    printPermutationWithRepetitionRecursive()
                }

                printPermutationWithRepetition(start = 1, end = n, size = m)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
