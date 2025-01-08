package kotlin.S13549

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution1 {
    companion object {
        const val MAX_RANGE = 200000
        const val MIN_RANGE = 0
        const val INITIAL_TIME = 0
        const val UNVISITED = -1

        val COMMANDS = listOf({ x: Int -> x + 1 }, { x: Int -> x - 1 })
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, k) = reader.readLine().split(" ").map { it.toInt() }
                val visited = IntArray(MAX_RANGE + 1) { UNVISITED }
                val bfsQueue = ArrayDeque<Int>()

                visited[n] = INITIAL_TIME
                bfsQueue.addLast(n)
                jump(visited, bfsQueue, n, k)
                while (bfsQueue.isNotEmpty()) {
                    val current = bfsQueue.removeFirst()

                    if (current == k) {
                        writer.writeLine(visited[current])
                        return
                    }

                    for (c in COMMANDS) {
                        val next = c(current)
                        if (next in MIN_RANGE..MAX_RANGE && visited[next] == UNVISITED) {
                            visited[next] = visited[current] + 1
                            bfsQueue.addLast(next)
                            jump(visited, bfsQueue, next, k)
                        }
                    }
                }
            }
        }
    }

    private fun jump(visited: IntArray, bfsQueue: ArrayDeque<Int>, location: Int, target: Int) {
        var next = location * 2
        while (next <= MAX_RANGE && visited[next] == UNVISITED) {
            visited[next] = visited[location]
            bfsQueue.addLast(next)
            if (next == target) {
                break
            }
            next *= 2
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }

// Test Case
// 4 6
// 90000 100000
// 100000 100000
}