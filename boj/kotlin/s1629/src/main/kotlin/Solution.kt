package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (a, b, c) = reader.readLine().split(" ").map { it.toLong() }

                fun solveRecursive(num: Long, expo: Long, divisor: Long): Long {
                    if (expo == 0L) return 1L  // a^0 = 1
                    if (expo == 1L) return (num % divisor)  // a^1 = a % m

                    val half = solveRecursive(num, expo / 2, divisor)

                    return (((half * half) % divisor) * solveRecursive(num, expo % 2, divisor)) % divisor
                }

                writer.writeLine(solveRecursive(a, b, c))
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
