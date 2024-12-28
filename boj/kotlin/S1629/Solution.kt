package kotlin.S1629

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (a, b, c) = reader.readLine().split(" ").map { it.toLong() }

                fun solveRecursive(a: Long, b: Long, m: Long): Long {
                    if (b == 0L) return 1L  // a^0 = 1
                    if (b == 1L) return (a % m)  // a^1 = a % m

                    val half = solveRecursive(a, b / 2, m)

                    return (half * half % m) * solveRecursive(a, b % 2, m) % m
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
