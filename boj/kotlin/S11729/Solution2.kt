package kotlin.S11729

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2 {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val input = reader.readLine().toInt()
                val result = ArrayDeque<Pair<Int, Int>>()

                fun hanoiRecursive(num: Int, from: Int, aux: Int, to: Int) {
                    if (num == 1) {
                        result.addLast(from to to)
                        return
                    }
                    hanoiRecursive(num - 1, from, to, aux)
                    hanoiRecursive(1, from, aux, to)
                    hanoiRecursive(num - 1, aux, from, to)
                }

                hanoiRecursive(input, 1, 2, 3)
                writer.writeLine(result.size)
                result.forEach { writer.writeLine("${it.first} ${it.second}") }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
