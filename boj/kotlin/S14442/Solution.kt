package kotlin.S14442

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val UNVISITED = -1
        const val WALL = 1
        const val START_DISTANCE = 0

        data class Struct(val y: Int, val x: Int, val b: Int)
        data class Direction(val dy: Int, val dx: Int)

        val START = Struct(0, 0, 0)
        val DIRECTIONS = listOf(Direction(1, 0), Direction(-1, 0), Direction(0, 1), Direction(0, -1))
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m, k) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(n) { reader.readLine().toCharArray().map { it.digitToInt() } }
                val distances = Array(n) { Array(m) { IntArray(k + 1) { UNVISITED } } }
                val dq = ArrayDeque<Struct>()

                distances[START.y][START.x][START.b] = START_DISTANCE
                dq.addLast(START)

                while (dq.isNotEmpty()) {
                    val current = dq.removeFirst()
                    if (current.y == n - 1 && current.x == m - 1) {
                        writer.writeLine(distances[current.y][current.x][current.b] + 1)
                        return
                    }

                    for (d in DIRECTIONS) {
                        val ny = current.y + d.dy
                        val nx = current.x + d.dx
                        if (ny in 0 until n && nx in 0 until m) {
                            val nb = if (grid[ny][nx] == WALL) {
                                current.b + 1
                            } else {
                                current.b
                            }
                            if (nb <= k && distances[ny][nx][nb] == UNVISITED) {
                                distances[ny][nx][nb] = distances[current.y][current.x][current.b] + 1
                                dq.addLast(Struct(ny, nx, nb))
                            }
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
