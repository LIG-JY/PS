package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val grid = Array(12) { reader.readLine().toCharArray() }

                data class Point(val y: Int, val x: Int)

                // 12 * 6 * 12 * 6 * 12 * 6
                fun hasPop(): Boolean {
                    val visited = Array(12) { BooleanArray(6) { false } }
                    val directions = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

                    // 12 * 6
                    fun findGroup(y: Int, x: Int, outTracked: ArrayDeque<Point>): Boolean {
                        val dq = ArrayDeque<Point>()
                        val color = grid[y][x]

                        visited[y][x] = true
                        var count = 1
                        dq.addLast(Point(y, x))
                        outTracked.addLast(Point(y, x))
                        while (dq.isNotEmpty()) {
                            val current = dq.removeFirst()
                            for (direction in directions) {
                                val ny = current.y + direction.first
                                val nx = current.x + direction.second
                                if (ny >= 12 || ny < 0 || nx >= 6 || nx < 0) continue
                                if (visited[ny][nx]) continue
                                if (grid[ny][nx] != color) continue
                                visited[ny][nx] = true
                                ++count
                                dq.addLast(Point(ny, nx))
                                outTracked.addLast(Point(ny, nx))
                            }
                        }

                        return count >= 4
                    }

                    // 12 * 6
                    fun pop(tracked: ArrayDeque<Point>) {
                        tracked.forEach { p ->
                            grid[p.y][p.x] = '.'
                        }
                    }

                    var hasPopped = false
                    // 12 * 6
                    for (y in grid.indices) {
                        for (x in grid[y].indices) {
                            if (visited[y][x]) continue
                            if (grid[y][x] == '.') continue
                            val outTracked = ArrayDeque<Point>()
                            val bIsGroup = findGroup(y, x, outTracked)
                            if (bIsGroup) {
                                pop(outTracked)
                                hasPopped = true
                            }
                        }
                    }

                    return hasPopped
                }

                // 2 * 12 * 6
                fun drop() {
                    for (x in grid.last().indices) {
                        val queue = CharArray(grid.size) { '.' }
                        var qPointer = -1
                        for (y in grid.size - 1 downTo 0) {
                            val ball = grid[y][x]
                            if (ball != '.') {
                                queue[++qPointer] = ball
                            }
                        }

                        qPointer = -1
                        for (y in grid.size - 1 downTo 0) {
                            grid[y][x] = queue[++qPointer]
                        }
                    }
                }

                var totalChain = 0
                while (true) {
                    val hasPopped = hasPop()
                    if (!hasPopped) break
                    totalChain++
                    drop()
                }
                writer.writeLine(totalChain)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
