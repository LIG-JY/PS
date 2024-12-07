package kotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class S13549_2 {
    companion object {
        const val MAX_RANGE = 100000
        const val MIN_RANGE = 0
        const val INITIAL_TIME = 0

        data class Struct(val location: Int, val time: Int)

        val commands = listOf({ x: Int -> 2 * x }, { x: Int -> x + 1 }, { x: Int -> x - 1 })
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, k) = reader.readLine().split(" ").map { it.toInt() }
                val visited = BooleanArray(MAX_RANGE + 1) { false }
                val dq = ArrayDeque<Struct>()

                dq.addLast(Struct(n, INITIAL_TIME))
                while (dq.isNotEmpty()) {
                    // 꺼낸 결과는 이미 순서가 보장된(time 오름차순으로 정렬된 큐의 결과)
                    val current = dq.removeFirst()
                    visited[current.location] = true

                    val currentLocation = current.location
                    if (currentLocation == k) {
                        writer.writeLine(current.time)
                        return
                    }

                    for (i in commands.indices) {
                        val command = commands[i]
                        if (currentLocation > k) {
                            if (i == 0 || i == 1) {
                                continue
                            }
                        }
                        val nextLocation = command(currentLocation)
                        // 큐에 들어간 후 순서가 보장됨
                        if (nextLocation in MIN_RANGE..MAX_RANGE && !visited[nextLocation]) {
                            if (i == 0) {
                                dq.addFirst(Struct(nextLocation, current.time))
                            } else {
                                dq.addLast(Struct(nextLocation, current.time + 1))
                            }
                        }
                    }
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }

// Test Case
// 4 6
}
