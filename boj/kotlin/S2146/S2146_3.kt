package kotlin.S2146

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class S2146_3 {

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
        val UNVISITED = -1
        val NO_OWNER = -1
        val INITIAL_DISTANCE = 0
        val distances = Array(readOnlyArea.size) { IntArray(readOnlyArea[0].size) { UNVISITED } }
        val owners = Array(readOnlyArea.size) { IntArray(readOnlyArea[0].size) { NO_OWNER } }
        val dq = ArrayDeque<Point>()    // multi source BFS
        for ((areaNumber, borderPoints) in islands) {
            for (p in borderPoints) {
                dq.add(p)
                distances[p.y][p.x] = INITIAL_DISTANCE
                owners[p.y][p.x] = areaNumber
            }
        }
        while (dq.isNotEmpty()) {
            var found = false
            var min = Int.MAX_VALUE
            repeat(dq.size) {
                val current = dq.removeFirst()
                val areaNumber = owners[current.y][current.x]
                for (i in 0 until 4) {
                    val ny = current.y + dy[i]
                    val nx = current.x + dx[i]
                    if (ny >= readOnlyArea.size || ny < 0 || nx >= readOnlyArea[0].size || nx < 0) {
                        continue
                    }
                    if (readOnlyArea[ny][nx] == WATER) {
                        if (distances[ny][nx] != UNVISITED) {
                            // 확장 중 다른 지역과 만나는 경우
                            if (owners[ny][nx] != areaNumber) {
                                min = minOf(min, distances[ny][nx] + distances[current.y][current.x])
                                found = true
                                continue
                            }
                            // distances[ny][nx] != UNVISITED && owner[ny][nx] == areaNumber >> 확장 중 같은 지역을 만나는 경우 do nothing
                        }
                        // 확장 중 다른 지역을 만나지 않은 경우
                        if (distances[ny][nx] == UNVISITED) {
                            assert(owners[ny][nx] == UNVISITED)
                            owners[ny][nx] = areaNumber
                            distances[ny][nx] = distances[current.y][current.x] + 1
                            dq.addLast(Point(ny, nx))
                        }
                    }
                }
            }
            // 동일한 레벨에서 탐색 성공한 경우 최소값 보장
            if (found) {
                return min
            }
        }

        return Int.MAX_VALUE    // unreachable
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
