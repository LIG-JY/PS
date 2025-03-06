package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val UNUSED = 0
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m, k) = reader.readLine().split(" ").map { it.toInt() }

                val grid = Array(n) { IntArray(m) { UNUSED } }

                repeat(k) {
                    val (stickerColSize, stickerRowSize) = reader.readLine().split(" ").map { it.toInt() }
                    val sticker = Array(stickerColSize) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

                    fun attach(copiedSticker: Array<IntArray>, y: Int, x: Int) {
                        for (i in copiedSticker.indices) {
                            for (j in copiedSticker[0].indices) {
                                if (copiedSticker[i][j] == 1) grid[y + i][x + j] = copiedSticker[i][j]  // 1
                            }
                        }
                    }

                    fun canAttach(copiedSticker: Array<IntArray>, y: Int, x: Int): Boolean {
                        for (i in copiedSticker.indices) {
                            for (j in copiedSticker[0].indices) {
                                if (copiedSticker[i][j] == 1) {
                                    if (grid[y + i][x + j] == 1) return false
                                }
                            }
                        }

                        return true
                    }

                    fun tryAttach(copiedSticker: Array<IntArray>): Boolean {
                        for (y in 0 until n) {
                            for (x in 0 until m) {
                                if (y + copiedSticker.size - 1 >= n || x + copiedSticker[0].size - 1 >= m) continue
                                val canAttach = canAttach(copiedSticker, y, x)
                                if (canAttach) {
                                    attach(copiedSticker, y, x)
                                    return true
                                }
                            }
                        }

                        return false
                    }

                    fun rotateClockwise(target: Array<IntArray>): Array<IntArray> {
                        val colSize = target.size
                        val rowSize = target[0].size
                        val pResult = Array(rowSize) { IntArray(colSize) }

                        for (y in target.indices) {
                            for (x in target[y].indices) {
                                pResult[x][colSize - 1 - y] = target[y][x]
                            }
                        }

                        return pResult
                    }

                    var pSticker = Array(stickerColSize) { IntArray(stickerRowSize) }
                    // deep copy
                    for (y in 0 until stickerColSize) {
                        for (x in 0 until stickerRowSize) {
                            pSticker[y][x] = sticker[y][x]
                        }
                    }

                    for (loop in 0 until 4) {
                        val bSuccess = tryAttach(pSticker)
                        if (!bSuccess) {
                            if (loop < 3) pSticker = rotateClockwise(pSticker)
                        } else {
                            break
                        }
                    }
                }

                var count = 0
                for (y in 0 until n) {
                    for (x in 0 until m) {
                        if (grid[y][x] == 1) ++count
                    }
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
