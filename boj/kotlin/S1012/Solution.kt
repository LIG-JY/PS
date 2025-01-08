package kotlin.S1012

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        data class Point(val y: Int, val x: Int)

        val DIRECTIONS = listOf(Point(0, 1), Point(0, -1), Point(1, 0), Point(-1, 0))
        const val EXIST = 1
        const val NON_EXIST = 0
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val t = reader.readLine().toInt()
                repeat(t) {
                    val (m, n, k) = reader.readLine().split(" ").map { it.toInt() }
                    val grid = Array(n) { IntArray(m) { NON_EXIST } }
                    repeat(k) {
                        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
                        grid[y][x] = EXIST
                    }
                    var count = 0
                    for (y in grid.indices) {
                        for (x in grid[y].indices) {
                            if (grid[y][x] == EXIST) {
                                ++count
                                bfs(grid, Point(y, x))
                            }
                        }
                    }
                    writer.writeLine(count)
                }
            }
        }
    }

    private fun bfs(grid: Array<IntArray>, start: Point) {
        val dq = ArrayDeque<Point>()
        grid[start.y][start.x] = NON_EXIST
        dq.addLast(start)

        while (dq.isNotEmpty()) {
            val current = dq.removeFirst()
            for (d in DIRECTIONS) {
                val ny = current.y + d.y
                val nx = current.x + d.x
                if (ny in grid.indices && nx in 0 until grid[current.y].size && grid[ny][nx] == EXIST) {
                    grid[ny][nx] = NON_EXIST
                    dq.addLast(Point(ny, nx))
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }
}
