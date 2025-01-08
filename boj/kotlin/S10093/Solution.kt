package kotlin.S10093

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (a, b) = reader.readLine().split(" ").map { it.toLong() }
                val m = maxOf(a, b)
                val n = minOf(a, b)
                val count = maxOf(m - n - 1, 0)
                if (count > 0) {
                    writer.writeLine(m - n - 1)
                    for (num in n + 1 until m) {
                        writer.write("$num ")
                    }
                } else {
                    writer.writeLine(0)
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Long) {
        write(value.toString())
        this.newLine()
    }
}
