package kotlin.S1182

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution3 {

    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().trim().split(' ').map { it.toInt() }
                val sequence = reader.readLine().trim().split(' ').map { it.toInt() }.sorted()
                var count = 0;

                fun chooseRecursive(sequencePtr: Int, sum: Int) {
                    if (sequencePtr >= n) {
                        if (sum == m) ++count
                        return
                    }
                    chooseRecursive(sequencePtr + 1, sum)
                    chooseRecursive(sequencePtr + 1, sum + sequence[sequencePtr])
                }

                chooseRecursive(0, 0)
                if (m == 0) --count
                writer.writeLine(count)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
