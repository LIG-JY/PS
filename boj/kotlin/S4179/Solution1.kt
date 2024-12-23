package kotlin.S4179

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution1 {
    val dy = intArrayOf(1, -1, 0, 0)
    val dx = intArrayOf(0, 0, -1, 1)

    data class Point(val y: Int, val x: Int)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (r, c) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(r) { reader.readLine().toCharArray() }
                val fVisited = Array(r) { BooleanArray(c) { false } }
                val jVisited = Array(r) { BooleanArray(c) { false } }
                val fq = ArrayDeque<Point>()
                val jq = ArrayDeque<Point>()

                for (y in 0 until r) {
                    for (x in 0 until c) {
                        if (grid[y][x] == 'F') {
                            fq.addLast(Point(y, x))
                            fVisited[y][x] = true
                        } else if (grid[y][x] == 'J') {
                            jq.addLast(Point(y, x))
                            jVisited[y][x] = true
                        }
                    }
                }

                var turn = 0
                while (true) {
                    ++turn

                    repeat(fq.size) {
                        val cur = fq.removeFirst()
                        for (i in 0 until 4) {
                            val ny = cur.y + dy[i]
                            val nx = cur.x + dx[i]

                            if (ny >= r || ny < 0 || nx >= c || nx < 0) {
                                continue
                            }

                            if (grid[ny][nx] == '#') {
                                continue
                            }

                            if (fVisited[ny][nx]) {
                                continue
                            }

                            grid[ny][nx] = 'F'
                            fVisited[ny][nx] = true
                            fq.addLast(Point(ny, nx))
                        }
                    }

                    repeat(jq.size) {
                        val cur = jq.removeFirst()
                        for (i in 0 until 4) {
                            val ny = cur.y + dy[i]
                            val nx = cur.x + dx[i]

                            if (ny >= r || ny < 0 || nx >= c || nx < 0) {
                                writer.writeLine(turn)
                                return
                            }

                            if (grid[ny][nx] == '#') {
                                continue
                            }

                            if (grid[ny][nx] == 'F') {
                                continue
                            }

                            if (jVisited[ny][nx]) {
                                continue
                            }

                            jVisited[ny][nx] = true
                            jq.addLast(Point(ny, nx))
                        }
                    }

                    if (jq.isEmpty()) {
                        writer.writeLine("IMPOSSIBLE")
                        return
                    }
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}