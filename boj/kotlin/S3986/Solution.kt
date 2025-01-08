package kotlin.S3986

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                var res = 0
                val dq = ArrayDeque<Char>(100)
                val n = reader.readLine().toInt()
                require(n in 1..100)
                repeat(n) {
                    reader.readLine().forEach { c ->
                        if (dq.isNotEmpty() && dq.last() == c) {
                            dq.removeLast()
                        } else {
                            dq.addLast(c)
                        }
                    }
                    if (dq.isEmpty()) {
                        res++
                    }
                    dq.clear()
                }
                writer.writeLine(res)
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }
}
