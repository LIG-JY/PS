package kotlin.S15656

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val input = reader.readLine().split(" ").map { it.toInt() }.sorted()
                val dq = ArrayDeque<Int>()

                fun printRecursive() {
                    if (dq.size == m) {
                        writer.writeLine(dq.joinToString(" "))
                        return
                    }

                    for (i in 0 until n) {
                        dq.addLast(input[i])
                        printRecursive()
                        dq.removeLast()
                    }
                }

                printRecursive()
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
