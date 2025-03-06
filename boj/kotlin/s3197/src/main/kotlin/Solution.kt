package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    val dy = intArrayOf(1, -1, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1)

    data class Point(val y: Int, val x: Int)
    data class Node(val y: Int, val x: Int, val m: Int)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (r, c) = reader.readLine().split(" ").map { it.toInt() }

                val grid = Array(r) { CharArray(c) }
                val lq = ArrayDeque<Node>()    // swan water == .
                val lq2 = ArrayDeque<Node>()   // swan iceberg == X
                val visited = Array(r) { BooleanArray(c) { false } }
                val q = ArrayDeque<Point>() // water == .
                val q2 = ArrayDeque<Point>() // iceberg == X
                val lVisited = Array(r) { IntArray(c) { -1 } }

                var mask = 0
                for (y in 0 until r) {
                    val input = reader.readLine()
                    for (x in 0 until c) {
                        grid[y][x] = input[x]
                        if (input[x] != 'X') {
                            q.addLast(Point(y, x))
                            visited[y][x] = true
                            if (input[x] == 'L') {
                                lq.addLast(Node(y, x, mask))
                                lVisited[y][x] = mask++
                            }
                        }
                    }
                }

                fun outOfBound(y: Int, x: Int) = y >= r || y < 0 || x >= c || x < 0

                // check adjacent water cell
                fun canMelt(p: Point): Boolean {
                    for (i in 0 until 4) {
                        val ny = p.y + dy[i]
                        val nx = p.x + dx[i]

                        if (outOfBound(ny, nx)) continue
                        if (grid[ny][nx] == '.') return true
                    }
                    return false
                }

                var day = 0
                while (true) {
                    while (lq.isNotEmpty()) {
                        val cur = lq.removeFirst()
                        val m = lVisited[cur.y][cur.x]  // mask
                        for (i in 0 until 4) {
                            val ny = cur.y + dy[i]
                            val nx = cur.x + dx[i]

                            if (outOfBound(ny, nx)) continue
                            if (lVisited[ny][nx] == m) continue
                            if (grid[ny][nx] == 'X') {
                                lq2.addLast(Node(ny, nx, m))
                                lVisited[ny][nx] = m
                                continue
                            }
                            if (lVisited[ny][nx] == 1 - m) {
                                writer.writeLine(day)
                                return
                            }
                            lq.addLast(Node(ny, nx, m))
                            lVisited[ny][nx] = m
                        }
                    }

                    while (lq2.isNotEmpty()) {
                        lq.addLast(lq2.removeFirst())
                    }

                    while (q.isNotEmpty()) {
                        val cur = q.removeFirst()
                        for (i in 0 until 4) {
                            val ny = cur.y + dy[i]
                            val nx = cur.x + dx[i]

                            if (outOfBound(ny, nx)) continue
                            if (visited[ny][nx]) continue
                            if (grid[ny][nx] == 'X') {
                                q2.addLast(Point(ny, nx))
                                visited[ny][nx] = true
                            }
                        }
                    }

                    while (q2.isNotEmpty()) {
                        val cur = q2.removeFirst()
                        q.addLast(cur)
                        grid[cur.y][cur.x] = '.'
                    }

                    ++day
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
