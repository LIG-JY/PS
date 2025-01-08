package kotlin.S10026

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        data class Point(val y: Int, val x: Int)

        val DIRECTIONS = listOf(Point(0, 1), Point(0, -1), Point(1, 0), Point(-1, 0))
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                val canvas = Array(n) { reader.readLine().toCharArray() }
                val blindVisited = Array(n) { BooleanArray(n) }
                val nonBlindVisited = Array(n) { BooleanArray(n) }
                var blindAreaCount = 0
                var nonBlindAreaCount = 0

                for (y in 0 until n) {
                    for (x in 0 until n) {
                        if (!nonBlindVisited[y][x]) {
                            ++nonBlindAreaCount
                            bfs(n, canvas, nonBlindVisited, Point(y, x), false)
                        }
                        if (!blindVisited[y][x]) {
                            ++blindAreaCount
                            bfs(n, canvas, blindVisited, Point(y, x), true)
                        }
                    }
                }
                writer.writeLine("$nonBlindAreaCount $blindAreaCount")
            }
        }
    }

    private fun bfs(size: Int, canvas: Array<CharArray>, visited: Array<BooleanArray>, start: Point, isBlind: Boolean) {
        val dq = ArrayDeque<Point>()

        visited[start.y][start.x] = true
        dq.addLast(start)
        while (dq.isNotEmpty()) {
            val point = dq.removeFirst()
            val color = canvas[point.y][point.x]
            for (d in DIRECTIONS) {
                val ny = point.y + d.y
                val nx = point.x + d.x
                if (ny in 0 until size && nx in 0 until size
                    && hasSameColor(isBlind, canvas[ny][nx], color)
                    && !visited[ny][nx]
                ) {
                    visited[ny][nx] = true
                    dq.addLast(Point(ny, nx))
                }
            }
        }
    }

    private fun hasSameColor(isBlind: Boolean, color1: Char, color2: Char): Boolean {
        return if (isBlind) {
            if (color1 == 'B') {
                color2 == 'B'
            } else {
                color2 != 'B'
            }
        } else {
            color1 == color2
        }
    }

    private fun BufferedWriter.writeLine(value: String) {
        this.write(value)
        this.newLine()
    }
}
