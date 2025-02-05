package kotlin.S12100

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                val inputGrid = Array(n) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

                fun deepCopyGrid(origin: Array<IntArray>): Array<IntArray> {
                    val copy = Array(n) { IntArray(n) }
                    for (y in inputGrid.indices) {
                        for (x in inputGrid[y].indices) {
                            copy[y][x] = origin[y][x]
                        }
                    }

                    return copy
                }

                fun moveUp(grid: Array<IntArray>) {
                    val queue = ArrayDeque<Int>()
                    for (x in grid.first().indices) {
                        for (y in grid.indices) {
                            val value = grid[y][x]
                            if (value > 0) {
                                queue.addLast(grid[y][x])
                                grid[y][x] = 0
                            }
                        }

                        var loc = 0
                        val colSize = grid.size
                        while (queue.isNotEmpty() && loc < colSize) {
                            val cur = queue.removeFirst()
                            if (queue.isEmpty()) {
                                grid[loc][x] = cur
                                break
                            }
                            val next = queue.first()
                            if (cur == next) {
                                queue.removeFirst()
                                grid[loc][x] = 2 * cur
                            } else {
                                grid[loc][x] = cur
                            }
                            ++loc
                        }
                        queue.clear()
                    }
                }

                fun moveDown(grid: Array<IntArray>) {
                    val queue = ArrayDeque<Int>()
                    val colSize = grid.size
                    for (x in grid.first().indices) {
                        for (y in colSize - 1 downTo 0) {
                            val value = grid[y][x]
                            if (value > 0) {
                                queue.addLast(grid[y][x])
                                grid[y][x] = 0
                            }
                        }

                        var loc = colSize - 1
                        while (queue.isNotEmpty() && loc >= 0) {
                            val cur = queue.removeFirst()
                            if (queue.isEmpty()) {
                                grid[loc][x] = cur
                                break
                            }
                            val next = queue.first()
                            if (cur == next) {
                                queue.removeFirst()
                                grid[loc][x] = 2 * cur
                            } else {
                                grid[loc][x] = cur
                            }
                            --loc
                        }
                        queue.clear()
                    }
                }

                fun moveLeft(grid: Array<IntArray>) {
                    val queue = ArrayDeque<Int>()
                    for (y in grid.indices) {
                        for (x in grid[y].indices) {
                            val value = grid[y][x]
                            if (value > 0) {
                                queue.addLast(grid[y][x])
                                grid[y][x] = 0
                            }
                        }

                        val rowSize = grid.first().size
                        var loc = 0
                        while (queue.isNotEmpty() && loc < rowSize) {
                            val cur = queue.removeFirst()
                            if (queue.isEmpty()) {
                                grid[y][loc] = cur
                                break
                            }
                            val next = queue.first()
                            if (cur == next) {
                                queue.removeFirst()
                                grid[y][loc] = 2 * cur
                            } else {
                                grid[y][loc] = cur
                            }
                            ++loc
                        }
                        queue.clear()
                    }
                }

                fun moveRight(grid: Array<IntArray>) {
                    val queue = ArrayDeque<Int>()
                    val rowSize = grid.first().size
                    for (y in grid.indices) {
                        for (x in rowSize - 1 downTo 0) {
                            val value = grid[y][x]
                            if (value > 0) {
                                queue.addLast(grid[y][x])
                                grid[y][x] = 0
                            }
                        }

                        var loc = rowSize - 1
                        while (queue.isNotEmpty() && loc >= 0) {
                            val cur = queue.removeFirst()
                            if (queue.isEmpty()) {
                                grid[y][loc] = cur
                                break
                            }
                            val next = queue.first()
                            if (cur == next) {
                                queue.removeFirst()
                                grid[y][loc] = 2 * cur
                            } else {
                                grid[y][loc] = cur
                            }
                            --loc
                        }
                        queue.clear()
                    }
                }

                fun play(): Int {
                    val moves = arrayOf(::moveUp, ::moveDown, ::moveRight, ::moveLeft)
                    var result = Int.MIN_VALUE

                    fun playRecursive(depth: Int, grid: Array<IntArray>) {
                        // base condition
                        if (depth == 5) {
                            // find max
                            for (y in grid.indices) {
                                for (x in grid[y].indices) {
                                    result = maxOf(result, grid[y][x])
                                }
                            }
                            return
                        }

                        for (i in moves.indices) {
                            val copied = deepCopyGrid(grid)
                            moves[i](copied)
                            playRecursive(depth + 1, copied)
                        }
                    }

                    playRecursive(0, deepCopyGrid(inputGrid))

                    return result
                }

                writer.writeLine(play())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
