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
                val grid = List(n) { reader.readLine().toList() }
                val sb = StringBuilder(1024 * 64)

                fun solveRecursive(startY: Int, startX: Int, size: Int) {
                    val firstChar = grid[startY][startX]
                    var allSame = true

                    outer@ for (y in startY until startY + size) {
                        for (x in startX until startX + size) {
                            if (grid[y][x] != firstChar) {
                                allSame = false
                                break@outer
                            }
                        }
                    }

                    if (allSame) {
                        sb.append(firstChar)
                    } else {
                        val newSize = size / 2
                        sb.append('(')
                        for (y in 0 until 2) {
                            for (x in 0 until 2) {
                                solveRecursive(
                                    startY = startY + y * newSize,
                                    startX = startX + x * newSize,
                                    size = newSize
                                )
                            }
                        }
                        sb.append(')')
                    }
                }

                solveRecursive(0, 0, n)
                writer.writeLine(sb.toString())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
