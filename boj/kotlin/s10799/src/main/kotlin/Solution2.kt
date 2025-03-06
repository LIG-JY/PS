package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution2 {
    fun main(args: Array<String>) {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                var res = 0
                val dq = ArrayDeque<Pair<Int, Char>>()
                reader.readLine().forEachIndexed { index, c ->
                    when (c) {
                        '(' -> {
                            dq.addLast(index to c)
                        }

                        ')' -> {
                            if (dq.last().first + 1 == index) { // laser
                                dq.removeLast()
                                res += dq.size
                            } else {
                                dq.removeLast()
                                res++
                            }
                        }
                    }
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
