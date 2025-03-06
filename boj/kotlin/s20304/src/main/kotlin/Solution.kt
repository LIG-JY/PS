package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    companion object {
        const val UNVISITED = -1
        const val MIN_SAFETY_DISTANCE = 0
    }

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val n = reader.readLine().toInt()
                val m = reader.readLine().toInt()   // unused
                val passwords = reader.readLine().split(" ").map { it.toInt() }
                val safetyDistances = IntArray(n + 1) { UNVISITED }
                val dq = ArrayDeque<Int>()

                for (p in passwords) {
                    safetyDistances[p] = MIN_SAFETY_DISTANCE
                    dq.addLast(p)
                }

                while (dq.isNotEmpty()) {
                    val password = dq.removeFirst()
                    for (bitflag in 0..20) {    // max value of N: 1_000_000 =~ 2^20
                        val newPassword = password.xor(1.shl(bitflag))
                        if (newPassword > n || safetyDistances[newPassword] != UNVISITED) {
                            continue
                        }
                        safetyDistances[newPassword] = safetyDistances[password] + 1
                        dq.addLast(newPassword)
                    }
                }
                writer.writeLine(safetyDistances.max())
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Int) {
        this.write("$v")
        this.newLine()
    }
}