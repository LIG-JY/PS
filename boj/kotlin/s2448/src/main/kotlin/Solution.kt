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

                fun printStar(size: Int) {
                    val width = size * 2
                    val grid = Array(size) { CharArray(width) { ' ' } }
                    fun fillStarRecursive(startY: Int, startX: Int, size: Int) {
                        if (size == 3) {
                            grid[startY][startX] = '*'
                            grid[startY + 1][startX - 1] = '*'
                            grid[startY + 1][startX + 1] = '*'
                            for (x in startX - 2..startX + 2) grid[startY + 2][x] = '*'
                        } else {
                            val newSize = size / 2
                            fillStarRecursive(startY, startX, newSize)
                            fillStarRecursive(startY + newSize, startX - newSize, newSize)
                            fillStarRecursive(startY + newSize, startX + newSize, newSize)
                        }
                    }
                    fillStarRecursive(0, (width - 1) / 2, size)
                    writer.writeLine(grid.joinToString(separator = System.lineSeparator()) { it.joinToString(separator = "") })
                }
                printStar(n)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
