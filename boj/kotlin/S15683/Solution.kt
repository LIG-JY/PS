package kotlin.S15683

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                // input
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val grid = Array(n) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }

                data class Point(val y: Int = 0, val x: Int = 0)

                val cctvs = mutableMapOf<Int, List<List<Point>>>()
                cctvs[1] = listOf(listOf(Point(1, 0)), listOf(Point(0, 1)), listOf(Point(-1, 0)), listOf(Point(0, -1)))
                cctvs[2] = listOf(listOf(Point(1, 0), Point(-1, 0)), listOf(Point(0, 1), Point(0, -1)))
                cctvs[3] = listOf(
                    listOf(Point(1, 0), Point(0, 1)),
                    listOf(Point(1, 0), Point(0, -1)),
                    listOf(Point(-1, 0), Point(0, 1)),
                    listOf(Point(-1, 0), Point(0, -1))
                )
                cctvs[4] = listOf(
                    listOf(Point(1, 0), Point(0, 1), Point(-1, 0)), // not 0,-1
                    listOf(Point(1, 0), Point(-1, 0), Point(0, -1)), // not 0,1
                    listOf(Point(0, 1), Point(-1, 0), Point(0, -1)), // not 1,0
                    listOf(Point(1, 0), Point(0, 1), Point(0, -1))  // not -1,0
                )
                cctvs[5] = listOf(
                    listOf(Point(1, 0), Point(0, 1), Point(-1, 0), Point(0, -1))
                )

                fun getMinimumBlindSpotCount(): Int {
                    val visibleGrid = Array(grid.size) { IntArray(grid[0].size) { 0 } }
                    val cctvLocations = mutableListOf<Point>()
                    for (y in grid.indices) {
                        for (x in grid[y].indices) {
                            if (grid[y][x] in 1..5) {
                                cctvLocations.add(Point(y, x))
                                visibleGrid[y][x]++
                            }
                            if (grid[y][x] == 6) visibleGrid[y][x] = -1
                        }
                    }

                    var result = Int.MAX_VALUE

                    fun computeBlindSpotCount(currentCctvLocationIndex: Int) {
                        if (currentCctvLocationIndex == cctvLocations.size) {
                            var count = 0
                            for (y in visibleGrid.indices) {
                                for (x in visibleGrid[y].indices) {
                                    if (visibleGrid[y][x] == 0) count++
                                }
                            }
                            result = minOf(result, count)

                            return
                        }

                        for (i in currentCctvLocationIndex until cctvLocations.size) {
                            val loc = cctvLocations[i]
                            val cctvType = grid[loc.y][loc.x]
                            val directions = cctvs[cctvType]!!
                            for (direction in directions) {
                                for (d in direction) {
                                    var factor = 1
                                    while (true) {
                                        val ny = loc.y + (factor * d.y)
                                        val nx = loc.x + (factor * d.x)

                                        if (ny >= grid.size || ny < 0 || nx >= grid[0].size || nx < 0) break
                                        if (grid[ny][nx] == 6) break

                                        visibleGrid[ny][nx]++

                                        ++factor
                                    }
                                }

                                computeBlindSpotCount(i + 1)

                                for (d in direction) {
                                    var factor = 1
                                    while (true) {
                                        val ny = loc.y + (factor * d.y)
                                        val nx = loc.x + (factor * d.x)

                                        if (ny >= grid.size || ny < 0 || nx >= grid[0].size || nx < 0) break
                                        if (grid[ny][nx] == 6) break

                                        visibleGrid[ny][nx]--

                                        ++factor
                                    }
                                }
                            }
                        }
                    }

                    computeBlindSpotCount(0)

                    return result
                }

                val minBlindSpot = getMinimumBlindSpotCount()
                writer.writeLine(minBlindSpot)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
