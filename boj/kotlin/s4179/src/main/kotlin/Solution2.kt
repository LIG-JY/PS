package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2 {
    companion object {
        data class Point(val y: Int, val x: Int)

        const val UNAVAILABLE = '#'
        const val UNVISITED = -1
        const val INITIAL_TIME = 0
        val DIRECTIONS = listOf(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1))

        fun main() {
            BufferedReader(InputStreamReader(System.`in`)).use { reader ->
                BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                    val (r, c) = reader.readLine().split(" ").map { it.toInt() }
                    val maze = List(r) { reader.readLine().toList() }

                    val man = Array(r) { IntArray(c) { UNVISITED } }
                    val fire = Array(r) { IntArray(c) { UNVISITED } }
                    val manQueue = ArrayDeque<Point>()
                    val fireQueue = ArrayDeque<Point>()

                    for (y in maze.indices) {
                        for (x in maze[y].indices) {
                            when (maze[y][x]) {
                                'F' -> {
                                    fire[y][x] = INITIAL_TIME
                                    fireQueue.addLast(Point(y, x))
                                }

                                'J' -> {
                                    man[y][x] = INITIAL_TIME
                                    manQueue.addLast(Point(y, x))
                                }
                            }
                        }
                    }
                    while (fireQueue.isNotEmpty()) {
                        val current = fireQueue.removeFirst()
                        for (d in DIRECTIONS) {
                            val ny = current.y + d.y
                            val nx = current.x + d.x
                            if (ny in 0 until r && nx in 0 until c) {
                                if (maze[ny][nx] == UNAVAILABLE) {
                                    continue
                                }
                                if (fire[ny][nx] == UNVISITED) {
                                    fire[ny][nx] = fire[current.y][current.x] + 1
                                    fireQueue.addLast(Point(ny, nx))
                                }
                            }
                        }
                    }

                    while (manQueue.isNotEmpty()) {
                        val current = manQueue.removeFirst()
                        val time = man[current.y][current.x]
                        for (d in DIRECTIONS) {
                            val ny = current.y + d.y
                            val nx = current.x + d.x
                            if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                                writer.writeLine((time + 1).toString())
                                return
                            }
                            if (maze[ny][nx] == UNAVAILABLE || fire[ny][nx] != UNVISITED && time + 1 >= fire[ny][nx]) {
                                continue
                            }
                            if (man[ny][nx] == UNVISITED) {
                                man[ny][nx] = time + 1
                                manQueue.addLast(Point(ny, nx))
                            }
                        }
                    }
                    writer.writeLine("IMPOSSIBLE")
                }
            }
        }

        private fun BufferedWriter.writeLine(value: String) {
            this.write(value)
            this.newLine()
        }
    }
}
