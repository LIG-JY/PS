package kotlin.S1941

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val input = reader.readLines()
                val maxY = input.size
                val maxX = input[0].length
                val totalStudentCount = maxY * maxX

                data class Point(val y: Int, val x: Int)

                val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))

                fun isConnected(students: Set<Int>): Boolean {
                    var adj = 0

                    val dq = ArrayDeque<Int>()
                    val visited = BooleanArray(totalStudentCount) { false }

                    val selected = students.first()
                    visited[selected] = true
                    dq.addLast(selected)

                    while (!dq.isEmpty()) {
                        val cur = dq.removeFirst()
                        val y = cur / 5
                        val x = cur % 5
                        ++adj
                        for (direction in directions) {
                            val ny = y + direction.y
                            val nx = x + direction.x
                            if (ny >= maxY || ny < 0 || nx >= maxX || nx < 0) continue
                            if (visited[5 * ny + nx]) continue
                            if (!students.contains(5 * ny + nx)) continue
                            visited[5 * ny + nx] = true
                            dq.addLast(5 * ny + nx)
                        }
                    }

                    return adj == 7
                }

                fun getGroupCount(): Int {
                    var groupCount = 0

                    var sCount = 0
                    val selected = ArrayDeque<Int>()

                    // Select a combination of 7 students from all students
                    fun getCombination(start: Int) {
                        if (selected.size == 7) {
                            if (sCount >= 4) {
                                if (isConnected(selected.toSet())) groupCount++
                            }
                            return
                        }

                        for (i in start until totalStudentCount) {
                            val y = i / 5
                            val x = i % 5
                            if (input[y][x] == 'S') ++sCount
                            selected.addLast(i)
                            getCombination(i + 1)
                            if (input[y][x] == 'S') --sCount
                            selected.removeLast()
                        }
                    }

                    getCombination(0)

                    return groupCount
                }

                writer.writeLine(getGroupCount())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
