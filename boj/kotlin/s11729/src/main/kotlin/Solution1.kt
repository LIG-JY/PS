package com.g2s

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Solution1 {
    fun main() {
        BufferedReader(InputStreamReader(System.`in`)).use { reader ->
            BufferedWriter(OutputStreamWriter(System.out)).use { writer ->
                val input = reader.readLine().toInt()
                val disks = Array(4) { ArrayDeque<Int>() }
                for (i in input downTo 1) {
                    disks[1].addLast(i)
                }

                val result = ArrayDeque<Pair<Int, Int>>()

                fun hanoiRecursive(target: ArrayDeque<Int>, from: Int, aux: Int, to: Int) {
                    if (target.size == 1) {
                        disks[to].addLast(disks[from].removeLast())
                        result.add(from to to)
                        return
                    }
                    val part = ArrayDeque<Int>()
                    part.addLast(target.removeFirst())
                    hanoiRecursive(ArrayDeque(target), from, to, aux)
                    hanoiRecursive(ArrayDeque(part), from, aux, to)
                    hanoiRecursive(ArrayDeque(target), aux, from, to)
                }

                hanoiRecursive(ArrayDeque(disks[1]), 1, 2, 3)
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
