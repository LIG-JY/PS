package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.ArrayDeque

class Solution1 {

    companion object {
        const val MAX_COORDINATE = 500000
        const val MIN_COORDINATE = 0

        val commands = listOf({ x: Int -> x + 1 }, { x: Int -> x - 1 }, { x: Int -> x * 2 })

        fun main() {
            BufferedReader(InputStreamReader(System.`in`)).use { reader ->
                BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                    val (n, k) = reader.readLine().split(" ").map { it.toInt() }
                    val visited = Array(2) { BooleanArray(MAX_COORDINATE + 1) { false } }   // odd & even
                    val dq = ArrayDeque<Int>()

                    var seconds = 0
                    dq.addLast(n)
                    visited[seconds % 2][n] = true
                    // BFS
                    while (dq.isNotEmpty()) {
                        repeat(dq.size) {
                            val current = dq.removeFirst()
                            val target = k + ((seconds * (seconds + 1) / 2))

                            if (target > MAX_COORDINATE) {
                                writer.writeLine(-1)
                                return
                            }

                            // BFS 성질 때문에 이전에 수빈이 방문한 시간 < 현재 시간
                            // 이 문제에서 규칙으로 현재시간을 2로 나눈 나머지가 방문한 시간을 2로 나눈 나머지와 같아야함
                            // 과거에 3초에 방문했다면 현재시간 7초에 동생 위치를 수빈은 방문할 수 있음.
                            // 현재위치, 현재위치 + 1, 현재위치 - 1 ...
                            if (visited[seconds % 2][target]) {
                                writer.writeLine(seconds)
                                return
                            }

                            // 수빈 방문
                            val nextSeconds = seconds + 1
                            for (c in commands) {
                                val next = c(current)
                                if (next > MAX_COORDINATE || next < MIN_COORDINATE) {
                                    continue
                                }
                                if (visited[nextSeconds % 2][next]) {
                                    continue
                                }
                                visited[nextSeconds % 2][next] = true
                                dq.addLast(next)
                            }
                        }
                        ++seconds
                    }
                    writer.writeLine(-1)
                }
            }
        }

        private fun BufferedWriter.writeLine(v: Int) {
            this.write("$v")
            this.newLine()
        }
    }
}
