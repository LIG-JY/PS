package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val SEA = 0

        val dy = listOf(-1, 0, 1, 0)
        val dx = listOf(0, 1, 0, -1)

        data class Point(val y: Int, val x: Int)
        data class Node(val y: Int, val x: Int, val loss: Int)

        enum class Result {
            FAIL,
            SUCCESS,
            CLEAR,
        }

        fun main() {
            BufferedReader(InputStreamReader(System.`in`)).use { reader ->
                BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                    val grid = Array(n) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

                    var turn = 0
                    while (true) {
                        val result = executeTurn(grid, height = n, width = m)

                        when (result) {
                            Result.FAIL -> {
                                writer.writeLine(turn)
                                break
                            }

                            Result.SUCCESS -> {
                                ++turn
                            }

                            Result.CLEAR -> {
                                writer.writeLine(0)
                                break
                            }
                        }
                    }
                }
            }
        }

        private fun executeTurn(grid: Array<IntArray>, height: Int, width: Int): Result {
            var blockCount = 0
            val visited = Array(height) { BooleanArray(width) { false } }
            val iceToMelt = mutableListOf<Node>()
            for (y in 0 until height) {
                for (x in 0 until width) {
                    if (grid[y][x] != SEA && !visited[y][x]) {
                        ++blockCount
                        if (blockCount >= 2) {
                            return Result.FAIL
                        }
                        iceToMelt.addAll(search(y, x, grid, height = height, width = width, visited = visited))
                    }
                }
            }

            if (blockCount == 0) {
                return Result.CLEAR
            }

            // execute melting
            iceToMelt.forEach { node ->
                grid[node.y][node.x] = maxOf(grid[node.y][node.x] - node.loss, 0)
            }
            return Result.SUCCESS
        }

        private fun search(
            y: Int,
            x: Int,
            grid: Array<IntArray>,
            height: Int,
            width: Int,
            visited: Array<BooleanArray>
        ): MutableList<Node> {
            val result = mutableListOf<Node>()
            val dq = ArrayDeque<Point>()

            result.add(Node(y, x, getLoss(y, x, grid, height, width)))
            visited[y][x] = true
            dq.addLast(Point(y, x))
            while (dq.isNotEmpty()) {
                val current = dq.removeFirst()
                for (i in 0 until 4) {
                    val ny = current.y + dy[i]
                    val nx = current.x + dx[i]
                    if (ny >= height || ny < 0 || nx >= width || nx < 0) {
                        continue
                    }
                    if (grid[ny][nx] == SEA) {
                        continue
                    }
                    if (visited[ny][nx]) {
                        continue
                    }
                    result.add(Node(ny, nx, getLoss(ny, nx, grid, height, width)))
                    visited[ny][nx] = true
                    dq.addLast(Point(ny, nx))
                }
            }
            return result
        }

        private fun getLoss(y: Int, x: Int, grid: Array<IntArray>, height: Int, width: Int): Int {
            var loss = 0
            for (i in 0 until 4) {
                val ny = y + dy[i]
                val nx = x + dx[i]
                if (ny >= height || ny < 0 || nx >= width || nx < 0) {
                    continue
                }
                if (grid[ny][nx] == SEA) {
                    loss++
                }
            }
            return loss
        }

        private fun BufferedWriter.writeLine(v: Int) {
            this.write("$v")
            this.newLine()
        }
    }
}
