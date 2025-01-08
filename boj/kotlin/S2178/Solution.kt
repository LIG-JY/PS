package kotlin.S2178

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        data class Point(val y: Int, val x: Int)

        const val UNVISITED = -1
        val START_POINT = Point(0, 0)
        val DIRECTIONS = listOf(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1))
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val canvas = Array(n) { reader.readLine().map { it == '1' }.toBooleanArray() }
                val distances = Array(n) { IntArray(m) { UNVISITED } }

                val dq = ArrayDeque<Point>()
                distances[START_POINT.y][START_POINT.x] = 0
                dq.addLast(START_POINT)
                while (dq.isNotEmpty()) {
                    val current = dq.removeFirst()
                    for (i in DIRECTIONS.indices) {
                        val ny = current.y + DIRECTIONS[i].y
                        val nx = current.x + DIRECTIONS[i].x

                        if (ny in 0 until n && nx in 0 until m && canvas[ny][nx] && distances[ny][nx] == UNVISITED) {
                            distances[ny][nx] = distances[current.y][current.x] + 1
                            dq.addLast(Point(ny, nx))
                        }
                    }
                }
                writer.writeLine(distances[n - 1][m - 1] + 1)
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }
}
