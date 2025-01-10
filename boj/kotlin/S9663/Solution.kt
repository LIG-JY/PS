package kotlin.S9663

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()

                val grid = Array(n) { IntArray(n) { 0 } }   // DEBUG

                val colVisited = BooleanArray(n) { false }
                val upRightDiagonalVisited = BooleanArray(2 * n) { false }
                val downRightDiagonalVisited = BooleanArray(2 * n) { false }

                var res = 0

                fun placeQueenRecursive(row: Int) {
                    if (row == n) {
                        ++res
                        return
                    }

                    for (x in 0 until n) {
                        if (colVisited[x]) continue
                        if (upRightDiagonalVisited[row + x]) continue
                        if (downRightDiagonalVisited[x - row + n]) continue

                        colVisited[x] = true
                        upRightDiagonalVisited[row + x] = true
                        downRightDiagonalVisited[x - row + n] = true
                        grid[row][x] = 1  // DEBUG

                        placeQueenRecursive(row + 1)

                        colVisited[x] = false
                        upRightDiagonalVisited[row + x] = false
                        downRightDiagonalVisited[x - row + n] = false
                        grid[row][x] = 0  // DEBUG
                    }
                }

                placeQueenRecursive(0)
                writer.writeLine(res)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
