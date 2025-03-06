package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2 {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val output = IntArray(m)

                fun solveRecursive(used: BooleanArray, size: Int) {
                    if (size == m) {
                        writer.writeLine(output.joinToString(" "))
                        return
                    }
                    for (i in 1..n) {
                        if (used[i]) continue
                        used[i] = true
                        output[size] = i
                        solveRecursive(used, size + 1)
                        used[i] = false
                    }
                }

                val used = BooleanArray(n + 1) { false }
                solveRecursive(used, 0)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
