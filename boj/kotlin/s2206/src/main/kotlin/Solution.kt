package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val START_LEVEL = 1
        const val NO_LEVEL = 0
    }

    data class Node(val y: Int, val x: Int, var hasBreak: Boolean)

    val dy = listOf(1, -1, 0, 0)
    val dx = listOf(0, 0, 1, -1)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val readOnlyGrid = List(n) {
                    reader.readLine().map { it - '0' }
                }
                val distances =
                    Array(n) {
                        Array(m) {
                            intArrayOf(
                                NO_LEVEL,
                                NO_LEVEL
                            )
                        }
                    }    // intArray's index == number of wall broken
                val dq = ArrayDeque<Node>()

                distances[0][0][0] = START_LEVEL
                dq.addLast(Node(0, 0, false))
                var count = START_LEVEL
                while (dq.isNotEmpty()) {
                    repeat(dq.size) {
                        val current = dq.removeFirst()
                        val level = distances[current.y][current.x][getHasBrokenIndex(current.hasBreak)]
                        assert(count == level)  // feature of bfs

                        if (current.y == n - 1 && current.x == m - 1) {
                            writer.writeLine(level)
                            return
                        }

                        for (i in 0 until 4) {
                            val ny = current.y + dy[i]
                            val nx = current.x + dx[i]
                            if (isOutOfBound(ny, nx, readOnlyGrid)) {
                                continue
                            }
                            var newState = current.hasBreak
                            if (readOnlyGrid[ny][nx] == 1) {
                                if (current.hasBreak) {
                                    continue
                                } else {
                                    newState = true
                                }
                            }
                            val zIndex = getHasBrokenIndex(newState)
                            if (distances[ny][nx][zIndex] > NO_LEVEL) {
                                continue
                            }
                            distances[ny][nx][zIndex] = level + 1
                            dq.addLast(Node(ny, nx, newState))
                        }
                    }
                    count++
                }
                writer.writeLine(-1)
            }
        }
    }

    private fun getHasBrokenIndex(state: Boolean): Int = if (state) 1 else 0

    private fun isOutOfBound(y: Int, x: Int, readOnlyGrid: List<List<Int>>) =
        y >= readOnlyGrid.size || y < 0 || x >= readOnlyGrid[0].size || x < 0

    private fun BufferedWriter.writeLine(v: Int) {
        this.write("$v")
        this.newLine()
    }
}
