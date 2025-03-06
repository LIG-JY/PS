package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val OBSTACLE = 1
        const val UNVISITED = -1

        data class Node(val y: Int, val x: Int, val j: Int)
        data class Point(val y: Int, val x: Int)

        val START = Node(0, 0, 0)
        val jumps = listOf(
            Point(2, 1), Point(1, 2), Point(-2, 1), Point(-1, 2),
            Point(2, -1), Point(1, -2), Point(-2, -1), Point(-1, -2)
        )
        val directions = listOf(Point(0, 1), Point(0, -1), Point(1, 0), Point(-1, 0))

        fun main() {
            BufferedReader(InputStreamReader(System.`in`)).use { reader ->
                BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                    val k = reader.readLine().toInt()
                    val (w, h) = reader.readLine().split(" ").map { it.toInt() }
                    val grid = Array(h) { reader.readLine().split(" ").map { it.toInt() } }
                    val distances = Array(h) { Array(w) { Array(k + 1) { UNVISITED } } }
                    val dq = ArrayDeque<Node>()

                    distances[START.y][START.x][START.j] = 0
                    dq.add(START)

                    while (dq.isNotEmpty()) {
                        val current = dq.removeFirst()

                        if (current.y == h - 1 && current.x == w - 1) {
                            writer.writeLine(distances[current.y][current.x][current.j])
                            return
                        }

                        for (d in directions) {
                            val ny = current.y + d.y
                            val nx = current.x + d.x
                            if (ny in 0 until h && nx in 0 until w && grid[ny][nx] != OBSTACLE && distances[ny][nx][current.j] == UNVISITED) {
                                val next = Node(ny, nx, current.j)
                                distances[next.y][next.x][next.j] = distances[current.y][current.x][current.j] + 1
                                dq.addLast(next)
                            }
                        }

                        val nj = current.j + 1

                        if (nj > k) {
                            continue
                        }

                        for (j in jumps) {
                            val jy = current.y + j.y
                            val jx = current.x + j.x
                            if (jy in 0 until h && jx in 0 until w && grid[jy][jx] != OBSTACLE && distances[jy][jx][nj] == UNVISITED) {
                                val next = Node(jy, jx, nj)
                                distances[next.y][next.x][next.j] = distances[current.y][current.x][current.j] + 1
                                dq.addLast(next)
                            }
                        }
                    }
                    writer.writeLine(-1)
                }
            }
        }

        private fun BufferedWriter.writeLine(value: Int) {
            write(value.toString())
            this.newLine()
        }
    }
}
