package kotlin.S16920

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class S16920 {

    companion object {
        const val UNVISITED = '.'
        const val WALL = '#'
    }

    data class Point(val y: Int, val x: Int)
    data class Node(val p: Point, val step: Int)

    val directions = listOf(Point(0, 1), Point(0, -1), Point(1, 0), Point(-1, 0))

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m, p) = reader.readLine().split(" ").map { it.toInt() }
                val maxSteps = ArrayDeque<Int>()
                maxSteps.addAll(reader.readLine().split(" ").map { it.toInt() })
                maxSteps.addFirst(Int.MIN_VALUE)
                val grid = Array(n) { reader.readLine().toCharArray() }
                val playerCastleCounts = IntArray(p + 1) { 0 }
                val playerQueues = Array(p + 1) { ArrayDeque<Node>() }

                for (y in 0 until n) {
                    for (x in 0 until m) {
                        val v = grid[y][x]
                        if (v.isDigit()) {
                            playerCastleCounts[v.digitToInt()]++
                            playerQueues[v.digitToInt()].addLast(Node(Point(y, x), 0))
                        }
                    }
                }

                while (!playerQueues.all { it.isEmpty() }) {
                    for (playerIndex in 1..p) {
                        val playerQueue = playerQueues[playerIndex]
                        val nextQueue = ArrayDeque<Node>()
                        // bfs
                        while (playerQueue.isNotEmpty()) {
                            val current = playerQueue.removeFirst()
                            val currentPoint = current.p
                            val currentStep = current.step

                            if (current.step >= maxSteps[playerIndex]) {
                                nextQueue.addLast(Node(currentPoint, 0))
                                continue
                            }

                            for (d in directions) {
                                val ny = currentPoint.y + d.y
                                val nx = currentPoint.x + d.x
                                if (ny in 0 until n && nx in 0 until m && grid[ny][nx] != WALL && grid[ny][nx] == UNVISITED) {
                                    playerCastleCounts[playerIndex]++
                                    grid[ny][nx] = playerIndex.digitToChar()
                                    playerQueue.addLast(Node(Point(ny, nx), currentStep + 1))
                                }
                            }
                        }
                        playerQueues[playerIndex] = nextQueue
                    }
                }

                for (playerIndex in 1..p) {
                    val count = playerCastleCounts[playerIndex]
                    writer.write("$count ")
                }
            }
        }
    }
}
