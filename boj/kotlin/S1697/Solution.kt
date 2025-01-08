package kotlin.S1697

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        data class Struct(val l: Int, val t: Int)

        val MAX_C = 100000
        val MIN_C = 0
        val INITIAL_TIME = 0
        val COMMANDS = listOf({ num: Int -> num * 2 }, { num: Int -> num + 1 }, { num: Int -> num - 1 })
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, k) = reader.readLine().split(" ").map { it.toInt() }

                // Early exit
                if (n >= k) {
                    writer.writeLine(n - k)
                    return
                }

                val visited = BooleanArray(MAX_C + 1) { false }
                val dq = ArrayDeque<Struct>()
                visited[n] = true
                dq.add(Struct(n, INITIAL_TIME))
                while (dq.isNotEmpty()) {
                    val current = dq.removeFirst()
                    for (i in COMMANDS.indices) {
                        val command = COMMANDS[i]
                        // 현재 위치가 k보다 크면 *2, +1 연산 생략
                        if (current.l > k) {
                            if (i == 0 || i == 1) {
                                continue
                            }
                        }
                        val newLocation = command(current.l)
                        if (newLocation > MAX_C || newLocation < MIN_C) {
                            continue
                        }
                        if (visited[newLocation]) {
                            continue
                        }
                        if (newLocation == k) {
                            writer.writeLine(current.t + 1)
                            return
                        }
                        visited[newLocation] = true
                        dq.addLast(Struct(newLocation, current.t + 1))
                    }
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }
}
