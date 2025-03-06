package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->

                fun calculateRecursiveCall(s: String) {
                    var result = 0

                    fun isPalindromeRecursive(s: String, start: Int, end: Int): Boolean {
                        ++result
                        if (start >= end) return true
                        if (s[start] != s[end]) return false
                        return isPalindromeRecursive(s, start = start + 1, end = end - 1)
                    }

                    val isPalindrome = if (isPalindromeRecursive(s, 0, s.length - 1)) 1 else 0
                    writer.writeLine("$isPalindrome $result")
                }

                val n = reader.readLine().toInt()
                repeat(n) {
                    calculateRecursiveCall(reader.readLine())
                }
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
