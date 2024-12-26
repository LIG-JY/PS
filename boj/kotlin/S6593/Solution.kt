package kotlin.S6593

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    val dz = intArrayOf(1, -1, 0, 0, 0, 0)
    val dy = intArrayOf(0, 0, 1, -1, 0, 0)
    val dx = intArrayOf(0, 0, 0, 0, -1, 1)

    data class Point(val z: Int, val y: Int, val x: Int)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                fun solve(l: Int, r: Int, c: Int) {

                    val grid = Array(l) { Array(r) { CharArray(c) } }
                    val visited = Array(l) { Array(r) { BooleanArray(c) { false } } }
                    val dq = ArrayDeque<Point>()

                    for (z in 0 until l) {
                        for (y in 0 until r) {
                            val input = reader.readLine()
                            for (x in 0 until c) {
                                grid[z][y][x] = input[x]
                                if (grid[z][y][x] == 'S') {
                                    visited[z][y][x] = true
                                    dq.addLast(Point(z, y, x))
                                }
                            }
                        }
                        reader.readLine()   // consume new line
                    }

                    var level = 0
                    while (dq.isNotEmpty()) {
                        ++level

                        repeat(dq.size) {
                            val cur = dq.removeFirst()
                            for (i in 0 until 6) {
                                val nz = cur.z + dz[i]
                                val ny = cur.y + dy[i]
                                val nx = cur.x + dx[i]

                                if (nz >= l || nz < 0 || ny >= r || ny < 0 || nx >= c || nx < 0) {
                                    continue
                                }

                                if (grid[nz][ny][nx] == 'E') {
                                    writer.writeLine("Escaped in $level minute(s).")
                                    return
                                }

                                if (grid[nz][ny][nx] == '#') {
                                    continue
                                }

                                if (visited[nz][ny][nx]) {
                                    continue
                                }

                                visited[nz][ny][nx] = true
                                dq.addLast(Point(nz, ny, nx))
                            }
                        }
                    }
                    writer.writeLine("Trapped!")
                }

                while (true) {
                    val (l, r, c) = reader.readLine().split(" ").map { it.toInt() }

                    if (l == 0 && r == 0 && c == 0) {
                        return
                    }

                    solve(l, r, c)
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}