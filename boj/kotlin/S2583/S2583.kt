package kotlin.S2583

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class S2583 {

    companion object {
        const val VISITED = -1
    }

    data class Point(val y: Int, val x: Int)

    val dy = listOf(1, -1, 0, 0)
    val dx = listOf(0, 0, 1, -1)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m, k) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(n) { IntArray(m) { 0 } }
                repeat(k) {
                    val (lbx, lby, rtx, rty) = reader.readLine().split(" ").map { it.toInt() }
                    for (y in lby until rty) {
                        for (x in lbx until rtx) {
                            grid[y][x] = 1
                        }
                    }
                }
                val result = mutableListOf<Int>()
                val dq = ArrayDeque<Point>()
                for (y in 0 until n) {
                    for (x in 0 until m) {
                        if (grid[y][x] == 0) {
                            var count = 0
                            grid[y][x] = VISITED
                            dq.addLast(Point(y, x))

                            while (dq.isNotEmpty()) {
                                val curr = dq.removeFirst()
                                ++count

                                for (i in 0 until 4) {
                                    val ny = curr.y + dy[i]
                                    val nx = curr.x + dx[i]

                                    if (ny >= n || ny < 0 || nx >= m || nx < 0) {
                                        continue
                                    }
                                    if (grid[ny][nx] == VISITED || grid[ny][nx] == 1) {
                                        continue
                                    }

                                    grid[ny][nx] = VISITED
                                    dq.addLast(Point(ny, nx))
                                }
                            }
                            result.add(count)
                        }
                    }
                }
                result.sort()
                writer.writeLine(result.size)
                writer.writeLine(result.joinToString(" "))
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
