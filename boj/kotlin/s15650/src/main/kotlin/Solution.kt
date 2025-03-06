package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }

                fun printCombinations(start: Int, end: Int, size: Int) {
                    val visited = BooleanArray(end + 1)

                    fun printCombinationRecursive(iterStart: Int, curSize: Int) {
                        if (curSize == size) {
                            writer.writeLine(visited.foldIndexed(StringBuilder()) { index, acc, isVisited ->
                                if (isVisited) acc.append("$index ")
                                acc
                            }.toString())
                            return
                        }

                        for (num in iterStart..end) {
                            visited[num] = true
                            printCombinationRecursive(num + 1, curSize + 1)
                            visited[num] = false
                        }
                    }
                    printCombinationRecursive(start, 0)
                }

                printCombinations(start = 1, end = n, size = m)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}