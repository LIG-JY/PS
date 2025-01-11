package kotlin.S1182

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution1 {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().trim().split(' ').map { it.toInt() }
                val sequence = reader.readLine().trim().split(' ').map { it.toInt() }
                var count = 0;

                fun combinationRecursive(sequencePtr: Int, scratchPtr: Int, size: Int, scratch: IntArray) {
                    if (scratchPtr >= size) {
                        val sum = scratch.sum()
                        if (sum == m) ++count
                        return
                    }
                    for (i in sequencePtr until sequence.size) {
                        scratch[scratchPtr] = sequence[i]
                        combinationRecursive(i + 1, scratchPtr + 1, size, scratch)
                    }
                }

                for (size in 1..n) {
                    val scratch = IntArray(size)
                    combinationRecursive(0, 0, size, scratch)
                }
                writer.writeLine(count)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
