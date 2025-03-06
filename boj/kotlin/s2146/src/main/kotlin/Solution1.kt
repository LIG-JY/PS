package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution1 {
    companion object {
        const val LAND = 1
        const val WATER = 0
    }

    data class Point(val y: Int, val x: Int)

    val dy = intArrayOf(1, -1, 0, 0)
    val dx = intArrayOf(0, 0, 1, -1)

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                val grid = Array(n) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }
                val area = Array(grid.size) { IntArray(grid[0].size) { WATER } }

                initArea(grid, area)
                val result = getShortestBridge(area)

                writer.writeLine(result)
            }
        }
    }

    private fun initArea(grid: Array<IntArray>, area: Array<IntArray>) {
        var areaCount = 0
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[y][x] == LAND && area[y][x] == WATER) {
                    makeAreaByBfs(Point(y, x), grid, area, ++areaCount)
                }
            }
        }
    }

    private fun getShortestBridge(readOnlyArea: Array<IntArray>): Int {
        var min = Int.MAX_VALUE
        for (y in readOnlyArea.indices) {
            for (x in readOnlyArea[0].indices) {
                if (readOnlyArea[y][x] != WATER) {
                    val bridgeDistance = makeBridgeByBfs(readOnlyArea, Point(y, x))
                    if (bridgeDistance > 0) {
                        min = minOf(min, bridgeDistance)
                    }
                }
            }
        }
        return min
    }

    private fun makeBridgeByBfs(readOnlyArea: Array<IntArray>, start: Point): Int {
        val areaNumber = readOnlyArea[start.y][start.x]
        val visited = Array(readOnlyArea.size) { BooleanArray(readOnlyArea[0].size) { false } }
        val dq = ArrayDeque<Point>()
        var distance = 0

        visited[start.y][start.x] = true
        dq.addLast(start)
        while (dq.isNotEmpty()) {
            var hasSuccess = false
            repeat(dq.size) {
                val current = dq.removeFirst()
                for (i in 0 until 4) {
                    val ny = current.y + dy[i]
                    val nx = current.x + dx[i]
                    if (ny >= readOnlyArea.size || ny < 0 || nx >= readOnlyArea[0].size || nx < 0) {
                        continue
                    }
                    if (readOnlyArea[ny][nx] == areaNumber) {
                        continue
                    }
                    if (readOnlyArea[ny][nx] == WATER && !visited[ny][nx]) {
                        visited[ny][nx] = true
                        dq.addLast(Point(ny, nx))
                        hasSuccess = true
                    }
                    if (readOnlyArea[ny][nx] != WATER && readOnlyArea[ny][nx] != areaNumber) {
                        return distance
                    }
                }
            }
            if (hasSuccess) {
                ++distance
            }
        }
        return distance
    }

    private fun makeAreaByBfs(
        start: Point,
        readOnlyGrid: Array<IntArray>,
        writableGrid: Array<IntArray>,
        areaNumber: Int
    ) {
        val dq = ArrayDeque<Point>()
        writableGrid[start.y][start.x] = areaNumber
        dq.addLast(start)

        while (!dq.isEmpty()) {
            val current = dq.removeFirst()
            for (i in 0 until 4) {
                val ny = current.y + dy[i]
                val nx = current.x + dx[i]
                if (ny >= readOnlyGrid.size || ny < 0 || nx >= readOnlyGrid[0].size || nx < 0) {
                    continue
                }
                if (readOnlyGrid[ny][nx] != LAND) {
                    continue
                }
                if (writableGrid[ny][nx] != WATER) {
                    continue
                }
                writableGrid[ny][nx] = areaNumber
                dq.addLast(Point(ny, nx))
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Int) {
        this.write("$v")
        this.newLine()
    }
}
