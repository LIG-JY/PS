package kotlin.S1799

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->

                data class Point(val y: Int, val x: Int)

                val n = reader.readLine().toInt()
                val grid = Array(2) { Array(n) { mutableListOf<Point>() } }
                for (y in 0 until n) {
                    val line = reader.readLine().split(" ")
                    for (x in line.indices) {
                        if (line[x] == "1") {
                            val color = if ((y + x) % 2 == 0) 0 else 1  // 0: White, 1: Black
                            val location = (y + x) / 2
                            grid[color][location].add(Point(y, x))
                        }
                    }
                }

                fun solve(color: Int): Int {
                    val used = BooleanArray(n) { false }
                    var maxCount = Int.MIN_VALUE
                    var count = 0

                    fun solveRecursive(location: Int) {
                        if (location == n) {
                            maxCount = maxOf(maxCount, count)
                            return
                        }

                        for (p in grid[color][location]) {
                            val usedIndex = (n + p.x - p.y) / 2
                            if (used[usedIndex]) continue
                            used[usedIndex] = true
                            ++count
                            solveRecursive(location + 1)
                            --count
                            used[usedIndex] = false
                        }
                        solveRecursive(location + 1)
                    }

                    solveRecursive(0)

                    return maxCount
                }

                writer.writeLine(solve(color = 0) + solve(color = 1))
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
