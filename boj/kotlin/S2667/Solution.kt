package kotlin.S2667

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val VISITED = -1
    }

    val dy = intArrayOf(1, -1, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1)

    data class Point(val y: Int, val x: Int)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                val grid = Array(n) { reader.readLine().map { it - '0' }.toIntArray() }
                val dq = ArrayDeque<Point>()
                val answer = mutableListOf<Int>()

                for (y in 0 until n) {
                    for (x in 0 until n) {
                        if (grid[y][x] == 1) {
                            var count = 0
                            grid[y][x] = VISITED
                            dq.addLast(Point(y, x))

                            while (dq.isNotEmpty()) {
                                val cur = dq.removeFirst()
                                ++count
                                for (i in 0 until 4) {
                                    val ny = cur.y + dy[i]
                                    val nx = cur.x + dx[i]
                                    if (ny >= n || ny < 0 || nx >= n || nx < 0) {
                                        continue
                                    }
                                    if (grid[ny][nx] == 1) {
                                        grid[ny][nx] = VISITED
                                        dq.addLast(Point(ny, nx))
                                    }
                                }
                            }

                            answer.add(count)
                        }
                    }
                }
                answer.sort()

                writer.writeLine(answer.size)
                writer.writeLine(answer.joinToString(System.lineSeparator()))
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}