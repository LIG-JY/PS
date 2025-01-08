package kotlin.S11967

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        data class Point(val y: Int, val x: Int)

        val DIRECTIONS = listOf(Point(0, 1), Point(0, -1), Point(1, 0), Point(-1, 0))
        val START = Point(1, 1)
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val visited = Array(n + 1) { BooleanArray(n + 1) { false } }
                val light = Array(n + 1) { BooleanArray(n + 1) { false } }
                val commandMap = Array(n + 1) { Array(n + 1) { mutableSetOf<Point>() } }

                repeat(m) {
                    val (y, x, b, a) = reader.readLine().split(" ").map { it.toInt() }
                    commandMap[y][x].add(Point(b, a))
                }
                val dq = ArrayDeque<Point>()

                visited[START.y][START.x] = true
                light[START.y][START.x] = true
                dq.addLast(START)
                while (dq.isNotEmpty()) {
                    val current = dq.removeFirst()
                    // light on and jump
                    for (target in commandMap[current.y][current.x]) {
                        // if visited it is already processed
                        if (!visited[target.y][target.x]) {
                            light[target.y][target.x] = true
                            if (isConnected(target, visited, n)) {
                                visited[target.y][target.x] = true
                                dq.addLast(target)
                            }
                        }
                    }
                    // adjacent exploration
                    for (d in DIRECTIONS) {
                        val ny = current.y + d.y
                        val nx = current.x + d.x
                        if (isInTheRoom(Point(ny, nx), n) && light[ny][nx] && !visited[ny][nx]) {
                            visited[ny][nx] = true
                            dq.addLast(Point(ny, nx))
                        }
                    }
                }
                writer.writeLine(light.sumOf { it.count { on: Boolean -> on } })
            }
        }
    }

    private fun isInTheRoom(p: Point, size: Int): Boolean = p.y in 1..size && p.x in 1..size

    private fun isConnected(p: Point, visited: Array<BooleanArray>, size: Int): Boolean {
        for (d in DIRECTIONS) {
            val ny = p.y + d.y
            val nx = p.x + d.x
            if (isInTheRoom(Point(ny, nx), size) && visited[ny][nx]) {
                return true
            }
        }
        return false
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }
}
