package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

class Solution {
    companion object {
        const val MIN_PRECIPITATION = 1
    }

    data class Point(val y: Int, val x: Int)

    val dy = listOf(1, -1, 0, 0)
    val dx = listOf(0, 0, 1, -1)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                val readOnlyGrid = Array(n) { reader.readLine().split(" ").map { it.toInt() } }
                val maxHeight = readOnlyGrid.flatMap { it }.max()

                var res = 1 // 비 안 내리면 안전한 영역 1개
                for (p in MIN_PRECIPITATION..maxHeight) {
                    res = max(res, solve(p, readOnlyGrid))
                }

                writer.writeLine(res)
            }
        }
    }

    private fun solve(precipitation: Int, readOnlyGrid: Array<List<Int>>): Int {
        val visited = Array(readOnlyGrid.size) { BooleanArray(readOnlyGrid[0].size) { false } }
        var count = 0
        for (y in readOnlyGrid.indices) {
            for (x in 0 until readOnlyGrid[0].size) {
                if (readOnlyGrid[y][x] > precipitation && !visited[y][x]) {
                    // bfs
                    val dq = ArrayDeque<Point>()
                    visited[y][x] = true
                    dq.addLast(Point(y, x))
                    while (dq.isNotEmpty()) {
                        val current = dq.removeFirst()
                        for (i in 0 until 4) {
                            val ny = current.y + dy[i]
                            val nx = current.x + dx[i]
                            if (ny >= readOnlyGrid.size || ny < 0 || nx >= readOnlyGrid[0].size || nx < 0) {
                                continue
                            }
                            if (readOnlyGrid[ny][nx] <= precipitation) {
                                continue
                            }
                            if (visited[ny][nx]) {
                                continue
                            }
                            visited[ny][nx] = true
                            dq.addLast(Point(ny, nx))
                        }
                    }
                    ++count
                }
            }
        }
        return count
    }

    private fun BufferedWriter.writeLine(v: Int) {
        this.write("$v")
        this.newLine()
    }
}
