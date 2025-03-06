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
                val output = Array(n) { CharArray(n) { '*' } }

                fun fillGridBySpace(startY: Int, startX: Int, size: Int) {
                    for (y in startY until startY + size) {
                        for (x in startX until startX + size) {
                            output[y][x] = ' '
                        }
                    }
                }

                fun fillGridRecursive(startY: Int, startX: Int, size: Int) {
                    if (size == 3) {
                        output[startY + 1][startX + 1] = ' '
                        return
                    }

                    val newSize = size / 3
                    for (y in 0 until 3) {
                        for (x in 0 until 3) {
                            if (y == 1 && x == 1) fillGridBySpace(startY + y * newSize, startX + x * newSize, newSize)
                            else fillGridRecursive(startY + y * newSize, startX + x * newSize, newSize)
                        }
                    }
                }

                fillGridRecursive(0, 0, n)

                writer.writeLine(output.joinToString(separator = System.lineSeparator()) { it.joinToString(separator = "") })
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
