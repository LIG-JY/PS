package kotlin.S15652

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }

                fun solve(start: Int, end: Int, size: Int) {
                    val dq = ArrayDeque<Int>()
                    fun solveRecursive(start: Int, end: Int) {
                        if (dq.size == size) {
                            writer.writeLine(dq.joinToString(" "))
                            return
                        }

                        for (num in start..end) {
                            dq.addLast(num)
                            solveRecursive(num, end)
                            dq.removeLast()
                        }
                    }
                    solveRecursive(start = start, end = end)
                }

                solve(1, n, m)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
