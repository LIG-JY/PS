package kotlin.S18809

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                data class Point(val y: Int, val x: Int)

                val (n, m, g, r) = reader.readLine().split(" ").map { it.toInt() }
                val landsCanBeApplied = mutableListOf<Point>()
                val grid = Array(n) { CharArray(m) }

                for (y in 0 until n) {
                    val line = reader.readLine().split(" ")
                    for (x in line.indices) {
                        if (line[x] == "2") {
                            landsCanBeApplied.add(Point(y, x))
                        }
                        grid[y][x] = line[x][0]
                    }
                }

                fun findFlowerCount(greens: ArrayDeque<Point>, reds: ArrayDeque<Point>): Int {
                    val directions = listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
                    var count = 0

                    data class Node(val y: Int, val x: Int, val color: Char, val time: Int)    // green: g, red: r

                    val copiedGrid = Array(n) { CharArray(m) }
                    for (y in grid.indices) {
                        for (x in grid[y].indices) {
                            copiedGrid[y][x] = grid[y][x]
                        }
                    }
                    val visitedGrid = Array(n) { IntArray(m) { Int.MIN_VALUE } }    // time

                    val dq = ArrayDeque<Node>()
                    greens.forEach { g ->
                        dq.addLast(Node(g.y, g.x, 'g', 0))
                        copiedGrid[g.y][g.x] = 'g'
                        visitedGrid[g.y][g.x] = 0
                    }
                    reds.forEach { r ->
                        dq.addLast(Node(r.y, r.x, 'r', 0))
                        copiedGrid[r.y][r.x] = 'r'
                        visitedGrid[r.y][r.x] = 0
                    }

                    while (dq.isNotEmpty()) {
                        val cur = dq.removeFirst()

                        if (copiedGrid[cur.y][cur.x] != 'f') {
                            val newTime = cur.time + 1
                            for (d in directions) {
                                val ny = cur.y + d.y
                                val nx = cur.x + d.x
                                if (ny >= n || ny < 0 || nx >= m || nx < 0) continue
                                if (copiedGrid[ny][nx] == '0') continue
                                // something on the land
                                if (visitedGrid[ny][nx] != Int.MIN_VALUE) {
                                    if (visitedGrid[ny][nx] != newTime) continue
                                    if (visitedGrid[ny][nx] == newTime) {
                                        if ((cur.color == 'g' && copiedGrid[ny][nx] == 'r') || (cur.color == 'r' && copiedGrid[ny][nx] == 'g')) {
                                            ++count
                                            copiedGrid[ny][nx] = 'f'
                                            visitedGrid[ny][nx] = newTime
                                        }
                                        continue
                                    }
                                }
                                // empty land
                                visitedGrid[ny][nx] = newTime
                                copiedGrid[ny][nx] = cur.color
                                dq.addLast(Node(ny, nx, cur.color, newTime))
                            }
                        }
                    }

                    return count
                }

                fun findMaxFlowerCount(): Int {
                    var maxFlowerCount = 0

                    // common culture fluid
                    val visited = BooleanArray(landsCanBeApplied.size)
                    // each culture fluid
                    val greenQ = ArrayDeque<Point>()
                    val redQ = ArrayDeque<Point>()

                    fun findRedCombinationRecursive(start: Int) {
                        if (redQ.size == r) {
                            maxFlowerCount = maxOf(findFlowerCount(greenQ, redQ), maxFlowerCount)
                            return
                        }

                        for (i in start until landsCanBeApplied.size) {
                            if (visited[i]) continue
                            visited[i] = true
                            redQ.addLast(landsCanBeApplied[i])
                            findRedCombinationRecursive(i + 1)
                            redQ.removeLast()
                            visited[i] = false
                        }
                    }

                    fun findGreenCombinationRecursive(start: Int) {
                        if (greenQ.size == g) {
                            findRedCombinationRecursive(0)
                            return
                        }

                        for (i in start until landsCanBeApplied.size) {
                            if (visited[i]) continue
                            visited[i] = true
                            greenQ.addLast(landsCanBeApplied[i])
                            findGreenCombinationRecursive(i + 1)
                            greenQ.removeLast()
                            visited[i] = false
                        }
                    }

                    findGreenCombinationRecursive(0)

                    return maxFlowerCount
                }

                writer.writeLine(findMaxFlowerCount())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
