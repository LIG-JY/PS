package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (m, n, h) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(h) { Array(n) { IntArray(m) } }
                val visited = Array(h) { Array(n) { BooleanArray(m) { false } } }

                data class Node(val z: Int, val y: Int, val x: Int)

                val dq = ArrayDeque<Node>()

                var zeroCount = 0
                for (z in 0 until h) {
                    for (y in 0 until n) {
                        val input = reader.readLine().split(" ").map { it.toInt() }
                        for (x in 0 until m) {
                            val v = input[x]
                            if (v == 0) {
                                ++zeroCount
                            }
                            if (v == 1) {
                                visited[z][y][x] = true
                                dq.addLast(Node(z, y, x))
                            }
                            grid[z][y][x] = input[x]
                        }
                    }
                }

                if (zeroCount == 0) {
                    writer.writeLine(0)
                    return
                }

                val directions = listOf(
                    Node(1, 0, 0),
                    Node(-1, 0, 0),
                    Node(0, 1, 0),
                    Node(0, -1, 0),
                    Node(0, 0, 1),
                    Node(0, 0, -1)
                )

                var level = 0
                while (dq.isNotEmpty()) {
                    repeat(dq.size) {
                        val cur = dq.removeFirst()
                        for (d in directions) {
                            val nz = cur.z + d.z
                            val ny = cur.y + d.y
                            val nx = cur.x + d.x

                            if (nz >= h || nz < 0 || ny >= n || ny < 0 || nx >= m || nx < 0) continue
                            if (grid[nz][ny][nx] == -1) continue
                            if (visited[nz][ny][nx]) continue

                            grid[nz][ny][nx] = 1
                            visited[nz][ny][nx] = true
                            dq.addLast(Node(nz, ny, nx))
                        }
                    }
                    if (dq.isNotEmpty()) ++level
                }

                var result = true
                outer@ for (z in 0 until h) {
                    for (y in 0 until n) {
                        for (x in 0 until m) {
                            if (grid[z][y][x] == 0) {
                                result = false
                                break@outer
                            }
                        }
                    }
                }
                if (result) writer.writeLine(level) else writer.writeLine(-1)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
