package kotlin.S2504

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main(args: Array<String>) {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                var result = 0
                var temp = 1
                val dq = ArrayDeque<Pair<Int, Char>>()
                reader.readLine().forEachIndexed { index, ch ->
                    when (ch) {
                        '(' -> {
                            dq.addLast(Pair(index, ch))
                            temp *= 2
                        }

                        '[' -> {
                            dq.addLast(Pair(index, ch))
                            temp *= 3
                        }

                        ')' -> {
                            if (dq.isEmpty() || dq.last().second == '[') {
                                writer.writeLine(0)
                                writer.flush()
                                return
                            }
                            if (dq.last().second == '(') {
                                if (dq.last().first + 1 == index) {
                                    result += temp
                                }
                                temp /= 2
                                dq.removeLast()
                            }
                        }

                        ']' -> {
                            if (dq.isEmpty() || dq.last().second == '(') {
                                writer.writeLine(0)
                                writer.flush()
                                return
                            }
                            if (dq.last().second == '[') {
                                if (dq.last().first + 1 == index) {
                                    result += temp
                                }
                                temp /= 3
                                dq.removeLast()
                            }
                        }
                    }
                }
                if (dq.isNotEmpty()) {
                    writer.writeLine(0)
                    writer.flush()
                    return
                }
                writer.writeLine(result)
                writer.flush()
            }
        }
    }

    private fun BufferedWriter.writeLine(value: Int) {
        this.write(value.toString())
        this.newLine()
    }
}
