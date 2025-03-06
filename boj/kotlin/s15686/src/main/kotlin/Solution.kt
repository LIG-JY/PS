package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(n) { reader.readLine().split(" ").map { it.toInt() } }

                data class Point(val y: Int, val x: Int) {
                    fun getDistance(other: Point): Int {
                        return abs(y - other.y) + abs(x - other.x)
                    }
                }

                val homes = mutableListOf<Point>()
                val restaurant = mutableListOf<Point>()

                for (y in grid.indices) {
                    for (x in grid[y].indices) {
                        if (grid[y][x] == 1) homes.add(Point(y, x))
                        if (grid[y][x] == 2) restaurant.add(Point(y, x))
                    }
                }

                val selected = BooleanArray(restaurant.size) { false }

                fun getChickenDistance(): Int {
                    val map = mutableMapOf<Point, Int>()

                    for (h in homes) {
                        var minDistance = Int.MAX_VALUE
                        for (i in restaurant.indices) {
                            if (!selected[i]) continue
                            val r = restaurant[i]
                            minDistance = minOf(minDistance, h.getDistance(r))
                        }
                        map[h] = minDistance
                    }

                    var distanceSum = 0
                    map.forEach { (_, v) ->
                        distanceSum += v
                    }

                    return distanceSum
                }

                fun getMinChickenDistance(): Int {
                    var result = Int.MAX_VALUE
                    fun selectRecursive(curLoc: Int, curSize: Int, size: Int) {
                        if (curSize == size) {
                            val chickenDistance = getChickenDistance()
                            result = minOf(result, chickenDistance)
                            return
                        }

                        for (i in curLoc until selected.size) {
                            selected[i] = true
                            selectRecursive(i + 1, curSize + 1, size)
                            selected[i] = false
                        }
                    }

                    for (size in 1..m) {
                        selectRecursive(0, 0, size)
                    }

                    return result
                }

                writer.writeLine(getMinChickenDistance())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
