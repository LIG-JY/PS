package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (m, n) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(n) { IntArray(m) }

                data class Point(val y: Int, val x: Int)

                val dq = ArrayDeque<Point>()
                val distances = Array(n) { IntArray(m) { Int.MIN_VALUE } }

                for (y in 0 until n) {
                    val input = reader.readLine().split(" ")
                    for (x in 0 until m) {
                        grid[y][x] = input[x].toInt()
                        if (grid[y][x] == 1) {
                            distances[y][x] = 0
                            dq.addLast(Point(y, x))
                        }
                    }
                }

                val directions = listOf(Point(0, 1), Point(0, -1), Point(1, 0), Point(-1, 0))

                while (dq.isNotEmpty()) {
                    val cur = dq.removeFirst()
                    for (d in directions) {
                        val ny = cur.y + d.y
                        val nx = cur.x + d.x
                        if (ny in 0 until n && nx in 0 until m) {
                            if (grid[ny][nx] == -1) continue
                            if (distances[ny][nx] != Int.MIN_VALUE) continue
                            grid[ny][nx] = 1
                            distances[ny][nx] = distances[cur.y][cur.x] + 1
                            dq.addLast(Point(ny, nx))
                        }
                    }
                }

                var res = 0
                var b = true
                loop@ for (y in 0 until n) {
                    for (x in 0 until m) {
                        if (grid[y][x] == 0) {
                            b = false
                            break@loop
                        }
                        if (grid[y][x] == 1) {
                            res = maxOf(res, distances[y][x])
                        }
                    }
                }
                if (b) writer.writeLine(res) else writer.writeLine(-1)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
