package kotlin.S13460

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val WALL = '#'
        const val HOLE = 'O'
    }

    enum class EscapeState {
        FAILURE,
        SUCCESS,
        NOT_YET,
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(n) { reader.readLine().toCharArray() }

                data class Point(var y: Int, var x: Int, val color: Char)

                val blue = Point(-1, -1, 'B')
                val red = Point(-1, -1, 'R')
                for (y in grid.indices) {
                    for (x in grid[y].indices) {
                        if (grid[y][x] == 'B') {
                            blue.y = y
                            blue.x = x
                        } else if (grid[y][x] == 'R') {
                            red.y = y
                            red.x = x
                        }
                    }
                }

                fun getResult(p: Point, q: Point): EscapeState {
                    if (p.x == q.x && p.y == q.y) return EscapeState.FAILURE
                    if (grid[p.y][p.x] == HOLE) {
                        if (p.color == 'B') {
                            return EscapeState.FAILURE
                        }
                        return EscapeState.SUCCESS
                    }
                    if (grid[q.y][q.x] == HOLE) {
                        if (q.color == 'B') {
                            return EscapeState.FAILURE
                        }
                        return EscapeState.SUCCESS
                    }

                    return EscapeState.NOT_YET
                }

                fun tiltRight(red: Point, blue: Point, grid: Array<CharArray>): EscapeState {
                    val rightMost: Point
                    val leftMost: Point
                    if (blue.x > red.x) {
                        rightMost = blue
                        leftMost = red
                    } else {
                        rightMost = red
                        leftMost = blue
                    }

                    fun goRight(p: Point) {
                        val color = p.color
                        grid[p.y][p.x] = '.'
                        for (x in p.x + 1 until m) {
                            if (grid[p.y][x] == WALL || grid[p.y][x] == 'R' || grid[p.y][x] == 'B') {
                                p.x = x - 1
                                break
                            }
                            if (grid[p.y][x] == HOLE) {
                                p.x = x
                                return
                            }
                        }
                        grid[p.y][p.x] = color
                    }

                    goRight(rightMost)
                    goRight(leftMost)

                    return getResult(rightMost, leftMost)
                }

                fun tiltLeft(red: Point, blue: Point, grid: Array<CharArray>): EscapeState {
                    val rightMost: Point
                    val leftMost: Point
                    if (blue.x > red.x) {
                        rightMost = blue
                        leftMost = red
                    } else {
                        rightMost = red
                        leftMost = blue
                    }

                    fun goLeft(p: Point) {
                        val color = p.color
                        grid[p.y][p.x] = '.'
                        for (x in p.x - 1 downTo 0) {
                            if (grid[p.y][x] == WALL || grid[p.y][x] == 'R' || grid[p.y][x] == 'B') {
                                p.x = x + 1
                                break
                            }
                            if (grid[p.y][x] == HOLE) {
                                p.x = x
                                return
                            }
                        }
                        grid[p.y][p.x] = color
                    }

                    goLeft(leftMost)
                    goLeft(rightMost)

                    return getResult(rightMost, leftMost)
                }

                fun tiltUp(red: Point, blue: Point, grid: Array<CharArray>): EscapeState {
                    val topMost: Point
                    val bottomMost: Point
                    if (blue.y < red.y) {
                        topMost = blue
                        bottomMost = red
                    } else {
                        topMost = red
                        bottomMost = blue
                    }

                    fun goUp(p: Point) {
                        val color = p.color
                        grid[p.y][p.x] = '.'
                        for (y in p.y - 1 downTo 0) {
                            if (grid[y][p.x] == WALL || grid[y][p.x] == 'R' || grid[y][p.x] == 'B') {
                                p.y = y + 1
                                break
                            }
                            if (grid[y][p.x] == HOLE) {
                                p.y = y
                                return
                            }
                        }
                        grid[p.y][p.x] = color
                    }

                    goUp(topMost)
                    goUp(bottomMost)

                    return getResult(topMost, bottomMost)
                }

                fun tiltDown(red: Point, blue: Point, grid: Array<CharArray>): EscapeState {
                    val topMost: Point
                    val bottomMost: Point
                    if (blue.y < red.y) {
                        topMost = blue
                        bottomMost = red
                    } else {
                        topMost = red
                        bottomMost = blue
                    }

                    fun goDown(p: Point) {
                        val color = p.color
                        grid[p.y][p.x] = '.'
                        for (y in p.y + 1 until n) {
                            if (grid[y][p.x] == WALL || grid[y][p.x] == 'R' || grid[y][p.x] == 'B') {
                                p.y = y - 1
                                break
                            }
                            if (grid[y][p.x] == HOLE) {
                                p.y = y
                                return
                            }
                        }
                        grid[p.y][p.x] = color
                    }

                    goDown(bottomMost)
                    goDown(topMost)

                    return getResult(topMost, bottomMost)
                }

                val actions = listOf(::tiltUp, ::tiltRight, ::tiltLeft, ::tiltDown)

                data class Node(val red: Point, val blue: Point, val grid: Array<CharArray>) {
                    override fun equals(other: Any?): Boolean {
                        if (this === other) return true
                        if (javaClass != other?.javaClass) return false

                        other as Node

                        if (red != other.red) return false
                        if (blue != other.blue) return false
                        if (!grid.contentDeepEquals(other.grid)) return false

                        return true
                    }

                    override fun hashCode(): Int {
                        var result = red.hashCode()
                        result = 31 * result + blue.hashCode()
                        result = 31 * result + grid.contentDeepHashCode()
                        return result
                    }
                }

                fun copyGrid(grid: Array<CharArray>): Array<CharArray> {
                    val result = Array(grid.size) { CharArray(grid[0].size) }
                    for (y in grid.indices) {
                        for (x in grid[y].indices) {
                            result[y][x] = grid[y][x]
                        }
                    }

                    return result
                }

                fun simulation(): Int {
                    val dq = ArrayDeque<Node>()
                    dq.addLast(Node(red = red, blue = blue, grid = grid))
                    var depth = 0

                    while (!dq.isEmpty()) {
                        ++depth
                        repeat(dq.size) {
                            val node = dq.removeFirst()
                            if (depth <= 10) {
                                for (action in actions) {
                                    val copyRed = node.red.copy()
                                    val copyBlue = node.blue.copy()
                                    val copyGrid = copyGrid(node.grid)
                                    val escapeState = action(copyRed, copyBlue, copyGrid)
                                    if (escapeState == EscapeState.SUCCESS) {
                                        return depth
                                    } else if (escapeState == EscapeState.NOT_YET) {
                                        dq.addLast(Node(red = copyRed, blue = copyBlue, copyGrid))
                                    }
                                }
                            }
                        }
                    }
                    return -1
                }
                writer.writeLine(simulation())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
