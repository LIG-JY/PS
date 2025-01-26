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

                fun nQueen(n: Int): Int {
                    var count = 0

                    val rightVisited = BooleanArray(n) { false }
                    val upRightVisited = BooleanArray(2 * n) { false }
                    val downRightVisited = BooleanArray(2 * n) { false }

                    fun findNQueenRecursive(y: Int) {
                        if (y == n) {
                            ++count
                            return
                        }

                        for (x in 0 until n) {
                            if (rightVisited[x]) continue
                            if (upRightVisited[y + x]) continue
                            if (downRightVisited[n + y - x]) continue

                            rightVisited[x] = true
                            upRightVisited[y + x] = true
                            downRightVisited[n + y - x] = true

                            findNQueenRecursive(y + 1)

                            rightVisited[x] = false
                            upRightVisited[y + x] = false
                            downRightVisited[n + y - x] = false
                        }
                    }

                    findNQueenRecursive(0)

                    return count
                }

                writer.writeLine(nQueen(n))
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
