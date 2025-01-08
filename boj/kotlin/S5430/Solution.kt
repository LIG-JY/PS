package kotlin.S5430

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
    fun main(args: Array<String>) {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val t = reader.readLine().toInt()

                repeat(t) {
                    val commands = reader.readLine()
                    val n = reader.readLine().toInt()
                    val tokenizer = StringTokenizer(reader.readLine(), "[],")
                    val dq = ArrayDeque<Int>(n)
                    repeat(n) {
                        dq.addLast(tokenizer.nextToken().toInt())
                    }
                    processCommands(commands, dq, writer)
                }
                writer.flush()
            }
        }
    }

    private fun processCommands(commands: String, dq: ArrayDeque<Int>, writer: BufferedWriter) {
        var isReversed = false

        for (c in commands) {
            when (c) {
                'R' -> {
                    isReversed = !isReversed
                }

                'D' -> {
                    if (dq.isEmpty()) {
                        writer.writeLine("error")
                        return
                    }
                    if (isReversed) {
                        dq.removeLast()
                    } else {
                        dq.removeFirst()
                    }
                }
            }
        }
        val sb = StringBuilder()
        if (isReversed) {
            sb.append(dq.reversed().joinToString(separator = ",", prefix = "[", postfix = "]"))
        } else {
            sb.append(dq.joinToString(separator = ",", prefix = "[", postfix = "]"))
        }
        writer.writeLine(sb.toString())
    }

    private fun BufferedWriter.writeLine(str: String) {
        write(str)
        this.newLine()
    }
}
