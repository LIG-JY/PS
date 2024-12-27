package kotlin.S9328

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val ALPHABET = 26
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val t = reader.readLine().toInt()
                repeat(t) {
                    val (h, w) = reader.readLine().split(" ").map { it.toInt() }
                    val grid = Array(h) { reader.readLine() }
                    val visited = Array(h) { BooleanArray(w) { false } }
                    val keys = BooleanArray(ALPHABET) { false }
                    val keyInput = reader.readLine()
                    if (keyInput != "0") keyInput.forEach { keys[it - 'a'] = true }

                    fun isEdge(y: Int, x: Int) = y == 0 || y == h - 1 || x == 0 || x == w - 1

                    data class Point(val y: Int, val x: Int)

                    val dq = ArrayDeque<Point>()
                    val doors = Array(ALPHABET) { ArrayDeque<Point>() }

                    fun hasKey(y: Int, x: Int) = keys[grid[y][x] - 'A']

                    var count = 0
                    fun visitEmpty(y: Int, x: Int) {
                        visited[y][x] = true
                        dq.addLast(Point(y, x))
                    }

                    fun visitDocs(y: Int, x: Int) {
                        ++count
                        visited[y][x] = true
                        dq.addLast(Point(y, x))
                    }

                    fun visitKey(y: Int, x: Int) {
                        keys[grid[y][x] - 'a'] = true
                        val q = doors[grid[y][x] - 'a']
                        while (q.isNotEmpty()) {
                            val door = q.removeFirst()
                            visited[door.y][door.x] = true
                            dq.addLast(door)
                        }
                        visited[y][x] = true
                        dq.addLast(Point(y, x))
                    }

                    fun visitDoor(y: Int, x: Int) {
                        if (!hasKey(y, x)) doors[grid[y][x] - 'A'].addLast(Point(y, x))
                        else {
                            visited[y][x] = true
                            dq.addLast(Point(y, x))
                        }
                    }

                    fun visit(y: Int, x: Int) {
                        when (grid[y][x]) {
                            '*' -> {}
                            '.' -> visitEmpty(y, x)
                            '$' -> visitDocs(y, x)
                            in 'a'..'z' -> visitKey(y, x)
                            in 'A'..'Z' -> visitDoor(y, x)
                        }
                    }

                    for (y in 0 until h) {
                        for (x in 0 until w) {
                            if (!isEdge(y, x)) continue
                            visit(y, x)
                        }
                    }

                    val directions = listOf(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1))
                    while (dq.isNotEmpty()) {
                        val cur = dq.removeFirst()
                        for (d in directions) {
                            val ny = cur.y + d.y
                            val nx = cur.x + d.x
                            if (ny in 0 until h && nx in 0 until w && !visited[ny][nx]) {
                                visit(ny, nx)
                            }
                        }
                    }
                    writer.writeLine(count)
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}