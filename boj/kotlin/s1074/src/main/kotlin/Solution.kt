package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, r, c) = reader.readLine().split(" ").map { it.toInt() }

                fun solveRecursive(n: Int, r: Int, c: Int, x: Long, y: Long, half: Long): Long {
                    if (n == 0) return 0L

                    if (c < x + half && r < y + half) {
                        return solveRecursive(n - 1, r, c, x, y, half / 2)
                    }

                    if (c >= x + half && r < y + half) {
                        return (half * half) + solveRecursive(n - 1, r, c, x + half, y, half / 2)
                    }

                    if (c < x + half && r >= y + half) {
                        return 2 * (half * half) + solveRecursive(n - 1, r, c, x, y + half, half / 2)
                    }

                    return 3 * (half * half) + solveRecursive(n - 1, r, c, x + half, y + half, half / 2)
                }

                writer.writeLine(solveRecursive(n, r, c, 0, 0, 1L shl n - 1))
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
