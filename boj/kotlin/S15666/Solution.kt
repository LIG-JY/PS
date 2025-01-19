package kotlin.S15666

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }
                val input = reader.readLine().split(" ").map { it.toInt() }.sorted()
                val dq = ArrayDeque<Int>()

                fun printRecursive(start: Int) {
                    if (dq.size == m) {
                        writer.writeLine(dq.joinToString(" "))
                        return
                    }

                    val set = HashSet<Int>()

                    for (i in start until n) {
                        if (set.contains(input[i])) continue
                        dq.addLast(input[i])
                        set.add(input[i])
                        printRecursive(i)
                        dq.removeLast()
                    }
                }

                printRecursive(0)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
