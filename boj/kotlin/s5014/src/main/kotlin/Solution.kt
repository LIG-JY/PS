package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        fun main() {
            BufferedReader(InputStreamReader(System.`in`)).use { reader ->
                BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                    val (F, S, G, U, D) = reader.readLine().split(" ").map { it.toInt() }
                    val commands = intArrayOf(U, -D)
                    val visited = BooleanArray(F + 1) { false }
                    val dq = ArrayDeque<Int>()

                    var turn = 0
                    visited[S] = true
                    dq.addLast(S)
                    while (dq.isNotEmpty()) {
                        repeat(dq.size) {
                            val cur = dq.removeFirst()

                            if (cur == G) {
                                writer.writeLine(turn)
                                return
                            }

                            for (c in commands) {
                                val nxt = cur + c
                                if (nxt > F || nxt < 1) {
                                    continue
                                }
                                if (visited[nxt]) {
                                    continue
                                }
                                visited[nxt] = true
                                dq.addLast(nxt)
                            }
                        }
                        ++turn
                    }
                    writer.writeLine("use the stairs")
                }
            }
        }

        private fun BufferedWriter.writeLine(v: Any) {
            this.write("$v")
            this.newLine()
        }
    }
}
