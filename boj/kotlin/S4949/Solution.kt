package kotlin.S4949

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main(args: Array<String>) {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                while (true) {
                    val input = reader.readLine()
                    if (input.length == 1) {
                        break
                    }
                    if (isValid(input)) {
                        writer.writeLine("yes")
                    } else {
                        writer.writeLine("no")
                    }
                }
                writer.flush()
            }
        }
    }

    private fun isValid(str: String): Boolean {
        val stack = ArrayDeque<Char>()
        val matchingBrackets = mapOf(')' to '(', ']' to '[')
        for (c in str.toCharArray()) {
            when (c) {
                '(', '[' -> {
                    stack.addLast(c)
                }

                in matchingBrackets -> {
                    if (stack.isNotEmpty() && stack.last() == matchingBrackets[c]) {
                        stack.removeLast()
                    } else {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }

    private fun BufferedWriter.writeLine(str: String) {
        write(str)
        this.newLine()
    }
}
