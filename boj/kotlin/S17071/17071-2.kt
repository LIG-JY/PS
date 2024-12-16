package kotlin.S17071

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class S17071_2 {

    companion object {
        const val MAX_COORDINATE = 500000
        const val MIN_COORDINATE = 0
        const val UNVISITED = -1
    }

    val commands = listOf({ x: Int -> x + 1 }, { x: Int -> x - 1 }, { x: Int -> x * 2 })

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, k) = reader.readLine().split(" ").map { it.toInt() }
                val visitedTimes =
                    Array(2) { IntArray(MAX_COORDINATE + 1) { UNVISITED } }   // 2번째 배열의 인덱스(위치)에 처음으로 방문한 시간, 짝수/홀수 일 때 최초로 방문한 시간을 기록
                val dq = ArrayDeque<Int>()

                var time = 0
                visitedTimes[time % 2][n] = time
                dq.addLast(n)

                while (dq.isNotEmpty()) {
                    repeat(dq.size) {
                        val current = dq.removeFirst()
                        val nextTime = time + 1
                        for (c in commands) {
                            val next = c(current)   // 다음 위치
                            if (next > MAX_COORDINATE || next < MIN_COORDINATE) {
                                continue
                            }
                            if (visitedTimes[nextTime % 2][next] != UNVISITED) {
                                continue
                            }
                            visitedTimes[nextTime % 2][next] = nextTime
                            dq.addLast(next)
                        }
                    }
                    ++time
                }

                var target = k
                for (t in 0..time) {
                    target += t
                    if (target > MAX_COORDINATE) {
                        writer.writeLine(-1)
                        return
                    }

                    if (visitedTimes[t % 2][target] != UNVISITED && visitedTimes[t % 2][target] <= t) {
                        writer.writeLine(t)
                        return
                    }
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
