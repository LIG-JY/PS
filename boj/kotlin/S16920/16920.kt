package kotlin.S16920

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class S16920 {
    data class Point(val y: Int, val x: Int)

    data class Node(val p: Point, val step: Int)

    val directions = listOf(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1))

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m, p) = reader.readLine().split(" ").map { it.toInt() }
                val maxSteps = mutableListOf<Int>() // 1-based index
                maxSteps.add(Int.MIN_VALUE)
                maxSteps.addAll(reader.readLine().split(" ").map { it.toInt() })
                val grid = Array(n) { reader.readLine().toCharArray() }
                val visited = Array(n) { BooleanArray(m) { false } }
                val playerQueues = Array(p + 1) { ArrayDeque<Node>() }

                for (y in grid.indices) {
                    for (x in grid[y].indices) {
                        if (grid[y][x].isDigit()) {
                            visited[y][x] = true
                            playerQueues[grid[y][x].digitToInt()].addLast(Node(Point(y, x), 0))
                        }
                    }
                }

                while (true) {
                    for (i in 1..p) {
                        val playerQueue = playerQueues[i]
                        val nextQueue = ArrayDeque<Node>()

                        while (playerQueue.isNotEmpty()) {
                            val current = playerQueue.removeFirst()
                            val point = current.p
                            val step = current.step

                            if (step >= maxSteps[i]) {
                                nextQueue.addLast(Node(point, 0))
                                continue
                            }

                            for (d in directions) {
                                val ny = point.y + d.y
                                val nx = point.x + d.x

                                if (ny in 0 until n && nx in 0 until m && !visited[ny][nx] && grid[ny][nx] != '#') {
                                    visited[ny][nx] = true
                                    grid[ny][nx] = i.digitToChar()
                                    playerQueue.addLast(Node(Point(ny, nx), step + 1))
                                }
                            }
                        }
                        playerQueues[i] = nextQueue
                    }

                    if (playerQueues.all { it.isEmpty() }) {
                        break
                    }
                }

                for (num in 1..p) {
                    var count = 0
                    for (y in grid.indices) {
                        for (x in grid[y].indices) {
                            val v = grid[y][x]
                            if (v.isDigit() && v.digitToInt() == num) {
                                ++count
                            }
                        }
                    }
                    writer.write("$count ")
                }
            }
        }
    }
}
