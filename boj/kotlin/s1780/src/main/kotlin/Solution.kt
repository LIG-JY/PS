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
                val grid = List(n) { reader.readLine().split(" ").map { it.toInt() } }

                val counts = IntArray(3) { 0 }
                fun toIndex(value: Int): Int = when (value) {
                    -1 -> 0
                    0 -> 1
                    1 -> 2
                    else -> error("Invalid grid value $value")
                }

                fun solveRecursive(startY: Int, startX: Int, size: Int) {
                    if (size == 1) {
                        val index = toIndex(grid[startY][startX])
                        counts[index] = counts[index] + 1
                        return
                    }

                    val truncatedGrid = List(size) { MutableList(size) { Int.MIN_VALUE } }
                    for (y in 0 until size) {
                        for (x in 0 until size) {
                            truncatedGrid[y][x] = grid[y + startY][x + startX]
                        }
                    }
                    val allSame = truncatedGrid.flatten().all { it == truncatedGrid[0][0] }
                    if (allSame) {
                        val index = toIndex(truncatedGrid[0][0])
                        counts[index] = counts[index] + 1
                    } else {
                        val newSize = truncatedGrid.size / 3
                        for (j in 0 until 3) {
                            for (i in 0 until 3) {
                                solveRecursive(startY + newSize * j, startX + newSize * i, newSize)
                            }
                        }
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
