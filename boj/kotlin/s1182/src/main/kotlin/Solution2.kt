package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2 {
    companion object {
        fun main() {
            BufferedReader(InputStreamReader(System.`in`)).use { reader ->
                BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                    val (n, m) = reader.readLine().trim().split(' ').map { it.toInt() }
                    val sequence = reader.readLine().trim().split(' ').map { it.toInt() }
                    var count = 0;

                    fun combinationRecursive(sequencePtr: Int, scratchCount: Int, size: Int, sum: Int) {
                        if (scratchCount >= size) {
                            if (sum == m) ++count
                            return
                        }
                        for (i in sequencePtr until sequence.size) {
                            combinationRecursive(i + 1, scratchCount + 1, size, sum + sequence[i])
                        }
                    }

                    for (size in 1..n) {
                        combinationRecursive(0, 0, size, 0)
                    }
                    writer.writeLine(count)
                }
            }
        }

        private fun BufferedWriter.writeLine(v: Any) {
            this.write("$v")
            this.newLine()
        }
    }
}