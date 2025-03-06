package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                val grid = Array(n) { reader.readLine().split(" ").map { it.toInt() } }

                val counts = IntArray(2)

                fun solveRecursive(startY: Int, startX: Int, size: Int) {
                    val color = grid[startY][startX]
                    var isAllSame = true
                    for (y in startY until startY + size) {
                        for (x in startX until startX + size) {
                            if (grid[y][x] != color) isAllSame = false
                        }
                    }
                    if (isAllSame) {
                        counts[color]++
                    } else {
                        solveRecursive(startY, startX, size / 2)
                        solveRecursive(startY, startX + (size / 2), size / 2)
                        solveRecursive(startY + (size / 2), startX, size / 2)
                        solveRecursive(startY + (size / 2), startX + (size / 2), size / 2)
                    }
                }

                solveRecursive(0, 0, n)
                counts.forEach { writer.writeLine(it) }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
