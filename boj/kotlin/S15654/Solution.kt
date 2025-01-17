package kotlin.S15654

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (_, m) = reader.readLine().split(" ").map { it.toInt() }
                val input = reader.readLine().split(" ").map { it.toInt() }.toMutableList()
                input.sort()

                fun solve(range: List<Int>, size: Int) {
                    val visited = BooleanArray(input.last() + 1)
                    val dq = ArrayDeque<Int>()

                    fun solveRecursive() {
                        if (dq.size == size) {
                            writer.writeLine(dq.joinToString(" "))
                        }

                        for (num in range) {
                            if (visited[num]) continue
                            dq.addLast(num)
                            visited[num] = true
                            solveRecursive()
                            dq.removeLast()
                            visited[num] = false
                        }
                    }
                    solveRecursive()
                }

                solve(input, m)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}