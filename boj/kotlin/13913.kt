package kotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class S13913 {
    companion object {
        const val MAX_RANGE = 200000
        const val MIN_RANGE = 0
        const val UNVISITED = -1
        const val START = -2

        val COMMANDS = listOf({ x: Int -> 2 * x }, { x: Int -> x + 1 }, { x: Int -> x - 1 })
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, k) = reader.readLine().split(" ").map { it.toInt() }
                val visited = IntArray(MAX_RANGE + 1) { UNVISITED }
                val dq = ArrayDeque<Int>()

                visited[n] = START
                dq.addLast(n)
                while (dq.isNotEmpty()) {
                    val current = dq.removeFirst()
                    if (current == k) {
                        val answer = getAnswer(current, visited)
                        writer.writeLine(answer.size - 1)
                        while (answer.isNotEmpty()) {
                            val v = answer.removeLast()
                            writer.write("$v ")
                        }
                        return
                    }
                    for (i in COMMANDS.indices) {
                        if (current > k) {
                            if (i == 0 || i == 1) {
                                continue
                            }
                        }
                        val command = COMMANDS[i]
                        val next = command(current)
                        if (next in MIN_RANGE..MAX_RANGE && visited[next] == UNVISITED) {
                            visited[next] = current
                            dq.addLast(next)
                        }
                    }
                }
            }
        }
    }

    private fun getAnswer(current: Int, visited: IntArray): ArrayDeque<Int> {
        val result = ArrayDeque<Int>()
        var temp = current
        while (temp != START) {
            result.addLast(temp)
            temp = visited[temp]
        }
        return result
    }

    private fun BufferedWriter.writeLine(value: Int) {
        write(value.toString())
        this.newLine()
    }
}
