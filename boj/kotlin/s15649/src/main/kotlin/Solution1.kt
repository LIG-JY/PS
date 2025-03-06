package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution1 {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val (n, m) = reader.readLine().split(" ").map { it.toInt() }

                fun solveRecursive(used: BooleanArray, bucket: MutableList<Int>) {
                    if (bucket.size == m) {
                        writer.writeLine(bucket.joinToString(" "))
                        return
                    }
                    for (i in 1..n) {
                        if (used[i]) continue
                        val newBucket = bucket.toMutableList()
                        newBucket.add(i)
                        val newUsed = used.copyOf()
                        newUsed[i] = true
                        solveRecursive(newUsed, newBucket)
                    }
                }

                val used = BooleanArray(n + 1) { false }
                val bucket = mutableListOf<Int>()
                solveRecursive(used, bucket)
            }
        }
    }

    private fun BufferedWriter.writeLine(v: Any) {
        this.write("$v")
        this.newLine()
    }
}
