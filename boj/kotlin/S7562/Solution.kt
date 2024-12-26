package kotlin.S7562

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                repeat(n) {
                    val i = reader.readLine().toInt()
                    val visited = Array(i) { BooleanArray(i) { false } }
                    val (sx, sy) = reader.readLine().split(" ").map { it.toInt() }
                    val (tx, ty) = reader.readLine().split(" ").map { it.toInt() }

                    fun solve() {
                        data class Point(val y: Int, val x: Int)

                        val directions = listOf(
                            Point(1, 2),
                            Point(2, 1),
                            Point(-1, 2),
                            Point(-2, 1),
                            Point(-1, -2),
                            Point(-2, -1),
                            Point(1, -2),
                            Point(2, -1)
                        )
                        val dq = ArrayDeque<Point>()
                        var level = 0

                        if (sy == ty && sx == tx) {
                            writer.writeLine(level)
                            return
                        }
                        visited[sy][sx] = true
                        dq.addLast(Point(sy, sx))

                        while (dq.isNotEmpty()) {
                            ++level
                            repeat(dq.size) {
                                val cur = dq.removeFirst()
                                for (direction in directions) {
                                    val ny = cur.y + direction.y
                                    val nx = cur.x + direction.x
                                    if (ny >= i || ny < 0 || nx >= i || nx < 0) {
                                        continue
                                    }
                                    if (ny == ty && nx == tx) {
                                        writer.writeLine(level)
                                        return
                                    }
                                    if (visited[ny][nx]) {
                                        continue
                                    }
                                    visited[ny][nx] = true
                                    dq.addLast(Point(ny, nx))
                                }
                            }
                        }
                    }

                    solve()
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
