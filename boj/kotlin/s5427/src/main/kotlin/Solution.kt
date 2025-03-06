package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    val dy = intArrayOf(0, 0, -1, 1)
    val dx = intArrayOf(1, -1, 0, 0)

    data class Point(val y: Int, val x: Int)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()

                fun solve() {
                    val (w, h) = reader.readLine().split(" ").map { it.toInt() }
                    val grid = Array(h) { reader.readLine().toCharArray() }
                    val sVisited = Array(h) { BooleanArray(w) { false } }
                    val sq = ArrayDeque<Point>()
                    val fVisited = Array(h) { BooleanArray(w) { false } }
                    val fq = ArrayDeque<Point>()

                    for (y in 0 until h) {
                        for (x in 0 until w) {
                            if (grid[y][x] == '@') {
                                sVisited[y][x] = true
                                sq.addLast(Point(y, x))
                            } else if (grid[y][x] == '*') {
                                fVisited[y][x] = true
                                fq.addLast(Point(y, x))
                            }
                        }
                    }

                    var level = 0
                    while (true) {
                        ++level

                        repeat(fq.size) {
                            val cur = fq.removeFirst()
                            for (i in 0 until 4) {
                                val ny = cur.y + dy[i]
                                val nx = cur.x + dx[i]

                                if (ny >= h || ny < 0 || nx >= w || nx < 0) {
                                    continue
                                }

                                if (grid[ny][nx] == '#') {
                                    continue
                                }

                                if (fVisited[ny][nx]) {
                                    continue
                                }

                                fVisited[ny][nx] = true
                                fq.addLast(Point(ny, nx))
                                grid[ny][nx] = '*'
                            }
                        }

                        repeat(sq.size) {
                            val cur = sq.removeFirst()
                            for (i in 0 until 4) {
                                val ny = cur.y + dy[i]
                                val nx = cur.x + dx[i]

                                if (ny >= h || ny < 0 || nx >= w || nx < 0) {
                                    writer.writeLine(level)
                                    return
                                }

                                if (grid[ny][nx] == '#' || grid[ny][nx] == '*') {
                                    continue
                                }

                                if (sVisited[ny][nx]) {
                                    continue
                                }

                                sVisited[ny][nx] = true
                                sq.addLast(Point(ny, nx))
                            }
                        }

                        if (sq.isEmpty()) {
                            break
                        }
                    }
                    writer.writeLine("IMPOSSIBLE")
                }

                repeat(n) { solve() }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
