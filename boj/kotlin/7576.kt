package kotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class P7576 {
    companion object {
        data class Point(val y: Int, val x: Int)

        const val AVAILABLE = 1
        const val UNVISITED = 0
        const val UNAVAILABLE = -1
        val DIRECTIONS = listOf(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1))
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (m, n) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(n) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }
                val dq = ArrayDeque<Point>()
                for (y in 0 until n) {
                    for (x in 0 until m) {
                        if (grid[y][x] == AVAILABLE) {
                            dq.addLast(Point(y, x))
                        }
                    }
                }
                while (dq.isNotEmpty()) {
                    val current = dq.removeFirst()
                    for (d in DIRECTIONS) {
                        val ny = current.y + d.y
                        val nx = current.x + d.x
                        if (ny in 0 until n && nx in 0 until m && grid[ny][nx] == UNVISITED) {
                            grid[ny][nx] = grid[current.y][current.x] + 1
                            dq.addLast(Point(ny, nx))
                        }
                    }
                }
                var maxDistance = 0
                for (y in 0 until n) {
                    for (x in 0 until m) {
                        if (grid[y][x] == UNVISITED) {
                            writer.writeLine(UNAVAILABLE)
                            return
                        }
                        maxDistance = maxOf(maxDistance, grid[y][x] - 1)
                    }
                }
                writer.writeLine(maxDistance)
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }
}
