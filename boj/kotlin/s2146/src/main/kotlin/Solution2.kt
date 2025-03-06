package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2 {
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

                val islands = initArea(grid, area)
                determineAreaBorders(area, islands)
                val result = getShortestBridge(area, islands)

                writer.writeLine(result)
            }
        }
    }

    private fun initArea(
        readOnlyGrid: Array<IntArray>,
        writableArea: Array<IntArray>,
    ): MutableMap<Int, MutableList<Point>> {
        var areaCount = 0
        val islands = mutableMapOf<Int, MutableList<Point>>()
        for (y in readOnlyGrid.indices) {
            for (x in readOnlyGrid[y].indices) {
                if (readOnlyGrid[y][x] == LAND && writableArea[y][x] == WATER) {
                    makeAreaByBfs(Point(y, x), readOnlyGrid, writableArea, ++areaCount, islands)
                }
            }
        }

        return islands
    }

    private fun determineAreaBorders(area: Array<IntArray>, islands: MutableMap<Int, MutableList<Point>>) {
        for (entry in islands) {
            val filtered = entry.value.filter {
                isBorder(area, it)
            }.toMutableList()
            islands.replace(entry.key, filtered)
        }
    }

    private fun isBorder(area: Array<IntArray>, point: Point): Boolean {
        for (i in 0 until 4) {
            val ny = point.y + dy[i]
            val nx = point.x + dx[i]
            if (ny >= area.size || ny < 0 || nx >= area[0].size || nx < 0) {
                continue
            }
            if (area[ny][nx] == WATER) {
                return true
            }
        }
        return false
    }

    private fun getShortestBridge(readOnlyArea: Array<IntArray>, islands: MutableMap<Int, MutableList<Point>>): Int {
        var min = Int.MAX_VALUE

        islands.values.forEach { points ->
            points.forEach {
                if (readOnlyArea[it.y][it.x] != WATER) {
                    val bridgeDistance = makeBridgeByBfs(readOnlyArea, it)
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
        areaNumber: Int,
        islands: MutableMap<Int, MutableList<Point>>  // key: areaNumber, value: Points
    ) {
        val dq = ArrayDeque<Point>()
        writableGrid[start.y][start.x] = areaNumber
        dq.addLast(start)

        while (!dq.isEmpty()) {
            val current = dq.removeFirst()
            islands.getOrPut(areaNumber) { mutableListOf() }.add(current)
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
